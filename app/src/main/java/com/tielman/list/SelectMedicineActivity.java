package com.tielman.list;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import io.realm.Realm;

public class SelectMedicineActivity extends AppCompatActivity {

    ClinicMedicine clinicMedicine;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_medicine);
        Intent intent = getIntent();
        String identifier = intent.getStringExtra(AddClinicMedicineActivity.CLINIC_MEDICINE_KEY);
        Realm realm = Realm.getDefaultInstance();
        clinicMedicine = realm.where(ClinicMedicine.class).equalTo("id",identifier).findFirst();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            onBackPressed();
            return  true;
        }
        return super.onOptionsItemSelected(item);
    }
}
