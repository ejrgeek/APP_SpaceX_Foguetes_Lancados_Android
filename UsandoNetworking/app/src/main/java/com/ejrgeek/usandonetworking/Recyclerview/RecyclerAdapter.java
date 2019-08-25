package com.ejrgeek.usandonetworking.Recyclerview;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ejrgeek.usandonetworking.Models.Payload;
import com.ejrgeek.usandonetworking.Models.RocketModel;
import com.ejrgeek.usandonetworking.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    ArrayList<RocketModel> rocketModels;

    // CONSTRUTOR
    public RecyclerAdapter(ArrayList<RocketModel> RocketModel) {
        this.rocketModels = RocketModel;
    }


    //RETORNANDO LAYOUT LIST_VIEW
    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }


    // SETANDO DADOS
    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder holder, int position) {
        RocketModel rocketModel = rocketModels.get(position);

        holder.rocketName.setText(rocketModel.getRocket().getmRocketName());
        holder.launchDate.setText(rocketModel.getmLauchYear());

        if (rocketModel.ismStatusLaunch()) {

            holder.statusLaunch.setTextColor(Color.parseColor("#00FF08"));
            holder.statusLaunch.setText("Lançado");
        } else {
            holder.statusLaunch.setTextColor(Color.parseColor("#FF0000"));
            holder.statusLaunch.setText("Não Lançado");
        }

        ArrayList<String> payloadType = new ArrayList<>();

        for (Payload payload : rocketModel.getRocket().getmSecondStage().getPayloads()){

            payloadType.add(payload.getmPayload());

            holder.payload.setText(payloadType.toString());
        }

    }

    // RETORNA QUANTIDADE
    @Override
    public int getItemCount() {
        final int size = rocketModels.size();
        return size;
    }


    // BIND DOS DADOS
    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @BindView(R.id.text_name_rocket)
        TextView rocketName;

        @BindView(R.id.text_launch_date)
        TextView launchDate;

        @BindView(R.id.text_status_launch)
        TextView statusLaunch;

        @BindView(R.id.text_payload)
        TextView payload;

    }

}
