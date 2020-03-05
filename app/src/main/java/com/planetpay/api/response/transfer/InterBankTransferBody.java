package com.planetpay.api.response.transfer;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class InterBankTransferBody {

    @SerializedName("Referenceid")
    @Expose
    private String referenceid;
    @SerializedName("RequestType")
    @Expose
    private String requestType;
    @SerializedName("Translocation")
    @Expose
    private String translocationA;
    @SerializedName("SessionID")
    @Expose
    private String sessionID;
    @SerializedName("FromAccount")
    @Expose
    private String fromAccount;
    @SerializedName("ToAccount")
    @Expose
    private String toAccount;
    @SerializedName("Amount")
    @Expose
    private String amount;
    @SerializedName("DestinationBankCode")
    @Expose
    private String destinationBankCode;
    @SerializedName("NEResponse")
    @Expose
    private String nEResponse;
    @SerializedName("BenefiName")
    @Expose
    private String benefiName;
    @SerializedName("PaymentReference")
    @Expose
    private String paymentReference;
    @SerializedName("OriginatorAccountName")
    @Expose
    private String originatorAccountName;
    @SerializedName("translocation")
    @Expose
    private String translocationB;

    public String getReferenceid() {
        return referenceid;
    }

    public void setReferenceid(String referenceid) {
        this.referenceid = referenceid;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getTranslocationA() {
        return translocationA;
    }

    public void setTranslocationA(String translocationA) {
        this.translocationA = translocationA;
    }

    public String getSessionID() {
        return sessionID;
    }

    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }

    public String getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(String fromAccount) {
        this.fromAccount = fromAccount;
    }

    public String getToAccount() {
        return toAccount;
    }

    public void setToAccount(String toAccount) {
        this.toAccount = toAccount;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDestinationBankCode() {
        return destinationBankCode;
    }

    public void setDestinationBankCode(String destinationBankCode) {
        this.destinationBankCode = destinationBankCode;
    }

    public String getNEResponse() {
        return nEResponse;
    }

    public void setNEResponse(String nEResponse) {
        this.nEResponse = nEResponse;
    }

    public String getBenefiName() {
        return benefiName;
    }

    public void setBenefiName(String benefiName) {
        this.benefiName = benefiName;
    }

    public String getPaymentReference() {
        return paymentReference;
    }

    public void setPaymentReference(String paymentReference) {
        this.paymentReference = paymentReference;
    }

    public String getOriginatorAccountName() {
        return originatorAccountName;
    }

    public void setOriginatorAccountName(String originatorAccountName) {
        this.originatorAccountName = originatorAccountName;
    }

    public String getTranslocationB() {
        return translocationB;
    }

    public void setTranslocationB(String translocationB) {
        this.translocationB = translocationB;
    }

}