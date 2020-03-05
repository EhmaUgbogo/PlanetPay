package com.planetpay.api;

import com.planetpay.api.response.bvn.BaseResponse;
import com.planetpay.api.response.bvn.GetSingleBVNResponse;
import com.planetpay.api.response.bvn.IsBVNWatchlistedResponse;
import com.planetpay.api.response.bvn.ResetResponse;
import com.planetpay.api.response.bvn.ValidateRecordBody;
import com.planetpay.api.response.bvn.ValidateRecordResponse;
import com.planetpay.api.response.bvn.VerifySingleBVNResponse;
import com.planetpay.api.response.sms.SmsBody;
import com.planetpay.api.response.transfer.InterBankTransferBody;
import com.planetpay.api.response.transfer.InterBankTransferResponse;
import com.planetpay.api.response.transfer.InterbankNameEnquiry;
import com.planetpay.api.response.transfer.InterbankNameEnquiryResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface PlanetPayApi {

    @Headers({"Content-Type:application/json"})
    @POST("nibss/bvnr/Reset")
    Call<ResetResponse> bvnValidationReset(@Header("OrganisationCode") String orgCodeInBASE64, @Header("Sandbox-Key") String sandboxKey);

    @Headers({"Accept:application/json","Content-Type:application/json"})
    @POST("nibss/bvnr/VerifySingleBVN")
    Call<BaseResponse<VerifySingleBVNResponse>> verifySingleBVN(@Header("OrganisationCode") String orgCodeInBASE64,
                                                                @Header("Sandbox-Key") String sandboxKey,
                                                                @Header("Authorization") String authHeader,
                                                                @Header("SIGNATURE") String signatureHeader,
                                                                @Header("SIGNATURE_METH") String signatureMethodHeader,
                                                                @Query("BVN") String bvn /*use @Body with object if query did'nt work*/);
/*

    @Headers({"Accept:application/json","Content-Type:application/json"})
    @POST("bvnr/VerifyMultipleBVN")
    Call<MultipleBaseResponse<VerifySingleBVNResponse>> verifyMultipleBVN(@Header("OrganisationCode") String orgCodeInBASE64,
                                                               @Header("Sandbox-Key") String sandboxKey,
                                                               @Header("Authorization") String authHeader,
                                                               @Header("SIGNATURE") String signatureHeader,
                                                               @Header("SIGNATURE_METH") String signatureMethodHeader,
                                                               @Query("BVNS") String bvnsSeparatedByComma */
/*use @Body with object if query did'nt work*//*
);
*/

    @Headers({"Accept:application/json","Content-Type:application/json"})
    @POST("nibss/bvnr/GetSingleBVN")
    Call<BaseResponse<GetSingleBVNResponse>> GetSingleBVN(@Header("OrganisationCode") String orgCodeInBASE64,
                                                          @Header("Sandbox-Key") String sandboxKey,
                                                          @Header("Authorization") String authHeader,
                                                          @Header("SIGNATURE") String signatureHeader,
                                                          @Header("SIGNATURE_METH") String signatureMethodHeader,
                                                          @Query("BVN") String bvn /*use @Body with object if query did'nt work*/);

    @Headers({"Accept:application/json","Content-Type:application/json"})
    @POST("nibss/bvnr/IsBVNWatchlisted")
    Call<BaseResponse<IsBVNWatchlistedResponse>> IsBVNWatchlisted(@Header("OrganisationCode") String orgCodeInBASE64,
                                                                  @Header("Sandbox-Key") String sandboxKey,
                                                                  @Header("Authorization") String authHeader,
                                                                  @Header("SIGNATURE") String signatureHeader,
                                                                  @Header("SIGNATURE_METH") String signatureMethodHeader,
                                                                  @Query("BVN") String bvn /*use @Body with object if query did'nt work*/);


    /*********************************************  BVN Placeholder   **********************************************/

    @Headers({"Content-Type:application/json"})
    @POST("nibss/BVNPlaceHolder/Reset")
    Call<ResetResponse> bvnPlaceHolderReset(@Header("OrganisationCode") String orgCodeInBASE64, @Header("Sandbox-Key") String sandboxKey);


    @Headers({"Accept:application/json","Content-Type:application/json"})
    @POST("nibss/BVNPlaceHolder/ValidateRecord")
    Call<BaseResponse<ValidateRecordResponse>> validateRecord(@Header("OrganisationCode") String orgCodeInBASE64,
                                                @Header("Sandbox-Key") String sandboxKey,
                                                @Header("Authorization") String authHeader,
                                                @Header("SIGNATURE") String signatureHeader,
                                                @Header("SIGNATURE_METH") String signatureMethodHeader,
                                                @Body() ValidateRecordBody validateRecordBody);

/*

    @Headers({"Accept:application/json","Content-Type:application/json"})
    @POST("nibss/BVNPlaceHolder/ValidateRecords")
    Call<BaseResponse<ValidateRecordResponse>> validateRecords(@Header("OrganisationCode") String orgCodeInBASE64,
                                                              @Header("Sandbox-Key") String sandboxKey,
                                                              @Header("Authorization") String authHeader,
                                                              @Header("SIGNATURE") String signatureHeader,
                                                              @Header("SIGNATURE_METH") String signatureMethodHeader,
                                                              @Body() ValidateRecordBody validateRecordBody);
*/


    /*********************************************  BVN Fingerprint Matching    **********************************************/

    /*@Headers({"Accept:application/json","Content-Type:application/json"})
    @POST("nibss/fp/Reset")
    Call<ResetResponse> fingerPrintMatchingReset(@Header("OrganisationCode") String orgCodeInBASE64, @Header("Sandbox-Key") String sandboxKey);

*/


    /***********************************************************************************************************************/
    /*********************************************  Sterling Interbank Name Enquiry     **********************************************/
    /***********************************************************************************************************************/


    @Headers({"Ocp-Apim-Subscription-Key:t","Ocp-Apim-Trace:true","Appid:69","Content-Type:application/json","ipval:0"})
    @GET("sterling/TransferAPIs/api/Spay/InterbankNameEnquiry?")
    Call<BaseResponse<InterbankNameEnquiryResponse>> interBankNameEnquiry(@Header("Sandbox-Key") String sandboxKey, @Body InterbankNameEnquiry interbankNameEnquiry);

    @Headers({"Ocp-Apim-Subscription-Key:t","Ocp-Apim-Trace:true","Appid:69","Content-Type:application/json","ipval:0"})
    @POST("accountapi/api/Spay/InterbankTransferReq")
    Call<BaseResponse<InterBankTransferResponse>> interBankTransfer(@Header("Sandbox-Key") String sandboxKey, @Body InterBankTransferBody interBankTransferBody);


    /***********************************************************************************************************************/
    /*********************************************  Africa's Talking Sms     **********************************************/
    /***********************************************************************************************************************/

    @Headers({"Content-Type:application/json"})
    @POST("atlabs/messaging")
    Call<BaseResponse<InterBankTransferResponse>> sendSms(@Header("Sandbox-Key") String sandboxKey, @Body SmsBody smsBody);








}
