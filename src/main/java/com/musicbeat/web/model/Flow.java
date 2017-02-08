package com.musicbeat.web.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Flow implements Serializable {

    private static final long serialVersionUID = -4310560510400644692L;

    private Date time;

    private Float amount;

    @Override
    public String toString() {
        List<String> list = new ArrayList<>();

        list.add(time.toString());
        list.add(amount.toString());

        return list.toString();
    }

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