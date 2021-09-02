package com.example.restaurantapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class DishAdapter extends RecyclerView.Adapter<DishAdapter.DishViewHolder> {
    List<Dish> allDishes = new ArrayList<Dish>();
    Context context;

    public DishAdapter(List<Dish> allDishes, Context context) {
        this.allDishes = allDishes;
        this.context=context;
    }


    public static class DishViewHolder extends RecyclerView.ViewHolder{
        public Dish dish;

        View itemView;

      public DishViewHolder(@NonNull View itemView){
          super(itemView);
          this.itemView=itemView;
      }
    }

    @NonNull
    @Override
    public DishViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_dish,parent,false);
        DishViewHolder dishViewHolder =new DishViewHolder(view);
        return dishViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull  DishAdapter.DishViewHolder holder, int position) {

        holder.dish=allDishes.get(position);
        TextView dishName=holder.itemView.findViewById(R.id.fragmentDishName);
        TextView dishPrice=holder.itemView.findViewById(R.id.fragmentDishPrice);

        dishName.setText(holder.dish.dishName);
        dishPrice.setText(holder.dish.dishPrice);

        holder.itemView.setOnClickListener(view -> {
            Intent goToDetail=new Intent(context,DishDetailsActivity.class);
            goToDetail.putExtra("Name",holder.dish.dishName);
            goToDetail.putExtra("Price",holder.dish.dishPrice);
            goToDetail.putExtra("Ingredients",holder.dish.ingredients);
            context.startActivity(goToDetail);

        });
    }

    @Override
    public int getItemCount() {
        return allDishes.size();
    }
}
