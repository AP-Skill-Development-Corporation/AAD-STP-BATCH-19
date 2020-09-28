package com.example.exampleretro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class MainActivity extends AppCompatActivity {
    ArrayList<MyModel> list;
    RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = new ArrayList<>();
        rv = findViewById(R.id.rv);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://newsapi.org/v2/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
        Call<String> response = retrofit.create(MyInterface.class).value();
        response.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                String s = response.body();
                try {
                    JSONObject root  = new JSONObject(s);
                    JSONArray articles = root.getJSONArray("articles");
                    for (int i=0;i<articles.length();i++){
                        JSONObject obj = articles.getJSONObject(i);
                        String title = obj.getString("title");
                        String link = obj.getString("urlToImage");
                        MyModel model = new MyModel(title,link);
                        list.add(model);    
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
                MyAdapter adapter = new MyAdapter(MainActivity.this,list);
                rv.setAdapter(adapter);
                rv.setLayoutManager(new LinearLayoutManager(MainActivity.this));
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Failed to fetch",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}