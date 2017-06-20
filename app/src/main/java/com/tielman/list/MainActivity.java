package com.tielman.list;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {
    public static final String CLINIC_ID_KEY = "com.tielman.list.clinic";
    ListView listView;

    ArrayList<Clinic> values;
    ArrayAdapter<Clinic> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        this.setTitle(this.getString(R.string.main_activity_title));
        listView = (ListView)findViewById(R.id.list_view);

        Realm.init(this);

        values = new ArrayList<Clinic>();
        adapter = new ArrayAdapter<Clinic>(this,
                android.R.layout.simple_list_item_1,android.R.id.text1,values);
        listView.setAdapter(adapter);
        final MainActivity mainActivity = this;
        OnItemClickListener listener =  new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // ListView Clicked item index
                int itemPosition     = position;
                // ListView Clicked item value
                Clinic clinic = (Clinic)listView.getItemAtPosition(position);
                long identifier = clinic.getId();
                // String  itemValue    = listView.getItemAtPosition(position).toString();
                // Show Alert
                Intent intent = new Intent(mainActivity, ClinicDetailActivity.class);
                intent.putExtra(CLINIC_ID_KEY,identifier);
                startActivity(intent);
                /*Toast.makeText(getApplicationContext(),
                        "Position :"+itemPosition+"  ListItem : " +itemValue , Toast.LENGTH_LONG)
                        .show();*/
            }

        };

        listView.setOnItemClickListener( listener);
    }

    @Override
    protected void onResume() {
        Realm realm = Realm.getDefaultInstance();
        final RealmResults<Clinic> clinic_results = realm.where(Clinic.class).findAll();
        Object[] objectArray = clinic_results.toArray();
        values = new ArrayList<Clinic>(Arrays.asList(Arrays.copyOf(objectArray, objectArray.length,
                Clinic[].class)));
        adapter.clear();
        adapter.addAll(values);
        adapter.notifyDataSetChanged();

        super.onResume();
    }

    public void openAddActivity(View view) {
        Intent intent = new Intent(this, addClinicActivity.class);
        startActivity(intent);
    }
}
