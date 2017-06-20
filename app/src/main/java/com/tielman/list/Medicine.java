package com.tielman.list;

import io.realm.RealmObject;
import io.realm.RealmResults;
import io.realm.annotations.LinkingObjects;
import io.realm.annotations.PrimaryKey;

/**
 * Created by tielman on 2017/06/18.
 */

public class Medicine extends RealmObject {
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

    @PrimaryKey
    private String id;
    private String name;
    @LinkingObjects("medicine")
    final RealmResults<ClinicMedicine> clinicMedicines = null;

    @Override
    public String toString() {
        return name;
    }
}
