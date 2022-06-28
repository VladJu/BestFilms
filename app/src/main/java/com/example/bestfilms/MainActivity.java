package com.example.bestfilms;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Notification;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import com.example.bestfilms.data.Movie;
import com.example.bestfilms.utils.JSONUtils;
import com.example.bestfilms.utils.NetworkUtils;
import com.google.android.material.switchmaterial.SwitchMaterial;

import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewPosters;
    private MovieAdapter adapter;
    //private SwitchCompat switchSort;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerViewPosters=findViewById(R.id.recyclerViewPosters);
       // switchSort=findViewById(R.id.switchSort);
        recyclerViewPosters.setLayoutManager(new GridLayoutManager(this,2));
        adapter=new MovieAdapter();
        recyclerViewPosters.setAdapter(adapter);
        JSONObject jsonObject= NetworkUtils.getJSONFromNetwork(NetworkUtils.POPULARITY,1);
        ArrayList<Movie>movies=JSONUtils.getMoviesFromJSON(jsonObject);
        adapter.setMovies(movies);
        //switchSort.setChecked(true);//установлен как самые рейтинговые
       /* switchSort.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                //Сортируем фильмы по популярности и рейтингу
                int methodOfSort;
                if (isChecked) {
                    methodOfSort=NetworkUtils.TOP_RATED;
                }else {
                    methodOfSort=NetworkUtils.POPULARITY;
                }
                //Получеам список фильмов

            }
        });
        switchSort.setChecked(false);*/

    }
}