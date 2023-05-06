package com.stopping.core.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BusinessException extends RuntimeException{
    private Integer code;

    private String message;

    private Object data;

    public static BusinessException success(){
        return new BusinessException(200,"success",null);
    }
}
