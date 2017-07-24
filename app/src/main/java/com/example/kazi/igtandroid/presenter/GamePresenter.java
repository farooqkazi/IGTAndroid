package com.example.kazi.igtandroid.presenter;

import com.example.kazi.igtandroid.api.Interactor;
import com.example.kazi.igtandroid.model.Data;
import com.example.kazi.igtandroid.model.Result;
import com.example.kazi.igtandroid.model.PlayerData;

import java.util.List;

import javax.inject.Inject;


import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Kazi on 22/Jun/17.
 */

public class GamePresenter implements GameContract.IPresenter {

    GameContract.IView iView;
    Interactor interactor;
    CompositeDisposable compositeDisposable;

    @Inject
    public GamePresenter(Interactor interactor) {
        this.interactor = interactor;
    }


    @Override
    public void callGameDataInteractor() {
        interactor.getResult()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Result>() {

                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Result result) {

                        List<Data> gameData = result.getData();
                        iView.shouldShowDataInRecyclerView(gameData);

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }


    @Override
    public void callPlayerDataInteractor() {

        interactor.getPlayerData()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<PlayerData>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(PlayerData playerData) {
                        iView.showPlayerData(playerData);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    @Override
    public void bindView(GameContract.IView view) {
        this.iView = view;
        compositeDisposable = new CompositeDisposable();
    }

    @Override
    public void unBindView() {
        iView = null;
    }

}
