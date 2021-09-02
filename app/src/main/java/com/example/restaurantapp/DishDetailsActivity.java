package com.example.restaurantapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class DishDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dish_details);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Intent intent=getIntent();
        String dishName=intent.getExtras().getString("Name");
        String dishPrice=intent.getExtras().getString("Price");
        String ingredients=intent.getExtras().getString("Ingredients");

        TextView detailsDishName =findViewById(R.id.detailsDishName);
        TextView detailsDishPrice =findViewById(R.id.detailsDishPrice);
        TextView detailsIngredients =findViewById(R.id.detailsIngredients);

        detailsDishName.setText(dishName);
        detailsDishPrice.setText(dishPrice);
        detailsIngredients.setText(ingredients);

        Button goHomeFromDetails=findViewById(R.id.goHomeFromDetails);
        goHomeFromDetails.setOnClickListener(view -> {
            Intent goHomeFromDetailsIntent=new Intent(this,MenuActivity.class);
            startActivity(goHomeFromDetailsIntent);
        });


    }
}