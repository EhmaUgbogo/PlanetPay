package com.planetpay.datastore;

import com.planetpay.api.PlanetPayApi;
import com.planetpay.api.RetrofitClient;
import com.planetpay.api.response.bvn.ResetResponse;

public class DataManager {
    private ResetResponse bvnResetResponse;

    private final PlanetPayApi planetPayApi;

    public DataManager() {
        planetPayApi = RetrofitClient.getInstance().create(PlanetPayApi.class);
    }

    public PlanetPayApi getPlanetPayApi() {
        return planetPayApi;
    }

    public ResetResponse getBvnResetResponse() {
        return bvnResetResponse;
    }

    public void setBvnResetResponse(ResetResponse bvnResetResponse) {
        this.bvnResetResponse = bvnResetResponse;
    }

    public boolean validateBvnResetResponse(){
        return bvnResetResponse!=null;
    }
}
