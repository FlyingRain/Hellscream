package com.flyingrain.translate.dungeon.service.services.limitchains.limits.models;

import java.util.Date;

/**
 * Created by wally on 10/31/17.
 */
public class TimeLimitModel {

    private Date startDate;

    private Date endDate;

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
