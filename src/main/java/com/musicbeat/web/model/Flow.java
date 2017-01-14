package com.musicbeat.web.model;

import java.util.Date;

public class Flow {
    private Date time;

    private Float amount;

    public Flow(Date time, Float amount) {
        this.time = time;
        this.amount = amount;
    }

    public Date getTime() {
        return time;
    }

    public Float getAmount() {
        return amount;
    }
}