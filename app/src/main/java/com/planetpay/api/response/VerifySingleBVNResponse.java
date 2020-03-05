package com.planetpay.api.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VerifySingleBVNResponse {

    @SerializedName("ResponseCode")
    @Expose
    private String responseCode;
    @SerializedName("BVN")
    @Expose
    private String bVN;
    @SerializedName("FirstName")
    @Expose
    private String firstName;
    @SerializedName("MiddleName")
    @Expose
    private String middleName;
    @SerializedName("LastName")
    @Expose
    private String lastName;
    @SerializedName("DateOfBirth")
    @Expose
    private String dateOfBirth;
    @SerializedName("PhoneNumber")
    @Expose
    private String phoneNumber;
    @SerializedName("RegistrationDate")
    @Expose
    private String registrationDate;
    @SerializedName("EnrollmentBank")
    @Expose
    private String enrollmentBank;
    @SerializedName("EnrollmentBranch")
    @Expose
    private String enrollmentBranch;
    @SerializedName("WatchListed")
    @Expose
    private String watchListed;

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

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getEnrollmentBank() {
        return enrollmentBank;
    }

    public void setEnrollmentBank(String enrollmentBank) {
        this.enrollmentBank = enrollmentBank;
    }

    public String getEnrollmentBranch() {
        return enrollmentBranch;
    }

    public void setEnrollmentBranch(String enrollmentBranch) {
        this.enrollmentBranch = enrollmentBranch;
    }

    public String getWatchListed() {
        return watchListed;
    }

    public void setWatchListed(String watchListed) {
        this.watchListed = watchListed;
    }

}
