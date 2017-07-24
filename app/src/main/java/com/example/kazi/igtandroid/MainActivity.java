package com.example.kazi.igtandroid;


import android.support.v4.widget.SwipeRefreshLayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kazi.igtandroid.adapter.GameAdapter;
import com.example.kazi.igtandroid.di.MyApp;
import com.example.kazi.igtandroid.model.Data;
import com.example.kazi.igtandroid.model.PlayerData;
import com.example.kazi.igtandroid.presenter.GameContract;
import com.example.kazi.igtandroid.presenter.GamePresenter;
import com.example.kazi.igtandroid.utils.ItemsMarginDecorator;
import com.result.kazi.igtandroid.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements GameContract.IView {


    private static String TAG = "Tag";
    @BindView(R.id.player_avatar) ImageView ivPlayer_Avatar;
    @BindView(R.id.player_balance) TextView tvPlayer_Balance;
    @BindView(R.id.player_name) TextView tvPlayer_Name;
    @BindView(R.id.player_login) TextView tvPlayer_Login;

    private RecyclerView recycler_view;

    @Inject
    GamePresenter gamePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((MyApp)getApplication()).getGameComponent().inject(this);
        ButterKnife.bind(this);

        establishConnection();
        initializeRecyclerView();

        gamePresenter.callGameDataInteractor();
        gamePresenter.callPlayerDataInteractor();

    }

    private void initializeRecyclerView() {
        recycler_view = (RecyclerView)findViewById(R.id.recycler_view);
        recycler_view.setLayoutManager(new LinearLayoutManager(this));
        recycler_view.addItemDecoration(new ItemsMarginDecorator(getApplication().getResources().getDimensionPixelSize(R.dimen.item_margin)));
    }

    private void establishConnection() {

        gamePresenter.bindView(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        gamePresenter.unBindView();
    }

    @Override
    public void shouldShowDataInRecyclerView(List<Data> result) {

        recycler_view.setAdapter(new GameAdapter(result, R.layout.row_item, getApplicationContext()));
    }

    @Override
    public void showPlayerData(PlayerData playerData) {

        tvPlayer_Name.setText(String.format(playerData.getName()));

        String url = playerData.getAvatarLink();
        Picasso.with(getApplicationContext()).load(url).into(ivPlayer_Avatar);

        tvPlayer_Balance.setText(String.valueOf(playerData.getBalance()));
        tvPlayer_Login.setText(playerData.getLastLogindate());
    }
}
