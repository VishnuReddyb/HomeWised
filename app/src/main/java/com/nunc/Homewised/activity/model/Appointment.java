package com.nunc.Homewised.activity.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Appointment implements Serializable {

    private static final long serialVersionUID = 1L;
    private String btn_schedule;
    private String text_cust;
    private String img_rightside;
    private String mapmarker;
    private String jobid;
private ArrayList<ItemObject>  itemsList;
    public String getMapmarker() {
        return mapmarker;
    }

    public void setMapmarker(String mapmarker) {
        this.mapmarker = mapmarker;
    }

    private String text_airconditon_address;
    private String text_airconditon_repair;
    private String text_airconditon_time;

    /*public static long getSerialVersionUID() {
        return serialVersionUID;
    }*/

    public String getText_cust() {
        return text_cust;
    }

    public void setText_cust(String text_cust) {
        this.text_cust = text_cust;
    }

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

    public String getJobid() {
        return jobid;
    }

    public void setJobid(String jobid) {
        this.jobid = jobid;
    }

    public String getText_airconditon_address() {
        return text_airconditon_address;
    }

    public void setText_airconditon_address(String text_airconditon_address) {
        this.text_airconditon_address = text_airconditon_address;
    }

    public String getText_airconditon_repair() {
        return text_airconditon_repair;
    }

    public void setText_airconditon_repair(String text_airconditon_repair) {
        this.text_airconditon_repair = text_airconditon_repair;
    }

    public String getText_airconditon_time() {
        return text_airconditon_time;
    }

    public void setText_airconditon_time(String text_airconditon_time) {
        this.text_airconditon_time = text_airconditon_time;
    }
}
