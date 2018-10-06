package com.example.olenburg.projectwo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;


import com.example.olenburg.projectwo.model.Cinema;
import com.example.olenburg.projectwo.model.CinemaObject;
import com.example.olenburg.projectwo.model.Teatr;
import com.example.olenburg.projectwo.model.TeatrObject;
import com.example.olenburg.projectwo.model.TeatrObjectParser;
import com.example.olenburg.projectwo.network.ApiClient;
import com.example.olenburg.projectwo.ui.ResAdapter;
import com.example.olenburg.projectwo.ui.TeatrAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity implements TeatrAdapter.OnItemClickListener{

    List<Teatr> teatrs;
    TeatrAdapter adapterT;

    @Override
    public void onTeatrClick(String id) {
        Intent i = new Intent(this, MovieActivity.class);
        i.putExtra("id", id);
        startActivity(i);
    }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);


        adapterT = new TeatrAdapter((List<Teatr>) new ArrayList<Teatr>(), this);

        ApiClient.getClient().getTeatr().enqueue(new Callback<TeatrObjectParser>() {
            @Override
            public void onResponse(Call<TeatrObjectParser> call, Response<TeatrObjectParser> response) {
                teatrs = response.body().getResult().getData();
                adapterT.setData(teatrs);
            }

            @Override
            public void onFailure(Call<TeatrObjectParser> call, Throwable t) {
                Log.e("_________", t.getMessage());
            }
        });

        RecyclerView recyclerView = findViewById(R.id.resview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));//vertical line between items
        recyclerView.setAdapter(adapterT);

    }

}
