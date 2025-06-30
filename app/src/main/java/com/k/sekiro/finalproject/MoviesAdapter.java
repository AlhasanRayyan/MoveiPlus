package com.k.sekiro.finalproject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



import java.util.ArrayList;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MoviesHolder>{

    ArrayList<Movie> movies;
    Activity activity;
    public MoviesAdapter(Activity activity, ArrayList<Movie> movies){
        this.movies = movies;
        this.activity = activity;
    }

    @NonNull
    @Override
    public MoviesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View root = LayoutInflater.from(activity).inflate(R.layout.movie_item,parent,false);
        return new MoviesHolder(root);
       // MovieItemBinding binding = MovieItemBinding.inflate(activity.getLayoutInflater(),parent,false);
       // return new MoviesHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull MoviesHolder holder, int position) {
        Movie movie = movies.get(position);
        holder.img.setImageResource(movie.img);
        holder.name.setText(movie.name);

        holder.movieItem.setOnClickListener(view -> {
            Intent intent = new Intent(activity,DetailsActivity.class);
            intent.putExtra("movie",movie);

            activity.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    class MoviesHolder extends RecyclerView.ViewHolder{

        ImageView img;
        TextView name;
        View movieItem;

        public MoviesHolder(View movieItem){
            super(movieItem);

            img = movieItem.findViewById(R.id.movie_img);
            name = movieItem.findViewById(R.id.movie_name);
            this.movieItem = movieItem;


        }

    }
}
