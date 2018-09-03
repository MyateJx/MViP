package com.myatejx.architecture.business.bus;

/**
 * @author KunMinX
 * @date 2018/8/22
 */
public class Result {

    private int resultCode;
    private Object resultObject;
    private String businessType;

    public Result(String businessType, int resultCode, Object resultObject) {
        this.resultCode = resultCode;
        this.resultObject = resultObject;
        this.businessType = businessType;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public Object getResultObject() {
        return resultObject;
    }

    public void setResultObject(Object resultObject) {
        this.resultObject = resultObject;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }
}
