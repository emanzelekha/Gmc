package com.example.ok.gmc.Gms;


import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;


/**
 * Created by ok on 12/01/2017.
 */

public interface InterfaceService {


   @GET("getposts.php")
   Call<ResponseBody> SaveToken(@Field("token")String token);


}
