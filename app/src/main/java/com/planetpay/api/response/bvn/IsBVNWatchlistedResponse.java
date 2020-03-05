package com.planetpay.api.response.bvn;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class IsBVNWatchlistedResponse {

    @SerializedName("ResponseCode")
    @Expose
    private String responseCode;
    @SerializedName("BVN")
    @Expose
    private String bVN;
    @SerializedName("BankCode")
    @Expose
    private String bankCode;
    @SerializedName("Category")
    @Expose
    private String category;
    @SerializedName("WatchListed")
    @Expose
    private String watchListed;

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getBVN() {
        return bVN;
    }

    public void setBVN(String bVN) {
        this.bVN = bVN;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getWatchListed() {
        return watchListed;
    }

    public void setWatchListed(String watchListed) {
        this.watchListed = watchListed;
    }

}