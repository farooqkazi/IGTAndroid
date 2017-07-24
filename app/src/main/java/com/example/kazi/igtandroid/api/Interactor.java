package com.example.kazi.igtandroid.api;


import com.example.kazi.igtandroid.model.Result;
import com.example.kazi.igtandroid.model.PlayerData;

import io.reactivex.Observable;


/**
 * Created by Kazi on 1/Jun/17.
 */


public interface Interactor {
  Observable<Result> getResult();
  Observable<PlayerData> getPlayerData();
}
