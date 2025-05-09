package com.smu.fullapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class SimpleListViewActivity extends AppCompatActivity {

    ListView listView;
    String[] items = {"Section B", "Section C", "Section D", "Section E"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_listview);

        listView = findViewById(R.id.simpleListView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            String selectedSection = items[position];
            Intent intent = new Intent(SimpleListViewActivity.this, StudentActivity.class);
            intent.putExtra("SELECTED_SECTION", selectedSection);
            startActivity(intent);
        });
    }
}
