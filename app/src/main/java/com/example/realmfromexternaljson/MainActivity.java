package com.example.realmfromexternaljson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.io.InputStream;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RealmConfiguration config = getRealmConfig();
        Realm realm = Realm.getInstance(config);

        InputStream stream = getResources().openRawResource(R.raw.people);

        realm.beginTransaction();
        try {
            realm.createAllFromJson(Person.class, stream);
            realm.commitTransaction();
        } catch (IOException e) {
            e.printStackTrace();
            realm.cancelTransaction();
        } finally {
            if (stream != null) {
                try {
                    stream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
    private RealmConfiguration getRealmConfig() {
        RealmConfiguration config = new RealmConfiguration.Builder()
                .name("people.realm")
                .build();
        return config;
    }



}
