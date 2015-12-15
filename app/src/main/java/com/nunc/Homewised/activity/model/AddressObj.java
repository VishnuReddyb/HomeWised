package com.nunc.Homewised.activity.model;

import java.io.Serializable;

/**
 * Created by nunc_dayal on 14-12-2015.
 */
public class AddressObj implements Serializable {
    private static final long serialVersionUID = 1L;
    //AddressInfo
    private String type;
    private String address1;
    private String address2;
    private String city;
    private String county;
    private String states;
    private String zipcode;
    private String country;
    boolean serviceaddress;

    public boolean isServiceaddress() {
        return serviceaddress;
    }

    public void setServiceaddress(boolean serviceaddress) {
        this.serviceaddress = serviceaddress;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getStates() {
        return states;
    }

    public void setStates(String states) {
        this.states = states;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
