package com.example.restaurantapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
//import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MenuActivity extends AppCompatActivity {
    AppDatabase appDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Button goToHomeButton=findViewById(R.id.goHomeFromMenuButton);
        goToHomeButton.setOnClickListener(view -> {
            Intent goToHomeIntent=new Intent(this,MainActivity.class);
            startActivity(goToHomeIntent);
        });
        appDatabase =  Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "Dish").allowMainThreadQueries()
                .build();
        List<Dish>allDishes=appDatabase.dishDao().getAll();
        Toast.makeText(getApplicationContext(),allDishes.get(0).dishName,Toast.LENGTH_LONG).show();

        RecyclerView recyclerView=findViewById(R.id.dishesListRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new DishAdapter(allDishes,this));

    }
}