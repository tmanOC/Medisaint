package com.tielman.list;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.UUID;

import io.realm.Realm;

public class addClinicActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_clinic);
        this.setTitle(this.getString(R.string.add_clinic_title));

    }

    public void createClinic(View view) {
        EditText editText = (EditText) findViewById(R.id.editText);
        String name = editText.getText().toString();
        if(name.length() == 0) {
            return;
        }
        Clinic clinic_new = new Clinic();
        clinic_new.setName(name);
        clinic_new.setId(UUID.randomUUID().toString());
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        realm.copyToRealm(clinic_new);
        realm.commitTransaction();
        finish();
    }
}
