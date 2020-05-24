package com.EFYSoftware;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private List<Memes> memes = new ArrayList<>();
    private RecyclerView recyclerView;
    private FlipAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_main);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.imgflip.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiClient apiClient = retrofit.create(ApiClient.class);
        Call<Flip> call = apiClient.getFlips();
        call.enqueue(new Callback<Flip>() {
            @Override
            public void onResponse(Call<Flip> call, Response<Flip> response) {
                memes = response.body().getData().getMemes();
                adapter = new FlipAdapter(getApplicationContext(),memes);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<Flip> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Erro ao buscar dados da api" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
