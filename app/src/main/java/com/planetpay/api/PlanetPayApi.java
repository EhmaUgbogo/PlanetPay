package com.planetpay.api;

import com.planetpay.api.response.BaseResponse;
import com.planetpay.api.response.MultipleBaseResponse;
import com.planetpay.api.response.ResetResponse;
import com.planetpay.api.response.VerifySingleBVNResponse;

import retrofit2.Call;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface PlanetPayApi {

    @Headers({"Content-Type:application/json"})
    @POST("bvnr/Reset")
    Call<ResetResponse> reset(@Header("OrganisationCode") String orgCodeInBASE64, @Header("Sandbox-Key") String sandboxKey);

    @Headers({"Accept:application/json","Content-Type:application/json"})
    @POST("bvnr/VerifySingleBVN")
    Call<BaseResponse<VerifySingleBVNResponse>> verifySingleBVN(@Header("OrganisationCode") String orgCodeInBASE64,
                                                                @Header("Sandbox-Key") String sandboxKey,
                                                                @Header("Authorization") String authHeader,
                                                                @Header("SIGNATURE") String signatureHeader,
                                                                @Header("SIGNATURE_METH") String signatureMethodHeader,
                                                                @Query("BVN") String bvn /*use @Body with object if query did'nt work*/);

    @Headers({"Accept:application/json","Content-Type:application/json"})
    @POST("bvnr/VerifyMultipleBVN")
    Call<MultipleBaseResponse<VerifySingleBVNResponse>> verifyMultipleBVN(@Header("OrganisationCode") String orgCodeInBASE64,
                                                               @Header("Sandbox-Key") String sandboxKey,
                                                               @Header("Authorization") String authHeader,
                                                               @Header("SIGNATURE") String signatureHeader,
                                                               @Header("SIGNATURE_METH") String signatureMethodHeader,
                                                               @Query("BVNS") String bvnsSeparatedByComma /*use @Body with object if query did'nt work*/);

    @Headers({"Accept:application/json","Content-Type:application/json"})
    @POST("bvnr/GetSingleBVN")
    Call<MultipleBaseResponse<VerifySingleBVNResponse>> GetSingleBVN(@Header("OrganisationCode") String orgCodeInBASE64,
                                                                     @Header("Sandbox-Key") String sandboxKey,
                                                                     @Header("Authorization") String authHeader,
                                                                     @Header("SIGNATURE") String signatureHeader,
                                                                     @Header("SIGNATURE_METH") String signatureMethodHeader,
                                                                     @Query("BVN") String bvn /*use @Body with object if query did'nt work*/);





}
