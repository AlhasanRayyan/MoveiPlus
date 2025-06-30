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

import java.util.ArrayList;

import kotlin.random.Random;

public class AccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_account);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        View bottomBar = findViewById(R.id.account_included);
        ImageView ic_account = bottomBar.findViewById(R.id.ic_account);
        TextView tv_account = bottomBar.findViewById(R.id.tv_account);
        ImageView ic_home = bottomBar.findViewById(R.id.ic_home);
        TextView tv_home = bottomBar.findViewById(R.id.tv_home);


        ic_home.setColorFilter(getColor(R.color.white));
        tv_home.setTextColor(getColor(R.color.white));
        ic_account.setColorFilter(getColor(R.color.main));
        tv_account.setTextColor(getColor(R.color.main));



        ImageView favorite = bottomBar.findViewById(R.id.ic_favorite);
        ImageView category = bottomBar.findViewById(R.id.ic_category);



        favorite.setOnClickListener(view -> {
            startActivity(new Intent(this,FavoriteActivity.class));
            finish();
        });

        category.setOnClickListener(view -> {
            startActivity(new Intent(this,CategoryActivity.class));
            finish();
        });

        ic_home.setOnClickListener(view -> {
            startActivity(new Intent(this,HomeActivity.class));
            finish();
        });


    }
}