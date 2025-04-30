package com.smu.fullapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class CustomAdapter extends ArrayAdapter<String> {

    Context context;
    String[] names;
    int[] images;

    public CustomAdapter(Context context, String[] names, int[] images) {
        super(context, R.layout.list_item_custom, R.id.textView, names);
        this.context = context;
        this.names = names;
        this.images = images;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(R.layout.list_item_custom, parent, false);

        ImageView img = row.findViewById(R.id.imageView);
        TextView txt = row.findViewById(R.id.textView);

        img.setImageResource(images[position]);
        txt.setText(names[position]);

        return row;
    }
}
