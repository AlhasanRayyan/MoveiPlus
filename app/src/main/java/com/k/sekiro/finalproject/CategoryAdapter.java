package com.k.sekiro.finalproject;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryHolder> {

    Activity activity;
    ArrayList<Category> categories;

    public CategoryAdapter(Activity activity, ArrayList<Category> categories){
        this.activity = activity;
        this.categories = categories;
    }

    @NonNull
    @Override
    public CategoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(activity).inflate(R.layout.category_item,parent,false);
        return new CategoryHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryHolder holder, int position) {
        Category category = categories.get(position);

        holder.catName.setText(category.name);
        holder.background.setBackgroundResource(category.img);
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }


    static class CategoryHolder extends RecyclerView.ViewHolder{


        View categoryItem;
        LinearLayout background;
        TextView catName;

        public CategoryHolder(View categoryItem){
            super(categoryItem);

            this.categoryItem = categoryItem;
            background = categoryItem.findViewById(R.id.cat_background);
            catName = categoryItem.findViewById(R.id.cat_name);
        }
    }


}
