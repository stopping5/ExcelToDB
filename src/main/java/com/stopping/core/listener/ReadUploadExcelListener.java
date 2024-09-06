package com.stopping.core.listener;

import cn.hutool.crypto.digest.DigestUtil;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.read.listener.ReadListener;
import com.stopping.model.ExcelFieldConfig;
import com.stopping.model.ExcelTableConfig;
import com.stopping.pojo.dto.ExcelFieldInfoDTO;
import com.stopping.pojo.dto.ExcelTableInfoDTO;
import com.stopping.service.BatchDataService;
import com.stopping.service.ExcelFieldConfigService;
import com.stopping.service.ExcelTableConfigService;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 读取上传的Excel
 */
@Slf4j
public class ReadUploadExcelListener extends AnalysisEventListener<Map<Integer, String>>  {

    private ExcelTableInfoDTO excelTableInfo;
    //保存的数据 key是数据hash值用于判断是否重复，val是excel读取的原数据
    private List<Map<Integer, String>> saveDataMap = new ArrayList<>();

    //插入数据阈值 默认10000
    private final static Integer INSERT_DATA_THRESHOLD = 10000;

    //参与唯一属性校验的字段集合
    private final static List<ExcelFieldInfoDTO> KEY_HEAD = new ArrayList<>();

    private final static String PARAM_PRE = "(";

    private final static String PARAM_END = ")";

    private final static String SPLIT = ",";

    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
        log.info("tableId:{},表头信息:{}",tableId,headMap);
        //通过tableId映射获取到表头字段的信息
        ExcelTableConfigService excelTableConfigService = applicationContext.getBean(ExcelTableConfigService.class);
        ExcelTableConfig tableConfig = excelTableConfigService.findById(tableId);
        //获取表字段配置数据
        ExcelFieldConfigService excelFieldConfigService = applicationContext.getBean(ExcelFieldConfigService.class);
        List<ExcelFieldConfig> excelFieldConfigs = excelFieldConfigService.queryExcelFieldConfigInfoByTableId(tableId);
        //封装参数
        excelTableInfo = new ExcelTableInfoDTO();
        excelTableInfo.setDbTableName(tableConfig.getDbTableName())
                .setTableId(tableId)
                .setTableName(tableConfig.getExcelTableName())
                .setFieldConfigs(indexMap(headMap,excelFieldConfigs));

    }

    /**
     * 根据excel表头坐标封装字段配置参数
     * @param headMap 表头信息
     * @param excelFieldConfigs 该表字段配置集合
     * @return 字段配置及坐标位置信息
     */
    private  List<ExcelFieldInfoDTO> indexMap(Map<Integer, String> headMap,List<ExcelFieldConfig> excelFieldConfigs ){
        List<ExcelFieldInfoDTO> excelFieldInfos = new ArrayList<>(headMap.size());

        Map<String, ExcelFieldConfig> excelFieldConfigMap = excelFieldConfigs.stream().collect(Collectors.toMap(ExcelFieldConfig::getFieldName, val -> val));

        headMap.forEach((index,fieldName)->{
            ExcelFieldConfig excelFieldConfig = excelFieldConfigMap.get(fieldName);
            ExcelFieldInfoDTO excelFieldInfoDTO = new ExcelFieldInfoDTO();
            BeanUtils.copyProperties(excelFieldConfig,excelFieldInfoDTO);
            excelFieldInfoDTO.setIndex(index);
            excelFieldInfos.add(excelFieldInfoDTO);

            if (excelFieldConfig.getKeyColumn() == 1){
                KEY_HEAD.add(excelFieldInfoDTO);
            }
        });

        return excelFieldInfos;
    }

    /**
     * 关联表id
     */
    private final Integer tableId;
    private ApplicationContext applicationContext;

    public ReadUploadExcelListener(Integer tableId,ApplicationContext applicationContext) {
        this.tableId = tableId;
        this.applicationContext = applicationContext;
    }

    @Override
    public void invoke(Map<Integer, String> integerStringMap, AnalysisContext analysisContext) {
        //遍历每一行数据
        log.info("tableId:{},获取excel信息:{}",tableId,integerStringMap);
        //整理数据集合
        //关键字段进行md5加密
        StringBuffer dataHashVal = new StringBuffer();
        KEY_HEAD.forEach(config->{
            dataHashVal.append(integerStringMap.get(config.getIndex()));
        });

        //当数据大于阈值则执行保存逻辑
        if (saveDataMap.size() > INSERT_DATA_THRESHOLD){
            saveData(saveDataMap,excelTableInfo);
        }else {
            String hashCode = dataHashVal.toString().isEmpty() ? UUID.randomUUID().toString() : DigestUtil.md5Hex(dataHashVal.toString());
            saveDataMap.add(integerStringMap);
        }

    }

    private void saveData(List<Map<Integer, String>> saveDataMap,ExcelTableInfoDTO excelTableInfo){
        BatchDataService batchDataService = applicationContext.getBean(BatchDataService.class);

        List<ExcelFieldInfoDTO> fieldConfigs = excelTableInfo.getFieldConfigs();
        String param = "`%s`";
        Iterator<ExcelFieldInfoDTO> iterator = fieldConfigs.iterator();
        while (iterator.hasNext()){
            param = (String.format(param, iterator.next().getDbFieldName()));
            if (iterator.hasNext()){
                param += ",`%s`";
            }
        }

        String sqlParam = param.toString();
        log.info("SQL PARAM = {}",sqlParam);

        StringBuffer allVal = new StringBuffer();
        saveDataMap.forEach(data->{
            StringBuffer valBuffer = new StringBuffer(PARAM_PRE);
            data.forEach((k,v)->{
                valBuffer.append("'"+v+"'").append(SPLIT);
            });
            valBuffer.deleteCharAt(valBuffer.length()-1);
            valBuffer.append(PARAM_END);
            allVal.append(valBuffer).append(SPLIT);
        });
        allVal.deleteCharAt(allVal.length()-1);
        log.info("SQL Val = {}",allVal.toString());
        batchDataService.batchInsertData(excelTableInfo.getDbTableName(),sqlParam,allVal.toString());
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        saveData(saveDataMap,excelTableInfo);
    }

}
