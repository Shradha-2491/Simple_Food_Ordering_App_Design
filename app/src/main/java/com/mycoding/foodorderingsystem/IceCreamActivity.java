package com.mycoding.foodorderingsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class IceCreamActivity extends AppCompatActivity {
    ListView list;
    String[] title = {
            "Chocalate Ice Cream",
            "Mixed Ice Cream",
            "Rice",
    };

    String[] subTitle ={
            "Ice Cream",
            "Ice Cream"
    };

    String[] price = {
            "100", "200"
    };

    Integer[] imageId = {
            R.drawable.ice_cream, R.drawable.img6
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ice_cream);

        ListItem adapter = new ListItem(IceCreamActivity.this, title, subTitle, price, imageId);

        list = findViewById(R.id.ice_cream_list);
        list.setAdapter(adapter);
    }
}