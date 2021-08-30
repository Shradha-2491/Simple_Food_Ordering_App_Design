package com.mycoding.foodorderingsystem;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListItem extends ArrayAdapter<String> {
    private final Activity context;
    private final String[] title;
    private final String[] detail;
    private final String[] price;
    private final Integer[] imageId;

    public ListItem(Activity context, String[] title, String[] detail, String[] price, Integer[] imageId) {
        super(context, R.layout.list_item, title);
        this.context = context;
        this.title = title;
        this.detail= detail;
        this.price = price;
        this.imageId = imageId;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent){
        LayoutInflater inflater =context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.list_item, null, true);
        TextView txtTitle = rowView.findViewById(R.id.textViewTitle);
        TextView txtSubTitle = rowView.findViewById(R.id.textViewSubTitle);
        TextView txtPrice = rowView.findViewById(R.id.textViewPrice);
        ImageView imageView = rowView.findViewById(R.id.imageView);

        txtTitle.setText(title[position]);
        txtSubTitle.setText(detail[position]);
        txtPrice.setText(price[position]);
        imageView.setImageResource(imageId[position]);


        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("dishName", title[position]);
                intent.putExtra("dishDetail", detail[position]);
                intent.putExtra("price", price[position]);
                intent.putExtra("image", imageId[position]);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

        return rowView;
    }
}
