package com.example.ua.testtask.rest.api;


import com.example.ua.testtask.domain.Example;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 *
 */
public interface LecturioApi {

    @GET("api/en/v7/android/search/question/lecturio_com")
    Call<Example> getData(@Query("q") String resourceName);
}
