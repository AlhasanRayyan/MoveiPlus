package com.k.sekiro.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FavoriteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_favorite);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        View bottomBar = findViewById(R.id.favorite_included);
        ImageView ic_favorite = bottomBar.findViewById(R.id.ic_favorite);
        TextView tv_favorite = bottomBar.findViewById(R.id.tv_favorite);
        ImageView ic_home = bottomBar.findViewById(R.id.ic_home);
        TextView tv_home = bottomBar.findViewById(R.id.tv_home);


        ic_home.setColorFilter(getColor(R.color.white));
        tv_home.setTextColor(getColor(R.color.white));
        ic_favorite.setColorFilter(getColor(R.color.main));
        tv_favorite.setTextColor(getColor(R.color.main));



        ImageView category = bottomBar.findViewById(R.id.ic_category);
        ImageView account = bottomBar.findViewById(R.id.ic_account);




        category.setOnClickListener(view -> {
            startActivity(new Intent(this,CategoryActivity.class));
            finish();
        });

        account.setOnClickListener(view -> {
            startActivity(new Intent(this,AccountActivity.class));
            finish();
        });

        ic_home.setOnClickListener(view -> {
            startActivity(new Intent(this,HomeActivity.class));
            finish();
        });


        ArrayList<Movie>movies = new ArrayList<>();

        movies.add(new Movie("Red Dead 2", R.drawable.red_dead2, getString(R.string.lurem), "16/10/2018", "02:20:30", "Action | Extrusion | Fight | Thefts | Gangs",5.0f,"USA "+getString(R.string.usa)));
        movies.add(new Movie("Extraction 3",R.drawable.extraction_3_movie,getString(R.string.lurem),"10/01/2025","02:36:00","Action | War",5.0f,"USA "+getString(R.string.usa)));
        movies.add(new Movie("Kimtso No Yaba", R.drawable.tanjro, getString(R.string.lurem), "02/02/2022", "04:00:00", "Anime | Horror | Extrusion",4.2f,"Japan "+getString(R.string.japan)));


        RecyclerView rv = findViewById(R.id.fav_rv);
        FavoriteAdapter adapter = new FavoriteAdapter(this,movies);
        RecyclerView.LayoutManager manager = new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false);

        rv.setLayoutManager(manager);
        rv.setAdapter(adapter);




    }
}