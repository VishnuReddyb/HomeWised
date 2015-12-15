package com.nunc.Homewised.activity.model;

import java.io.Serializable;

public class Leads implements Serializable {

    private static final long serialVersionUID = 1L;
    private String btn_schedule;

    private String img_rightside;

    private String text_notes;
    private String text_address;
    private String text_name;


    public String getBtn_schedule() {
        return btn_schedule;
    }

    public void setBtn_schedule(String btn_schedule) {
        this.btn_schedule = btn_schedule;
    }

    public String getImg_rightside() {
        return img_rightside;
    }

    public void setImg_rightside(String img_rightside) {
        this.img_rightside = img_rightside;
    }

    public String getText_notes() {
        return text_notes;
    }

    public void setText_notes(String text_notes) {
        this.text_notes = text_notes;
    }

    public String getText_address() {
        return text_address;
    }

    public void setText_address(String text_address) {
        this.text_address = text_address;
    }

    public String getText_name() {
        return text_name;
    }

    public void setText_name(String text_name) {
        this.text_name = text_name;
    }
}
