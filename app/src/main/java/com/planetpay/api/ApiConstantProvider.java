package com.planetpay.api;

import android.util.Base64;
import android.util.Log;

import java.security.MessageDigest;


public class ApiConstantProvider {
    private static final String TAG = "ApiConstantProvider";
    public static final String BASE_URL = "https://sandboxapi.fsi.ng/";
    public static final String SANDBOX_KEY = "8adec5df02eb9c59f64a8113e5c4f644";


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
    public static final String orgCodeInBASE64 = base64("1111");

    public static final String authString = username + ':' + password;
    // Encode it to Base64 and save it for it will be used later
    public static final String authHeader = base64(authString);


    /* All the data that is sent to the API via the body should be encrypted with AES-CBC algorithm and the responses from the API will need to be decrypted
    using the same AES-CBC algorithm. Therefore knowledge of encryption and decryption will ease the use of the APIs in this sandbox.
    You will also need to use SHA256, Base64 encryption for some API headers, */
    private static MessageDigest sha256(String signatureString) {
        return null;
    }

    public static String base64(String input) {
        String base64String = Base64.encodeToString(input.getBytes(), Base64.DEFAULT);
        Log.d(TAG, "base64: input: "+input+" base64: "+base64String);
        return base64String;
    }

}
