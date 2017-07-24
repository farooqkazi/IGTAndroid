package com.example.kazi.igtandroid;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kazi.igtandroid.di.MyApp;
import com.example.kazi.igtandroid.model.Data;
import com.example.kazi.igtandroid.model.GameDataParcel;
import com.example.kazi.igtandroid.model.PlayerData;
import com.example.kazi.igtandroid.presenter.GameContract;
import com.example.kazi.igtandroid.presenter.GamePresenter;
import com.result.kazi.igtandroid.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Kazi on 22/Jun/17.
 */

public class DetailActivity extends AppCompatActivity implements GameContract.IView {

    Unbinder unbinder;
    @Inject
    GamePresenter gamePresenter;

    @BindView(R.id.gameDataName) TextView tvGameDataName;
    @BindView(R.id.gameDataDate) TextView tvGameDataDate;
    @BindView(R.id.gameDataJackpot) TextView tvGameDataJackpot;

    @BindView(R.id.playerAvatar) ImageView ivPlayerAvatar;
    @BindView(R.id.playerBalance) TextView tvPlayerBalance;
    @BindView(R.id.playerName) TextView tvPlayerName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        unbinder = ButterKnife.bind(this);

        ((MyApp)getApplication()).getGameComponent().inject(this);

        gamePresenter.bindView(this);
        gamePresenter.callGameDataInteractor();

        GameDataParcel gameDataParcel = getIntent().getParcelableExtra("gameData");

        if (gameDataParcel != null) {

            tvGameDataName.setText(gameDataParcel.gameName);
            tvGameDataDate.setText(gameDataParcel.gameDate);
            tvGameDataJackpot.setText(gameDataParcel.gameJackpot);

        }
    }

    @Override
    public void shouldShowDataInRecyclerView(List<Data> result) {

    }

    @Override
    public void showPlayerData(PlayerData playerData) {
        tvPlayerName.setText(playerData.getName());
        tvPlayerBalance.setText(String.valueOf(playerData.getBalance()));
        String url = playerData.getAvatarLink();
        Picasso.with(getApplicationContext()).load(url)
                .into(ivPlayerAvatar);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        gamePresenter.unBindView();
        unbinder.unbind();
    }
}
