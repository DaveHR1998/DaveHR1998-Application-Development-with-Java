package com.smu.fullapplication;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class ArrayAdapterActivity extends AppCompatActivity {

    ListView listView;
    String[] items = {"Dog", "Cat", "Rabbit", "Elephant"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array_adapter);

        listView = findViewById(R.id.arrayListView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.list_item_text, R.id.textItem, items);
        listView.setAdapter(adapter);
    }
}

