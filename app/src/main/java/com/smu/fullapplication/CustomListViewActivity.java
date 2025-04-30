package com.smu.fullapplication;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class CustomListViewActivity extends AppCompatActivity {

    ListView listView;
    String[] names = {"Facebook", "Instagram", "Twitter"};
    int[] images = {R.drawable.facebook, R.drawable.instagram, R.drawable.twitter};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_listview);

        listView = findViewById(R.id.customListView);
        CustomAdapter adapter = new CustomAdapter(this, names, images);
        listView.setAdapter(adapter);
    }
}
