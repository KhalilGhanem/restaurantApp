package com.example.restaurantapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class AddDishActivity extends AppCompatActivity {
    AppDatabase appDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_dish);
        EditText editTextDishName=findViewById(R.id.editTextDishName);
        EditText editTextDishPrice=findViewById(R.id.editTextDishPrice);
        EditText editTextIngredients=findViewById(R.id.editTextIngredients);
        //get  data from user inputs
//        String dishName=editTextDishName.getText().toString();
//        String dishPrice=editTextDishPrice.getText().toString();
//        String dishIngredients=editTextIngredients.getText().toString();

        Button addDishSubmitButton =findViewById(R.id.addDishSubmitButton);
        addDishSubmitButton.setOnClickListener(view -> {

//            Dish dish=new Dish(dishName,dishPrice,dishIngredients);
            Dish dish=new Dish(editTextDishName.getText().toString(),editTextDishPrice.getText().toString(),editTextIngredients.getText().toString());
            // save dish to the database
            appDatabase =  Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "Dish").allowMainThreadQueries().build();

            DishDao dishDao=appDatabase.dishDao();

            dishDao.insertAll(dish);

            Intent goToMenu=new Intent(this,MenuActivity.class);
            startActivity(goToMenu);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

    }
}