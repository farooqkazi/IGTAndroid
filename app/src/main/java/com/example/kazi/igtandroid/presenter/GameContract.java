package com.example.kazi.igtandroid.presenter;

import com.example.kazi.igtandroid.api.IGameAPI;
import com.example.kazi.igtandroid.model.Data;
import com.example.kazi.igtandroid.model.PlayerData;

import java.util.List;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Kazi on 22/Jun/17.
 */

public interface GameContract {

    interface IView  {

        void shouldShowDataInRecyclerView(List<Data> result);
        void showPlayerData(PlayerData playerData);
        //void getCompositeDisposable();
    }

    interface IPresenter {

        void callGameDataInteractor();
        void callPlayerDataInteractor();
        void bindView(IView view);
        void unBindView();
        //void passCompositeDisposable();
    }
}
