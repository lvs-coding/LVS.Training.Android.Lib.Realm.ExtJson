package com.example.realmfromexternaljson;


import android.content.res.Resources;
import android.util.Log;

import java.io.InputStream;

import io.realm.Realm;

/**
 * From json to realm database
 */
public class RealmImporter {

    Resources resources;

    public RealmImporter(Resources resources) {
        this.resources = resources;
    }

    public void importFromJson(Realm realm) {



        Log.d("Realm", "createAllFromJson Task completed");
    }
}
