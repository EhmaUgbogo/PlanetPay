package com.planetpay.api.response.transfer;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class InterbankNameEnquiry {
    @SerializedName("Referenceid")
    @Expose
    private String referenceid;
    @SerializedName("RequestType")
    @Expose
    private Integer requestType;
    @SerializedName("Translocation")
    @Expose
    private String translocation;
    @SerializedName("ToAccount")
    @Expose
    private String toAccount;
    @SerializedName("destinationbankcode")
    @Expose
    private String destinationbankcode;

    public String getReferenceid() {
        return referenceid;
    }

    public void setReferenceid(String referenceid) {
        this.referenceid = referenceid;
    }

    public Integer getRequestType() {
        return requestType;
    }

    public void setRequestType(Integer requestType) {
        this.requestType = requestType;
    }

    public String getTranslocation() {
        return translocation;
    }

    public void setTranslocation(String translocation) {
        this.translocation = translocation;
    }

    public String getToAccount() {
        return toAccount;
    }

    public void setToAccount(String toAccount) {
        this.toAccount = toAccount;
    }

    public String getDestinationbankcode() {
        return destinationbankcode;
    }

    public void setDestinationbankcode(String destinationbankcode) {
        this.destinationbankcode = destinationbankcode;
    }
}
