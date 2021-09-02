package com.example.restaurantapp;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Dish {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "dish_name")
    public String dishName;

    @ColumnInfo(name = "dish_price")
    public String dishPrice;

    @ColumnInfo(name = "dish_ingredients")
    public String ingredients;

    public Dish(String dishName, String dishPrice, String ingredients) {
        this.dishName = dishName;
        this.dishPrice = dishPrice;
        this.ingredients = ingredients;
    }

    public int getId() {
        return id;
    }



    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getDishPrice() {
        return dishPrice;
    }

    public void setDishPrice(String dishPrice) {
        this.dishPrice = dishPrice;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }
}
