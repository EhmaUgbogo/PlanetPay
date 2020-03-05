package com.planetpay.api.response.transfer;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class InterBankTransferResponse {

    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("response")
    @Expose
    private String response;
    @SerializedName("responsedate")
    @Expose
    private String responsedate;
    @SerializedName("data")
    @Expose
    private Data data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getResponsedate() {
        return responsedate;
    }

    public void setResponsedate(String responsedate) {
        this.responsedate = responsedate;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }



    public class Data {

        @SerializedName("ResponseText")
        @Expose
        private String responseText;
        @SerializedName("status")
        @Expose
        private String status;

        public String getResponseText() {
            return responseText;
        }

        public void setResponseText(String responseText) {
            this.responseText = responseText;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }
}


