package com.nunc.Homewised.activity.model;

import java.io.Serializable;

/**
 * Created by nunc on 10-12-2015.
 */
public class ItemObject implements Serializable {

    private static final long serialVersionUID = 1L;
    private String catalogName;
    private String itemName;
    private String descriptionName;
    private String itemNumber;
    private String manufactuer;
    private Double dimensionsL;
    private Double dimensionsW;
    private Double dimensionsH;
    private Double umoL;
    private Double umoH;
    private Double umoW;
    private Double quantity;
    private Double unitePrice;
    private Double labor;
    boolean taxable;

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getDescriptionName() {
        return descriptionName;
    }

    public void setDescriptionName(String descriptionName) {
        this.descriptionName = descriptionName;
    }

    public String getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(String itemNumber) {
        this.itemNumber = itemNumber;
    }

    public String getManufactuer() {
        return manufactuer;
    }

    public void setManufactuer(String manufactuer) {
        this.manufactuer = manufactuer;
    }

    public Double getDimensionsL() {
        return dimensionsL;
    }

    public void setDimensionsL(Double dimensionsL) {
        this.dimensionsL = dimensionsL;
    }

    public Double getDimensionsW() {
        return dimensionsW;
    }

    public void setDimensionsW(Double dimensionsW) {
        this.dimensionsW = dimensionsW;
    }

    public Double getDimensionsH() {
        return dimensionsH;
    }

    public void setDimensionsH(Double dimensionsH) {
        this.dimensionsH = dimensionsH;
    }

    public Double getUmoL() {
        return umoL;
    }

    public void setUmoL(Double umoL) {
        this.umoL = umoL;
    }

    public Double getUmoH() {
        return umoH;
    }

    public void setUmoH(Double umoH) {
        this.umoH = umoH;
    }

    public Double getUmoW() {
        return umoW;
    }

    public void setUmoW(Double umoW) {
        this.umoW = umoW;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getUnitePrice() {
        return unitePrice;
    }

    public void setUnitePrice(Double unitePrice) {
        this.unitePrice = unitePrice;
    }

    public Double getLabor() {
        return labor;
    }

    public void setLabor(Double labor) {
        this.labor = labor;
    }

    public boolean isTaxable() {
        return taxable;
    }

    public void setTaxable(boolean taxable) {
        this.taxable = taxable;
    }
}
