package com.tielman.list;

import io.realm.RealmObject;
import io.realm.RealmResults;
import io.realm.annotations.LinkingObjects;
import io.realm.annotations.PrimaryKey;

/**
 * Created by tielman on 2017/06/18.
 */

public class Medicine extends RealmObject {
    @PrimaryKey
    private long id;
    private String name;
    @LinkingObjects("medicine")
    final RealmResults<ClinicMedicine> clinicMedicines = null;
}
