package com.nunc.Homewised.activity.model;


import java.io.Serializable;

public class Catalog implements Serializable {

    private static final long serialVersionUID = 1L;
    private String text_airfilter_title;
    private String text_airfilter_name;
    private String text_price;
    private String text_airfilter_address;

    public String getText_airfilter_title() {
        return text_airfilter_title;
    }

    public void setText_airfilter_title(String text_airfilter_title) {
        this.text_airfilter_title = text_airfilter_title;
    }

    public String getText_airfilter_name() {
        return text_airfilter_name;
    }

    public void setText_airfilter_name(String text_airfilter_name) {
        this.text_airfilter_name = text_airfilter_name;
    }

    public String getText_price() {
        return text_price;
    }

    public void setText_price(String text_price) {
        this.text_price = text_price;
    }

    public String getText_airfilter_address() {
        return text_airfilter_address;
    }

    public void setText_airfilter_address(String text_airfilter_address) {
        this.text_airfilter_address = text_airfilter_address;
    }
}
