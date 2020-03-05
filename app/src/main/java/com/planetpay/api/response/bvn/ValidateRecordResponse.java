package com.planetpay.api.response.bvn;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ValidateRecordResponse {

    @SerializedName("ResponseCode")
    @Expose
    private String responseCode;
    @SerializedName("BVN")
    @Expose
    private String bVN;
    @SerializedName("FirstName")
    @Expose
    private String firstName;
    @SerializedName("LastName")
    @Expose
    private String lastName;
    @SerializedName("MiddleName")
    @Expose
    private String middleName;
    @SerializedName("AccountNumber")
    @Expose
    private String accountNumber;
    @SerializedName("BankCode")
    @Expose
    private String bankCode;

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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

}