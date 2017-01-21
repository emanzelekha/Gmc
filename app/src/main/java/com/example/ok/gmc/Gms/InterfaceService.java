package com.example.ok.gmc.Gms;


import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;


/**
 * Created by ok on 12/01/2017.
 */

public interface InterfaceService {

   @FormUrlEncoded
   @POST("addnewtoken.php")
   Call<ResponseBody> SaveToken(@Field("token")String token);


}
