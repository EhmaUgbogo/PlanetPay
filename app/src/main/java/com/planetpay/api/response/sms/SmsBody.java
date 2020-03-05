package com.planetpay.api.response.sms;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SmsBody {

    @SerializedName("to")
    @Expose
    private String to;
    @SerializedName("from")
    @Expose
    private String from;
    @SerializedName("message")
    @Expose
    private String message;

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}