package com.mycoding.foodorderingsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class PizzaActivity extends AppCompatActivity {
    ListView list;
    String[] title = {
            "Farm House",
            "Pequod's Pizza",
            "Totonno's Pizzeria Napolitano",
            "Mexican Green Wave",
            "Indi Tandoori Paneer",

    };

    String[] subTitle ={
            "A pizza that goes ballistic on veggies! Check out this mouth watering overload of crunchy, crisp capsicum, succulent mushrooms and fresh tomatoes",
            "Italian Sausage Pan Pizza",
            "Mushroom and Pepperoni Pie",
            "A pizza loaded with crunchy onions, crisp capsicum, juicy tomatoes and jalapeno with a liberal sprinkling of exotic Mexican herbs." ,
            "t is hot. It is spicy. It is oh-so-Indian. Tandoori paneer with capsicum I red paprika I mint mayo",
    };

    String[] price = {
            "80", "125","150", "120", "190"
    };

    Integer[] imageId = {
           R.drawable.img7, R.drawable.img9, R.drawable.img11, R.drawable.img13, R.drawable.img15
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza);

        ListItem adapter = new ListItem(PizzaActivity.this, title, subTitle,price, imageId);

        list = findViewById(R.id.pizza_list);
        list.setAdapter(adapter);
    }
}