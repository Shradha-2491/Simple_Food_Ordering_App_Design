package com.mycoding.foodorderingsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class RiceActivity extends AppCompatActivity {
    ListView list;
    String[] title = {
            "Indian Style Fried Rice",
            "Lighter Fried Rice"
    };

    String[] subTitle ={
            "Fried Rice",
            "Fried Rice",
    };
    String[] price = {
            "2000", "120"
    };

    Integer[] imageId = {
            R.drawable.img3, R.drawable.img5
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rice);

        ListItem adapter = new ListItem(RiceActivity.this, title, subTitle, price, imageId);

        list = findViewById(R.id.fried_rice_list);
        list.setAdapter(adapter);
    }
}