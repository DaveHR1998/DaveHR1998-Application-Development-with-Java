package com.smu.fullapplication;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class BaseAdapterListViewActivity extends AppCompatActivity {

    ListView listView;
    String[] fruits = {"Mango", "Pineapple", "Strawberry"};
    int[] icons = {R.drawable.mango, R.drawable.pineapple, R.drawable.strawberry};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_adapter);

        listView = findViewById(R.id.baseListView);
        listView.setAdapter(new MyBaseAdapter(this, fruits, icons));
    }
}
