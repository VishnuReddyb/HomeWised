package com.nunc.Homewised.activity.model;

import java.io.Serializable;

public class ScheduleButtonmodel implements Serializable {

    private static final long serialVersionUID = 1L;

    private String chck_accepted ;
    private String text_cusname ;

    public String getText_cusname() {
        return text_cusname;
    }

    public void setText_cusname(String text_cusname) {
        this.text_cusname = text_cusname;
    }

    public String getChck_accepted() {
        return chck_accepted;
    }

    public void setChck_accepted(String chck_accepted) {
        this.chck_accepted = chck_accepted;
    }
}
