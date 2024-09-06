package com.stopping.pojo.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

/**
 * 上传数据DTO
 * @author stopping
 */
@Data
public class UploadDataDTO {
    /**
     * 上传数据映射表id
     */
    private Integer tableId;
    /**
     * 上传文件流
     */
    private MultipartFile file;
}
