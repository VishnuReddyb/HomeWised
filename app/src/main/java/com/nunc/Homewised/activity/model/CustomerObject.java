package com.nunc.Homewised.activity.model;

import java.io.Serializable;

/**
 * Created by nunc_dayal on 14-12-2015.
 */
public class CustomerObject  implements Serializable {
    private static final long serialVersionUID = 1L;

    //profileinfo
    private String company;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String phonenumber;
    private String mobilenumber;
    private String homenumber;
    private String fax;
    private String atEmail;

     private AddressObj primaryAddress;
  private AddressObj serviceAddress;

    public AddressObj getPrimaryAddress() {
        return primaryAddress;
    }

    public void setPrimaryAddress(AddressObj primaryAddress) {
        this.primaryAddress = primaryAddress;
    }

    public AddressObj getServiceAddress() {
        return serviceAddress;
    }

    public void setServiceAddress(AddressObj serviceAddress) {
        this.serviceAddress = serviceAddress;
    }

    //other info
    private String hearAboutUs;
    private String preferredCommuncation;
    private String industry;
    private String comment;
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getMobilenumber() {
        return mobilenumber;
    }

    public void setMobilenumber(String mobilenumber) {
        this.mobilenumber = mobilenumber;
    }

    public String getHomenumber() {
        return homenumber;
    }

    public void setHomenumber(String homenumber) {
        this.homenumber = homenumber;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getAtEmail() {
        return atEmail;
    }

    public void setAtEmail(String atEmail) {
        this.atEmail = atEmail;
    }

    public String getHearAboutUs() {
        return hearAboutUs;
    }

    public void setHearAboutUs(String hearAboutUs) {
        this.hearAboutUs = hearAboutUs;
    }

    public String getPreferredCommuncation() {
        return preferredCommuncation;
    }

    public void setPreferredCommuncation(String preferredCommuncation) {
        this.preferredCommuncation = preferredCommuncation;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }






}
