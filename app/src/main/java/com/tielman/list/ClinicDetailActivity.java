package com.tielman.list;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.UUID;

import io.realm.Realm;
import io.realm.RealmResults;

public class ClinicDetailActivity extends AppCompatActivity {
    String identifier;
    Clinic result;
    ListView listView;

    ArrayList<ClinicMedicine> values;
    ArrayAdapter<ClinicMedicine> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clinic_detail);
        Intent intent = this.getIntent();
        identifier = intent.getStringExtra(MainActivity.CLINIC_ID_KEY);

        Realm realm = Realm.getDefaultInstance();
        result = realm.where(Clinic.class).equalTo("id",identifier).findFirst();
        setTitle(result.getName() + " Stock");

        listView = (ListView)findViewById(R.id.list_view);


        values = new ArrayList<ClinicMedicine>();

        /*realm.beginTransaction();
        Medicine medicine = realm.createObject(Medicine.class,UUID.randomUUID().toString());
        medicine.setName("Awesome Medicine");
        ClinicMedicine clinicMedicine = realm.createObject(ClinicMedicine.class, UUID.randomUUID().toString());
        clinicMedicine.setMedicine(medicine);
        clinicMedicine.setClinic(this.result);
        realm.commitTransaction();
        values.add(clinicMedicine);*/

        adapter = new ArrayAdapter<ClinicMedicine>(this,
                android.R.layout.simple_list_item_1,android.R.id.text1,values);
        listView.setAdapter(adapter);
        final ClinicDetailActivity currentActivity = this;
        AdapterView.OnItemClickListener listener =  new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // ListView Clicked item index
                int itemPosition     = position;
                // ListView Clicked item value
                ClinicMedicine clinic_medicine = (ClinicMedicine)listView.getItemAtPosition(position);
                String identifier = clinic_medicine.getId();
                // String  itemValue    = listView.getItemAtPosition(position).toString();
                // Show Alert
                Intent intent = new Intent(currentActivity, ClinicMedicineDetailActivity.class);
                //intent.putExtra(CLINIC_ID_KEY,identifier);
                startActivity(intent);
                Toast.makeText(getApplicationContext(),
                        "Position :"+itemPosition+"  ListItem : " +identifier , Toast.LENGTH_LONG)
                        .show();
            }

        };

        listView.setOnItemClickListener( listener);
    }

    public void openAddActivity(View view) {
        Intent intent = new Intent(this, AddClinicMedicineActivity.class);
        intent.putExtra(MainActivity.CLINIC_ID_KEY,result.getId());
        startActivity(intent);
    }
}
