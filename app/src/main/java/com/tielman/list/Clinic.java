package com.tielman.list;

import io.realm.RealmList;
import io.realm.RealmModel;
import io.realm.RealmObject;
import io.realm.RealmResults;
import io.realm.annotations.LinkingObjects;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.RealmClass;

/**
 * Created by tielman on 2017/06/17.
 */
@RealmClass
public class Clinic implements RealmModel {
    @PrimaryKey
    private String id;
    private String name;
    @LinkingObjects("clinic")
    final RealmResults<ClinicMedicine> clinicMedicines = null;
    //private RealmList<ClinicMedicine> clinicMedicines;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
