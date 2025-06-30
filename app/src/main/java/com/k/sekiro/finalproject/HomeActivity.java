package com.k.sekiro.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.home_activity);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        ArrayList<Movie> topMovies = new ArrayList<Movie>();
        topMovies.add(new Movie("Extraction 3",R.drawable.extraction_3_movie,getString(R.string.lurem),"10/01/2025","02:36:00","Action | War",5.0f,"USA "+getString(R.string.usa)));
        topMovies.add(new Movie("Spider Man",R.drawable.spider_man_movie_poster,getString(R.string.lurem),"17/12/2024","01:20:05","Action | Cartoon",4,"USA "+getString(R.string.usa)));
        topMovies.add(new Movie("Gyeongseong Creature",R.drawable.gyeongseong_creature_movie,getString(R.string.lurem),"02/03/2023","03:00:00","Action | War | Romantic",5.0f,"Korea "+getString(R.string.korea)));
        topMovies.add(new Movie("Its Whats Inside",R.drawable.its_whats_inside_movie,getString(R.string.lurem),"03/01/2023","02:20:00","Romantic",3.0f,"USA "+getString(R.string.usa)));

        ArrayList<Movie> recentMovies = new ArrayList<Movie>();
        recentMovies.add(new Movie("Extraction 2", R.drawable.extraction2, getString(R.string.lurem), "04/05/2022", "02:10:15", "Action | War",5.0f,"USA "+getString(R.string.usa)));
        recentMovies.add(new Movie("Red Dead 2", R.drawable.red_dead2, getString(R.string.lurem), "16/10/2018", "02:20:30", "Action | Extrusion | Fight | Thefts | Gangs",5.0f,"USA "+getString(R.string.usa)));
        recentMovies.add(new Movie("Kimtso No Yaba", R.drawable.tanjro, getString(R.string.lurem), "02/02/2022", "04:00:00", "Anime | Horror | Extrusion",4.2f,"Japan "+getString(R.string.japan)));
        recentMovies.add(new Movie("La Casa De papel", R.drawable.la_casa_de_papel, getString(R.string.lurem), "12/06/2021", "10:40:05", "Action | Romantic | War",3.5f,"USA "+getString(R.string.usa)));



        MoviesAdapter topAdapter = new MoviesAdapter(this,topMovies);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL,false);

        RecyclerView rvTop = findViewById(R.id.rv_top);
        rvTop.setAdapter(topAdapter);
        rvTop.setLayoutManager(manager);

        MoviesAdapter recentAdapter = new MoviesAdapter(this,recentMovies);
        RecyclerView.LayoutManager manager2 = new LinearLayoutManager(this, RecyclerView.HORIZONTAL,false);
        RecyclerView rvRecent = findViewById(R.id.rv_recent);

        rvRecent.setAdapter(recentAdapter);
        rvRecent.setLayoutManager(manager2);


        View included = findViewById(R.id.home_included);
        ImageView account = included.findViewById(R.id.ic_account);
        ImageView favorite = included.findViewById(R.id.ic_favorite);
        ImageView category = included.findViewById(R.id.ic_category);

        account.setOnClickListener(view -> {
            startActivity(new Intent(this,AccountActivity.class));
            finish();
        });

        favorite.setOnClickListener(view -> {
            startActivity(new Intent(this,FavoriteActivity.class));
            finish();
        });

        category.setOnClickListener(view -> {
            startActivity(new Intent(this,CategoryActivity.class));
            finish();
        });





    }


}