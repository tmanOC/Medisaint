package com.tielman.list;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import io.realm.Realm;
import io.realm.RealmResults;

public class ClinicDetailActivity extends AppCompatActivity {
    long identifier;
    Clinic result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clinic_detail);
        Intent intent = this.getIntent();
        identifier = intent.getLongExtra(MainActivity.CLINIC_ID_KEY,0);

        Realm realm = Realm.getDefaultInstance();
        result = realm.where(Clinic.class).equalTo("id",identifier).findFirst();
        setTitle(result.getName());
    }

    public void openAddActivity(View view) {
        //Intent intent = new Intent(this, addClinicActivity.class);
        //startActivity(intent);
    }
}
