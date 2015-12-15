package com.nunc.Homewised.activity.model;

import java.io.Serializable;

public class Itemslistdata implements Serializable {

    private static final long serialVersionUID = 1L;

    private String itemName ;
    private String quantity ;
    private String tvTotal ;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getTvTotal() {
        return tvTotal;
    }

    public void setTvTotal(String tvTotal) {
        this.tvTotal = tvTotal;
    }
}
