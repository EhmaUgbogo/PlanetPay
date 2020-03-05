package com.planetpay.api;

import java.security.MessageDigest;

public class ApiConstantProvider {
    public static final String BASE_URL="https://sandboxapi.fsi.ng/nibss/";
    public static final String SANDBOX_KEY="8adec5df02eb9c59f64a8113e5c4f644";


    //TODO Authorization Header
    public static final String signatureMethodHeader = "SHA256";
    public static final String password = "YOUR_PASSOWRD";
    public static final String username = "YOUR_ORGANIZATION_CODE";
    // The date must be in the YYYYMMDD format
    public static final String date = "TODAYS_DATE";
    // Concatenate all three strings into one string
    public static final String signatureString = username + date + password;
    // Sign the derived string with the sha256 method with digest hex and save it for it will be used later

    //public static final String signatureHeader = sha256(signatureString).digest('hex');


    //TODO Authorization Header
    public static final String authString = username + ':' + password;
    // Encode it to Base64 and save it for it will be used later
    public static final String authHeader = base64(authString);



    private static MessageDigest sha256(String signatureString) {
        return null;
    }


    private static String base64(String authString) {
        return null;
    }
}
