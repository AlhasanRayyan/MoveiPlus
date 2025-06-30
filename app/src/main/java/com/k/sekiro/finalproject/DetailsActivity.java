package com.k.sekiro.finalproject;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.concurrent.atomic.AtomicBoolean;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Movie movie;
        Boolean isFromFav;


        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_details);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.dt_root), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
             movie = getIntent().getSerializableExtra("movie",Movie.class);
        }else {
            movie = (Movie) getIntent().getSerializableExtra("movie");
        }

        isFromFav = getIntent().getBooleanExtra("isFromFav",false);

        ImageView img =  findViewById(R.id.dt_img);
        TextView name = findViewById(R.id.dt_name);
        TextView date = findViewById(R.id.dt_release);
        TextView duration = findViewById(R.id.dt_duration);
        TextView story = findViewById(R.id.dt_story);
        TextView country = findViewById(R.id.dt_country);
        TextView category = findViewById(R.id.dt_category);
        RatingBar rating = findViewById(R.id.dt_rating);
        View scrollView = findViewById(R.id.dt_scroll);
        ImageView favorite = findViewById(R.id.dt_favorite);
        AtomicBoolean isFavorite = new AtomicBoolean(false);


        if (movie != null){
            img.setImageResource(movie.img);
            name.setText(movie.name);
            date.setText(movie.date);
            duration.setText(movie.duration);
            story.setText(movie.description);
            country.setText(movie.country);
            category.setText(movie.category);
            rating.setRating(movie.rating);
            scrollView.setBackgroundResource(movie.img);
        }

        if (!isFromFav){
            favorite.setOnClickListener(view -> {
                if (!isFavorite.get()){
                    favorite.setColorFilter(getColor(R.color.main));
                    isFavorite.set(!isFavorite.get());
                }else {
                    favorite.setColorFilter(getColor(R.color.grey));
                    isFavorite.set(!isFavorite.get());

                }
            });
        }else {
            favorite.setColorFilter(getColor(R.color.main));
        }



    }
}