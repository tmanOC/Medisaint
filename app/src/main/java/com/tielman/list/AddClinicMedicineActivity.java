package com.tielman.list;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import java.util.UUID;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class AddClinicMedicineActivity extends AppCompatActivity {
    public static final String CLINIC_MEDICINE_KEY = "CLINIC_MEDICINE_KEY";
    ClinicMedicine clinicMedicine;
    Clinic result;

    EditText text_medicine;
    EditText text_quantity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_clinic_medicine);
        Realm realm = Realm.getDefaultInstance();
        Intent intent = getIntent();
        String identifier = intent.getStringExtra(MainActivity.CLINIC_ID_KEY);
        result = realm.where(Clinic.class).equalTo("id",identifier).findFirst();

        realm.beginTransaction();
        clinicMedicine = realm.createObject(ClinicMedicine.class, UUID.randomUUID().toString());
        clinicMedicine.setClinic(result);
        realm.commitTransaction();

        text_medicine = (EditText)findViewById(R.id.editText);
        text_quantity = (EditText)findViewById(R.id.editTextQuantity);
        text_quantity.setText("0");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Medicine medicine = clinicMedicine.getMedicine();
        if(medicine == null) {
           return;
        }
        text_medicine.setText(medicine.getName());
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

    @Override
    public void onBackPressed() {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        //clinicMedicine.deleteFromRealm();
        realm.commitTransaction();
        super.onBackPressed();
    }

    public void openMedicineSelect(View view) {
        Intent intent = new Intent(this,SelectMedicineActivity.class);
        intent.putExtra(CLINIC_MEDICINE_KEY,clinicMedicine.getId());
        startActivity(intent);
    }

    public void addClinicMedicine(View view) {
        //add new clinic medicine and save
        Realm realm = Realm.getDefaultInstance();
        Double quantity = new Double(text_quantity.getText().toString());

        realm.beginTransaction();
        clinicMedicine.setQuantity(quantity);
        realm.commitTransaction();
        if(clinicMedicine.getMedicine() == null) {
            //Error no medicine selected
            return;
        }
        this.finish();
    }
}
