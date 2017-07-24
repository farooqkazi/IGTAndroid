package com.example.kazi.igtandroid.di;


import com.example.kazi.igtandroid.api.ApiManager;
import com.example.kazi.igtandroid.api.Interactor;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Kazi on 1/Jun/17.
 */


@Module
public class GameModule {

    @Provides
    public Interactor getInteractorObject(){

        return new ApiManager();
    }

}
