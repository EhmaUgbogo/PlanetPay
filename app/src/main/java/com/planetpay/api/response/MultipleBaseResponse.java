package com.planetpay.api.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MultipleBaseResponse<T> {
    @SerializedName("ResponseCode")
    @Expose
    private String responseCode;
    @SerializedName("ValidationResponses")
    @Expose
    private T validationResponses;

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public T getValidationResponses() {
        return validationResponses;
    }

    public void setValidationResponses(T validationResponses) {
        this.validationResponses = validationResponses;
    }

}

