package com.example.olenburg.projectwo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.olenburg.projectwo.model.Cinema;
import com.example.olenburg.projectwo.model.CinemaObject;
import com.example.olenburg.projectwo.network.ApiClient;
import com.example.olenburg.projectwo.ui.ResAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieActivity extends AppCompatActivity {
    List<Cinema> movie;
    String id;
    Bundle extras;
    ResAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        extras = getIntent().getExtras();
        id = extras.getString("id");
        System.out.println("thid id id: " + id);
        adapter = new ResAdapter((List<Cinema>)new ArrayList<Cinema>());



    ApiClient.getClient().getKino("kiev", "1383170400", id).enqueue(new Callback<CinemaObject>() {
        @Override
        public void onResponse(Call<CinemaObject> call, Response<CinemaObject> response) {
        if (response.isSuccessful()) {
        movie =  response.body().getData();
        adapter.setData(movie);
        Log.e("__Kino___", movie.get(0).getSessions().get(0).getSessions() + "");
        }
        else
        Log.e("____", response.message());
        }

        @Override
        public void onFailure(Call<CinemaObject> call, Throwable t) {

        }
    });


        RecyclerView recyclerView = findViewById(R.id.resview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));//vertical line between items
        recyclerView.setAdapter(adapter);
    }
}
