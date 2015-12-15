package com.nunc.Homewised.activity.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by nunc on 10-12-2015.
 */
public class JobObject implements Serializable {
    private static final long serialVersionUID = 1L;
  //  private  String jobType;
    private  String title;
    private  String status;
    private String type;
    private  String notes;
    private  String itemCatagory;
    private  Double othercharges;
    private  Double discount;
    private  Double tax;
    private  Double total;
  private ArrayList<ItemObject> litemsList=new ArrayList<ItemObject>();
    private String scheduledStartTime;
    private String scheduledEndTime;
    private String attachmentPath;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getItemCatagory() {
        return itemCatagory;
    }

    public void setItemCatagory(String itemCatagory) {
        this.itemCatagory = itemCatagory;
    }

    public Double getOthercharges() {
        return othercharges;
    }

    public void setOthercharges(Double othercharges) {
        this.othercharges = othercharges;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public ArrayList<ItemObject> getLitemsList() {
        return litemsList;
    }

    public void setLitemsList(ArrayList<ItemObject> litemsList) {
        this.litemsList = litemsList;
    }

    public String getScheduledStartTime() {
        return scheduledStartTime;
    }

    public void setScheduledStartTime(String scheduledStartTime) {
        this.scheduledStartTime = scheduledStartTime;
    }

    public String getScheduledEndTime() {
        return scheduledEndTime;
    }

    public void setScheduledEndTime(String scheduledEndTime) {
        this.scheduledEndTime = scheduledEndTime;
    }

    public String getAttachmentPath() {
        return attachmentPath;
    }

    public void setAttachmentPath(String attachmentPath) {
        this.attachmentPath = attachmentPath;
    }
}
