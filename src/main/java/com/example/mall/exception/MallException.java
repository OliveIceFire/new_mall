package com.example.mall.exception;

public class MallException extends Exception{
    private final Integer code;
    private final String message;

    public MallException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public MallException(MallExceptionEnum exceptionEnum){
        this(exceptionEnum.getCode(), exceptionEnum.getMsg());
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
