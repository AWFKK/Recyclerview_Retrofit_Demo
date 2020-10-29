package com.example.recyclerview_demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;


import com.example.recyclerview_demo.Adapter.HeroesAdapter;
import com.example.recyclerview_demo.Api.RetrofitClient;
import com.example.recyclerview_demo.Model.Hero;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView gridRecycler;
    HeroesAdapter adapter;

    List<Hero> heroList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridRecycler = findViewById(R.id.recyclerview);
        GridLayoutManager mGrid = new GridLayoutManager(MainActivity.this, 2);
        gridRecycler.setLayoutManager(mGrid);
        gridRecycler.setHasFixedSize(true);


        GetData();
    }


    public void GetData()
    {
        Call<List<Hero>> call = RetrofitClient
                .getInstance()
                .getApi()
                .getHeroes();

        call.enqueue(new Callback<List<Hero>>() {
            @Override
            public void onResponse(Call<List<Hero>> call, Response<List<Hero>> response) {
                Log.e("rViewModel",response.body().size()+"");

                //Setting Response Into Model Class
                heroList = response.body();

                Log.e("rViewModel",heroList.size()+"");

                //Setting Adapter
                adapter = new HeroesAdapter(MainActivity.this, heroList);
                gridRecycler.setAdapter(adapter);

            }


            @Override
            public void onFailure(Call<List<Hero>> call, Throwable t) {

            }
        });
    }
}