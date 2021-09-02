package com.example.restaurantapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    protected void onResume() {
        super.onResume();
        Button goToAddDishButton =findViewById(R.id.addDishButton);
        goToAddDishButton.setOnClickListener(view -> {
            Intent goToAddDishIntent=new Intent(MainActivity.this,AddDishActivity.class);
            startActivity(goToAddDishIntent);
        });

        Button goToMenuButton =findViewById(R.id.menuButton);
        goToMenuButton.setOnClickListener(view -> {
            Intent goToMenuIntent=new Intent(this,MenuActivity.class);
            startActivity(goToMenuIntent);
        });

    }
}