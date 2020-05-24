package com.EFYSoftware;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiClient {

    @GET("/get_memes")
    Call<Flip> getFlips();
}
