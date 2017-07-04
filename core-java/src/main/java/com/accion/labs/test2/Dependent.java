package com.accion.labs.test2;

import com.imtiyaz.examples.Address;

/**
 * Created by imtiyaz on 7/4/17.
 */
public class Dependent {
    private long uid;
    private String name;
    private Address address;

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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
