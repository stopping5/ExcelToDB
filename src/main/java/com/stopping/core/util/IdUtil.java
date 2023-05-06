package com.stopping.core.util;

/**
 * 全局唯一ID工具类
 */
public class IdUtil {
    /**
     * 通过雪花算法生成唯一ID
     * @return
     */
    public static String generateSnowflakeID(){
       return cn.hutool.core.util.IdUtil.getSnowflake().nextIdStr();
    }

    /**
     * 生成UUID
     * @return
     */
    public static String generateUuid(){
        return cn.hutool.core.util.IdUtil.fastUUID();
    }
}
