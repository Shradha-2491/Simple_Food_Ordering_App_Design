package com.mycoding.foodorderingsystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    RecyclerView horRecyclerView;
    LinearLayout dotsLayout;
    SliderAdapter adapter;
    ViewPager2 pager2;
    ImageButton cart;
    int list[];
    TextView[] dot;
    ArrayList<PopularProduct>  popularProducts;
    PopularAdapter popularAdapter;
    public CardView pizza, burger, fried_rice, ice_cream;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dotsLayout = findViewById(R.id.dots_container);
        pager2 = findViewById(R.id.viewpager2);
        horRecyclerView = findViewById(R.id.hor_recycler_view);
        pizza = (CardView) findViewById(R.id.pizza);
        burger = (CardView) findViewById(R.id.burger);
        fried_rice = (CardView) findViewById(R.id.fried_rice);
        ice_cream = (CardView) findViewById(R.id.ice_cream);
        cart = findViewById(R.id.my_cart);

        list = new int[3];
        list[0] = R.drawable.free_delivery;
        list[1] = R.drawable.banner;
        list[2] = R.drawable.free_delivery1;

        Integer[] popularPhoto = {R.drawable.img9, R.drawable.img10, R.drawable.img3, R.drawable.ice_cream};

        String[]  popularTitles = {"Farm House","Luger Burger", "Thai-style fried rice", "Chocolate Ice cream"};
        String[]  popularSubTitles = {"A pizza that goes ballistic on veggies! Check out this mouth watering overload of crunchy, crisp capsicum, succulent mushrooms and fresh tomatoes", "Onion with cheese", "seasoned with pasta", "With Chocolate flavor"};

        String[] popularPrice = {"Rs. 80","Rs. 75", "Rs. 60", "Rs. 50"};

        adapter = new SliderAdapter(list);
        pager2.setAdapter(adapter);

        dot = new TextView[3];

        dotsIndicator();

        pager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                selectedIndicator(position);
                super.onPageSelected(position);
            }
        });

        pizza.setOnClickListener(this);
        burger.setOnClickListener(this);
        fried_rice.setOnClickListener(this);
        ice_cream.setOnClickListener(this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        if (toolbar != null){
            setSupportActionBar(toolbar);
        }
        popularProducts = new ArrayList<>();
        for(int i=0; i<popularPhoto.length; i++){
            PopularProduct product = new PopularProduct(popularPhoto[i], popularTitles[i],  popularSubTitles[i], popularPrice[i]);
            popularProducts.add(product);
        }
        LinearLayoutManager layoutManager = new LinearLayoutManager( MainActivity.this, LinearLayoutManager.HORIZONTAL, false);

        horRecyclerView.setLayoutManager(layoutManager);
        horRecyclerView.setItemAnimator(new DefaultItemAnimator());

        popularAdapter = new PopularAdapter(MainActivity.this, popularProducts);
        horRecyclerView.setAdapter(popularAdapter);

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "You have selected my cart", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onClick(View v) {
        Intent i;

        switch(v.getId()) {
            case R.id.pizza:
                i = new Intent(MainActivity.this, PizzaActivity.class);
                startActivity(i);
                break;
            case R.id.burger:
                i = new Intent(MainActivity.this, BurgerActivity.class);
                startActivity(i);
                break;
            case R.id.fried_rice:
                i = new Intent(MainActivity.this, RiceActivity.class);
                startActivity(i);
                break;
            case R.id.ice_cream:
                i = new Intent(MainActivity.this, IceCreamActivity.class);
                startActivity(i);
                break;
        }
    }

    private void selectedIndicator(int position) {
        for(int i = 0; i < dot.length; i++){
            if(i==position){
                dot[i].setTextColor(getResources().getColor(R.color.primary_color_app));
            }
            else {
                dot[i].setTextColor(getResources().getColor(R.color.browser_actions_bg_grey));
            }
        }
    }

    private void dotsIndicator() {
        for(int i =0; i< dot.length; i++){
            dot[i] = new TextView(this);
            dot[i].setText(Html.fromHtml("&#9679;"));
            dot[i].setTextSize(18);
            dotsLayout.addView(dot[i]);
        }
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.sign_out){
            FirebaseAuth.getInstance().signOut();
            finish();
        }
        else if (item.getItemId() == R.id.settings){
            Toast.makeText(MainActivity.this, "You have selected the settings", Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}