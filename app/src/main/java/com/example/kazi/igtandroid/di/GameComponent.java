package com.example.kazi.igtandroid.di;

import com.example.kazi.igtandroid.DetailActivity;
import com.example.kazi.igtandroid.MainActivity;

import dagger.Component;

/**
 * Created by Kazi on 1/Jun/17.
 */


@Component(dependencies = GameModule.class)
public interface GameComponent {

    void inject(MainActivity mainActivity);
    void inject(DetailActivity detailActivity);

}
