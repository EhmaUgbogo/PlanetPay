package com.planetpay.api.response.bvn;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResetResponse {

    @SerializedName("Ivkey")
    @Expose
    private String ivkey;
    @SerializedName("Aes_Key")
    @Expose
    private String aesKey;
    @SerializedName("Password")
    @Expose
    private String password;
    @SerializedName("Code")
    @Expose
    private String orgCode;

    public String getIvkey() {
        return ivkey;
    }

    public void setIvkey(String ivkey) {
        this.ivkey = ivkey;
    }

    public String getAesKey() {
        return aesKey;
    }

    public void setAesKey(String aesKey) {
        this.aesKey = aesKey;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    @Override
    public String toString() {
        return "ResetResponse{" +
                "ivkey='" + ivkey + '\'' +
                ", aesKey='" + aesKey + '\'' +
                ", password='" + password + '\'' +
                ", orgCode='" + orgCode + '\'' +
                '}';
    }
}
