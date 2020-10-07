package com.example.finalprojectapp.data.repositories;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import com.example.finalprojectapp.data.entities.PersistKeyValue;
import com.example.finalprojectapp.data.interfaces.ManagementAccessPort;

public class PersistUserAccountRepository implements ManagementAccessPort.PersistAccountAccess {
    private static PersistUserAccountRepository persistUserAccountRepository;
    private SharedPreferences preferences;
    public PersistUserAccountRepository(Activity activity) {
        this.preferences = activity.getPreferences(Context.MODE_PRIVATE);
    }

    public static PersistUserAccountRepository initialize(Activity activity){
        if(persistUserAccountRepository != null) {
            persistUserAccountRepository = new PersistUserAccountRepository(activity);
            return persistUserAccountRepository;
        }
        return persistUserAccountRepository;
    }

    @Override
    public void persist(PersistKeyValue[] valuesPersist) {
        SharedPreferences.Editor editor = persistUserAccountRepository.preferences.edit();
        for (PersistKeyValue currentValue : valuesPersist) {
            editor.putString(currentValue.getKey(),currentValue.getValue());
        }
        editor.apply();
    }

    @Override
    public String getPersistValue(String key) {
        return persistUserAccountRepository.preferences.getString(key,"");
    }
}
