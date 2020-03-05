package com.planetpay.api.response.bvn;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetSingleBVNResponse {

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
    @SerializedName("PhoneNumber1")
    @Expose
    private String phoneNumber1;
    @SerializedName("RegistrationDate")
    @Expose
    private String registrationDate;
    @SerializedName("EnrollmentBank")
    @Expose
    private String enrollmentBank;
    @SerializedName("EnrollmentBranch")
    @Expose
    private String enrollmentBranch;
    @SerializedName("Email")
    @Expose
    private String email;
    @SerializedName("Gender")
    @Expose
    private String gender;
    @SerializedName("PhoneNumber2")
    @Expose
    private String phoneNumber2;
    @SerializedName("LevelOfAccount")
    @Expose
    private String levelOfAccount;
    @SerializedName("LgaOfOrigin")
    @Expose
    private String lgaOfOrigin;
    @SerializedName("LgaOfResidence")
    @Expose
    private String lgaOfResidence;
    @SerializedName("MaritalStatus")
    @Expose
    private String maritalStatus;
    @SerializedName("NIN")
    @Expose
    private String nIN;
    @SerializedName("NameOnCard")
    @Expose
    private String nameOnCard;
    @SerializedName("Nationality")
    @Expose
    private String nationality;
    @SerializedName("ResidentialAddress")
    @Expose
    private String residentialAddress;
    @SerializedName("StateOfOrigin")
    @Expose
    private String stateOfOrigin;
    @SerializedName("StateOfResidence")
    @Expose
    private String stateOfResidence;
    @SerializedName("Title")
    @Expose
    private String title;
    @SerializedName("WatchListed")
    @Expose
    private String watchListed;
    @SerializedName("Base64Image")
    @Expose
    private String base64Image;

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

    public String getPhoneNumber1() {
        return phoneNumber1;
    }

    public void setPhoneNumber1(String phoneNumber1) {
        this.phoneNumber1 = phoneNumber1;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber2() {
        return phoneNumber2;
    }

    public void setPhoneNumber2(String phoneNumber2) {
        this.phoneNumber2 = phoneNumber2;
    }

    public String getLevelOfAccount() {
        return levelOfAccount;
    }

    public void setLevelOfAccount(String levelOfAccount) {
        this.levelOfAccount = levelOfAccount;
    }

    public String getLgaOfOrigin() {
        return lgaOfOrigin;
    }

    public void setLgaOfOrigin(String lgaOfOrigin) {
        this.lgaOfOrigin = lgaOfOrigin;
    }

    public String getLgaOfResidence() {
        return lgaOfResidence;
    }

    public void setLgaOfResidence(String lgaOfResidence) {
        this.lgaOfResidence = lgaOfResidence;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getNIN() {
        return nIN;
    }

    public void setNIN(String nIN) {
        this.nIN = nIN;
    }

    public String getNameOnCard() {
        return nameOnCard;
    }

    public void setNameOnCard(String nameOnCard) {
        this.nameOnCard = nameOnCard;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getResidentialAddress() {
        return residentialAddress;
    }

    public void setResidentialAddress(String residentialAddress) {
        this.residentialAddress = residentialAddress;
    }

    public String getStateOfOrigin() {
        return stateOfOrigin;
    }

    public void setStateOfOrigin(String stateOfOrigin) {
        this.stateOfOrigin = stateOfOrigin;
    }

    public String getStateOfResidence() {
        return stateOfResidence;
    }

    public void setStateOfResidence(String stateOfResidence) {
        this.stateOfResidence = stateOfResidence;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWatchListed() {
        return watchListed;
    }

    public void setWatchListed(String watchListed) {
        this.watchListed = watchListed;
    }

    public String getBase64Image() {
        return base64Image;
    }

    public void setBase64Image(String base64Image) {
        this.base64Image = base64Image;
    }

}