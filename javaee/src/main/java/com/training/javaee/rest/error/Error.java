package com.training.javaee.rest.error;


public class Error {

    private int    errorCode;
    private int    errorCategory;
    private String desc;

    public static Error createError() {
        return new Error();
    }

    public int getErrorCode() {
        return errorCode;
    }

    public Error setErrorCode(int errorCodeParam) {
        errorCode = errorCodeParam;
        return this;
    }

    public int getErrorCategory() {
        return errorCategory;
    }

    public Error setErrorCategory(int errorCategoryParam) {
        errorCategory = errorCategoryParam;
        return this;
    }

    public String getDesc() {
        return desc;
    }

    public Error setDesc(String descParam) {
        desc = descParam;
        return this;
    }


}
