package com.example.finalprojectapp.data.repositories;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.finalprojectapp.data.entities.PersistKeyValue;
import com.example.finalprojectapp.data.interfaces.ManagementAccessPort;

import java.util.prefs.PreferencesFactory;

public class PersistUserAccountRepository implements ManagementAccessPort.PersistAccountAccess {
    private SharedPreferences preferences;
    public PersistUserAccountRepository(Activity activity) {
        this.preferences = PreferenceManager.getDefaultSharedPreferences(activity);
    }

    @Override
    public void persist(PersistKeyValue[] valuesPersist) {
        SharedPreferences.Editor editor = this.preferences.edit();
        for (PersistKeyValue currentValue : valuesPersist) {
            System.out.println(currentValue.getKey());
            System.out.println(currentValue.getValue());
            editor.putString(currentValue.getKey(),currentValue.getValue());
        }
        editor.apply();
    }

    @Override
    public String getPersistValue(String key) {
        return this.preferences.getString(key,"");
    }
}
