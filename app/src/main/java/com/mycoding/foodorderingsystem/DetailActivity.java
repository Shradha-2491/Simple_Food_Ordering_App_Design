package com.mycoding.foodorderingsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {
    ImageView image;
    TextView dish_name, dish_detail, dish_price;
    Button Buy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        image = findViewById(R.id.list_img);
        dish_name= findViewById(R.id.dish_name);
        dish_detail = findViewById(R.id.dish_details);
        dish_price = findViewById(R.id.dish_price);
        Buy = findViewById(R.id.buy);

        image.setImageResource(getIntent().getIntExtra("image", 0));
        dish_name.setText(getIntent().getStringExtra("dishName"));
        dish_detail.setText(getIntent().getStringExtra("dishDetail"));
        dish_price.setText(getIntent().getStringExtra("price"));

        Buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DetailActivity.this, "You have selected Buy Product ", Toast.LENGTH_SHORT).show();
            }
        });
    }
}