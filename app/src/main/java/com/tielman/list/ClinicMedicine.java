package com.tielman.list;

import io.realm.RealmModel;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.RealmClass;

/**
 * Created by tielman on 2017/06/18.
 */
@RealmClass
public class ClinicMedicine implements RealmModel {
    @PrimaryKey
    private String id;
    private Clinic clinic;
    private Medicine medicine;
    private double quantity;

    @Override
    public String toString() {
        return quantity + " " + medicine;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
