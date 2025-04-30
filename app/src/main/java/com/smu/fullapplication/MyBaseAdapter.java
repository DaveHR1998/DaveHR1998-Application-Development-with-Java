package com.smu.fullapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyBaseAdapter extends BaseAdapter {

    Context context;
    String[] titles;
    int[] images;
    LayoutInflater inflater;

    public MyBaseAdapter(Context context, String[] titles, int[] images) {
        this.context = context;
        this.titles = titles;
        this.images = images;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public Object getItem(int i) {
        return titles[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.list_item_custom, null);
        TextView text = view.findViewById(R.id.textView);
        ImageView image = view.findViewById(R.id.imageView);

        text.setText(titles[i]);
        image.setImageResource(images[i]);

        return view;
    }
}

