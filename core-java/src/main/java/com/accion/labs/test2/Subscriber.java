package com.accion.labs.test2;

import com.imtiyaz.examples.Address;

import java.util.List;

/**
 * Created by imtiyaz on 7/4/17.
 */
public class Subscriber {
    private long uid;
    private long groupId;
    private String name;
    private int age;
    private Address address;
    private Employer employer;
    private List<Dependent> dependents;
    private InsuranceProvider insuranceProvider;
    private HealthPlan healthPlan;
    private DentalPlan dentalPlan;

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public List<Dependent> getDependents() {
        return dependents;
    }

    public void setDependents(List<Dependent> dependents) {
        this.dependents = dependents;
    }

    public InsuranceProvider getInsuranceProvider() {
        return insuranceProvider;
    }

    public void setInsuranceProvider(InsuranceProvider insuranceProvider) {
        this.insuranceProvider = insuranceProvider;
    }

    public HealthPlan getHealthPlan() {
        return healthPlan;
    }

    public void setHealthPlan(HealthPlan healthPlan) {
        this.healthPlan = healthPlan;
    }

    public DentalPlan getDentalPlan() {
        return dentalPlan;
    }

    public void setDentalPlan(DentalPlan dentalPlan) {
        this.dentalPlan = dentalPlan;
    }
}
