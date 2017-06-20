package com.tielman.list;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.RealmResults;
import io.realm.annotations.LinkingObjects;
import io.realm.annotations.PrimaryKey;

/**
 * Created by tielman on 2017/06/17.
 */

public class Clinic extends RealmObject {
    @PrimaryKey
    private long id;
    private String name;
    @LinkingObjects("clinic")
    final RealmResults<ClinicMedicine> clinicMedicines = null;
    //private RealmList<ClinicMedicine> clinicMedicines;

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

    @Override
    public String toString() {
        return name;
    }
}
