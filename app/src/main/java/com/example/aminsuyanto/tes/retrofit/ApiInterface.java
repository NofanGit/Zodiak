package com.example.aminsuyanto.tes.retrofit;

import com.example.aminsuyanto.tes.model.zodiakModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by amin suyanto on 19-Feb-17.
 */

public interface ApiInterface {
    @GET("/api/zodiak")
    Call<zodiakModel> callzodiak(
        @Query("nama") String nama,
        @Query("tgl") String tanggal
    );

}
