package com.example.kazi.igtandroid.di;

import android.app.Application;

/**
 * Created by Kazi on 1/Jun/17.
 */


public class MyApp extends Application {

    GameComponent gameComponent;

    public GameComponent getGameComponent() {
        return gameComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        gameComponent = DaggerGameComponent.create();
    }
}
