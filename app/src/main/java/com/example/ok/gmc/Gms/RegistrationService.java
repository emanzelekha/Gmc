package com.example.ok.gmc.Gms;

import android.app.IntentService;
import android.content.Intent;

import com.example.ok.gmc.Gms.InterfaceService;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.google.android.gms.iid.InstanceID;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by ok on 21/01/2017.
 */
public  class RegistrationService extends IntentService {

    public RegistrationService() {
        super("RegistrationService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        InstanceID instanceID = InstanceID.getInstance(this);
        try {
            String token = instanceID.getToken("944333320314", GoogleCloudMessaging.INSTANCE_ID_SCOPE, null);
            sendTokenToServer(token);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private void sendTokenToServer(final String token) {

        Retrofit retrofit=new Retrofit.Builder().baseUrl("http://emantest.16mb.com/").build();
        InterfaceService intentService=retrofit.create(InterfaceService.class);
        Call<ResponseBody> addToken=intentService.SaveToken(token);
        addToken.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    System.out.println(response.body().string()+"ghfghfghf");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                System.out.println(t.getMessage()+"ghfghfghf");

            }
        });


    }

}