package com.mycompany.dto;

public class ResponseDTO {
    private Integer errorCode;
    private String errorMessage;
    private String successMesaage;
    private Object obj;

    private ResponseDTO() {
    }

    public static ResponseDTO of(Object obj){
        ResponseDTO res = new ResponseDTO();
        res.obj = obj;
        return res;
    }

    public static ResponseDTO of(Object obj, Integer errorCode, String errorMessage){
        ResponseDTO res = new ResponseDTO();
        res.obj = obj;
        res.errorCode = errorCode;
        res.errorMessage = errorMessage;
        return res;
    }

    public static ResponseDTO of(Object obj, String successMesaage){
        ResponseDTO res = new ResponseDTO();
        res.obj = obj;
        res.successMesaage = successMesaage;
        return res;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errprCode) {
        this.errorCode = errprCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getSuccessMesaage() {
        return successMesaage;
    }

    public void setSuccessMesaage(String successMesaage) {
        this.successMesaage = successMesaage;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }
}
