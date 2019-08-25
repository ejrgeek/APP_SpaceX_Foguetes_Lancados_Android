package com.ejrgeek.usandonetworking.Main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.ejrgeek.usandonetworking.Models.RocketModel;
import com.ejrgeek.usandonetworking.Network.APIService;
import com.ejrgeek.usandonetworking.Network.RESTClient;
import com.ejrgeek.usandonetworking.R;
import com.ejrgeek.usandonetworking.Recyclerview.RecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    APIService apiService;

    ArrayList<RocketModel> rocketModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        apiService = RESTClient.getService();

        rocketModels = new ArrayList<>();

        progressBar.setVisibility(View.VISIBLE);

        apiService.getRockets("desc").enqueue(new Callback<List<RocketModel>>() {
            @Override
            public void onResponse(Call<List<RocketModel>> call, Response<List<RocketModel>> response) {

                Log.d(TAG, "onResponse: " + response.body().toString());

                rocketModels.addAll(response.body());

                for (RocketModel rocketModel : rocketModels){
                    Log.d(TAG, "rocketModel: " + rocketModel.toString());
                }

                mRecyclerView.setAdapter(new RecyclerAdapter(rocketModels));

                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<List<RocketModel>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);

    }

}
