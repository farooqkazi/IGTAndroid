package com.example.kazi.igtandroid.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import com.example.kazi.igtandroid.DetailActivity;

import com.example.kazi.igtandroid.model.Data;
import com.example.kazi.igtandroid.model.GameDataParcel;
import com.result.kazi.igtandroid.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Kazi on 22/Jun/17.
 */

public class GameAdapter extends RecyclerView.Adapter<GameAdapter.GameViewHolder> {

    private List<Data> result;
    private int row_item;
    private Context mContext;


    public GameAdapter(List<Data> result, int row_item, Context mContext) {
        this.result = result;
        this.row_item = row_item;
        this.mContext = mContext;
    }

    @Override
    public GameViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(row_item,parent,false);
        return new GameViewHolder(v);
    }

    @Override
    public void onBindViewHolder(GameViewHolder holder, final int position) {

        holder.tvName.setText(String.format("Name: " + result.get(position).getName()));
        holder.tvName.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                GameDataParcel gameDataParcel = new GameDataParcel(result.get(position).getName(),
                        result.get(position).getDate(),
                        String.valueOf(result.get(position).getJackpot()));

                Intent intent = new Intent(mContext, DetailActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                intent.putExtra("gameData", gameDataParcel);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    public class GameViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.gameDataR) TextView tvName;


        public GameViewHolder(View itemView) {
            super(itemView);

            tvName = (TextView) itemView.findViewById(R.id.gameDataR);
            ButterKnife.bind(this, itemView);


        }
    }

}
