package com.mycoding.foodorderingsystem;

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

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.ViewHolder> {
    ArrayList<com.mycoding.foodorderingsystem.PopularProduct> popularProducts;
    Context context;

    public  PopularAdapter(Context context, ArrayList<com.mycoding.foodorderingsystem.PopularProduct> popularProducts){
        this.context = context;
        this.popularProducts = popularProducts;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.static_recycler_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final PopularProduct temp = popularProducts.get(position);

        holder.popularImageView.setImageResource(popularProducts.get(position).getPopularPhoto());
        holder.textPTitle.setText(popularProducts.get(position).getPopularTitles());
        holder.textPSubTitle.setText(popularProducts.get(position).getPopularSubTitle());
        holder.popularPrice.setText(popularProducts.get(position).getPopularPrice());

        holder.popularImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("image", temp.getPopularPhoto());
                intent.putExtra("dishName", temp.getPopularTitles());
                intent.putExtra("dishDetail", temp.getPopularSubTitle());
                intent.putExtra("price", temp.getPopularPrice());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
        holder.textPTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("image", temp.getPopularPhoto());
                intent.putExtra("dishName", temp.getPopularTitles());
                intent.putExtra("dishDetail", temp.getPopularSubTitle());
                intent.putExtra("price", temp.getPopularPrice());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return popularProducts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView popularImageView;
        TextView textPTitle;
        TextView textPSubTitle;
        TextView popularPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            popularImageView = itemView.findViewById(R.id.imagePopular);
            textPTitle = itemView.findViewById(R.id.popularTitle);
            textPSubTitle = itemView.findViewById(R.id.subTitlePopular);
            popularPrice = itemView.findViewById(R.id.priceTop);
        }
    }
}
