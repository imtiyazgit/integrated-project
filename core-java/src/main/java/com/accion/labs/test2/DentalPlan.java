package com.accion.labs.test2;

import java.util.Date;

/**
 * Created by imtiyaz on 7/4/17.
 */
public class DentalPlan {
    private long uid;
    private PlanType type;
    private Date since;

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public PlanType getType() {
        return type;
    }

    public void setType(PlanType type) {
        this.type = type;
    }

    public Date getSince() {
        return since;
    }

    public void setSince(Date since) {
        this.since = since;
    }


}
