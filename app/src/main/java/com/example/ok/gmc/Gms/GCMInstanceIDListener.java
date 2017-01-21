package com.example.ok.gmc.Gms;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.android.gms.iid.InstanceIDListenerService;

/**
 * Created by ok on 21/01/2017.
 */

public class GCMInstanceIDListener extends InstanceIDListenerService {
    SharedPreferences preferences;
    SharedPreferences.Editor prefEditor;

    @Override
    public void onTokenRefresh() {
        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        prefEditor = preferences.edit();
        prefEditor.putBoolean("pref_previously_started", false).apply();
        startService(new Intent(this, RegistrationService.class));

    }
}

