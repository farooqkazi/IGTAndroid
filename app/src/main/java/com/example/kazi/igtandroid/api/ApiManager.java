package com.example.kazi.igtandroid.api;

import com.example.kazi.igtandroid.model.Result;
import com.example.kazi.igtandroid.model.PlayerData;
import com.example.kazi.igtandroid.utils.Constants;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



public class ApiManager implements Interactor {


    public static IGameAPI getConnection(){

        Retrofit retrofit = null;
        OkHttpClient okHttpClient = null;


        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY);

        okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build();


        if (retrofit==null){
            retrofit= new Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(okHttpClient)
                    .build();
        }

        return retrofit.create(IGameAPI.class);
    }

    public ApiManager() {
        getConnection();
    }


    @Override
    public Observable<Result> getResult() {
        return getConnection().getGameData();
    }

    @Override
    public Observable<PlayerData> getPlayerData() {
        return getConnection().getPlayerData();
    }
}
