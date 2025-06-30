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

public class CategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_category);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        View bottomBar = findViewById(R.id.category_included);
        ImageView ic_category = bottomBar.findViewById(R.id.ic_category);
        TextView tv_category = bottomBar.findViewById(R.id.tv_category);
        ImageView ic_home = bottomBar.findViewById(R.id.ic_home);
        TextView tv_home = bottomBar.findViewById(R.id.tv_home);


        ic_home.setColorFilter(getColor(R.color.white));
        tv_home.setTextColor(getColor(R.color.white));
        ic_category.setColorFilter(getColor(R.color.main));
        tv_category.setTextColor(getColor(R.color.main));



        ImageView favorite = bottomBar.findViewById(R.id.ic_favorite);
        ImageView account = bottomBar.findViewById(R.id.ic_account);


        favorite.setOnClickListener(view -> {
            startActivity(new Intent(this,FavoriteActivity.class));
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





        ArrayList<Category> categories = new ArrayList<>();

        categories.add(new Category("Top Rating",R.drawable.red_dead2));
        categories.add(new Category("Anime",R.drawable.tanjro));
        categories.add(new Category("Action",R.drawable.extraction_3_movie));
        categories.add(new Category("Romantic",R.drawable.gyeongseong_creature_movie));
        categories.add(new Category("Cartoon",R.drawable.spider_man_movie_poster));
        categories.add(new Category("War",R.drawable.extraction2));


        RecyclerView catRv = findViewById(R.id.rv_category);
        RecyclerView.LayoutManager manager = new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false);
        CategoryAdapter adapter = new CategoryAdapter(this,categories);

        catRv.setLayoutManager(manager);
        catRv.setAdapter(adapter);

    }
}