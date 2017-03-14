package com.example.ua.testtask;

import android.app.Application;


import com.example.ua.testtask.rest.api.LecturioApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 *
 */
public class LecturioApplication extends Application {

    private static LecturioApi lecturioApi;
    private Retrofit retrofit;

    @Override
    public void onCreate() {
        super.onCreate();

        retrofit = new Retrofit.Builder()
                .baseUrl("https://www.lecturio.de/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        lecturioApi = retrofit.create(LecturioApi.class);
    }

    /**
     *
     * @return
     */
    public static LecturioApi getApi() {
        return lecturioApi;
    }

}
