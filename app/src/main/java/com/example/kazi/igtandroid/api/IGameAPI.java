package com.example.kazi.igtandroid.api;

import com.example.kazi.igtandroid.model.Result;
import com.example.kazi.igtandroid.model.PlayerData;
import com.example.kazi.igtandroid.utils.Constants;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by Kazi on 22/Jun/17.
 */

public interface IGameAPI {

    @GET(Constants.GAME_URL)
    Observable<Result> getGameData();

    @GET(Constants.PLAYER_URL)
    Observable<PlayerData> getPlayerData();
}
