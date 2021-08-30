package com.mycoding.foodorderingsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class BurgerActivity extends AppCompatActivity {
    ListView list;
    String[] title = {
            "Classic Burger",
            "Grilled Burger",
            "Simple Veg Burger"
    };

    String[] subTitle ={
            "Burger",
            "Burger",
            "Burger"
    };

    String[] price = {
            "120", "100", "80"
    };

    Integer[] imageId = {
            R.drawable.img8, R.drawable.img10, R.drawable.img14
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_burger);

        ListItem adapter = new ListItem(BurgerActivity.this, title, subTitle,price, imageId);

        list = findViewById(R.id.burger_list);
        list.setAdapter(adapter);
    }
}