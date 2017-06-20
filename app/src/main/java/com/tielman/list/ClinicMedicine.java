package com.tielman.list;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by tielman on 2017/06/18.
 */

public class ClinicMedicine extends RealmObject {
    @PrimaryKey
    private long id;
    private String name;
    private Clinic clinic;
    private Medicine medicine;
    private double quantity;

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Clinic getClinic() {
        return clinic;
    }

    public void setClinic(Clinic clinic) {
        this.clinic = clinic;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }
}
