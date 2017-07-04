package com.accion.labs.test2;

import java.util.List;

/**
 * Created by imtiyaz on 7/4/17.
 */
public class InsuranceProvider {
    private long uid;
    private String name;
    private List<HealthPlan> healthPlans;
    private List<DentalPlan> dentalPlans;

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<HealthPlan> getHealthPlans() {
        return healthPlans;
    }

    public void setHealthPlans(List<HealthPlan> healthPlans) {
        this.healthPlans = healthPlans;
    }

    public List<DentalPlan> getDentalPlans() {
        return dentalPlans;
    }

    public void setDentalPlans(List<DentalPlan> dentalPlans) {
        this.dentalPlans = dentalPlans;
    }
}
