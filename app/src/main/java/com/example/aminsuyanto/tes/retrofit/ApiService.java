package com.example.aminsuyanto.tes.retrofit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by amin suyanto on 19-Feb-17.
 */

public class ApiService {
    public static final String API_BASE_URL = "http://ibacor.com";
    public static OkHttpClient.Builder httpClient =new OkHttpClient.Builder();
    private static Retrofit.Builder builder=
            new Retrofit.Builder()
            .baseUrl(API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create());
    public static <s> s createService (Class <s> serviceClass){
        Retrofit retrofit = builder.client(httpClient.build()).build();
        return retrofit.create(serviceClass);
    }

}
