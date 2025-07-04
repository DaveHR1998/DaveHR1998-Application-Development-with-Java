package com.smu.fullapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.smu.fullapplication.ArrayAdapterActivity;
import com.smu.fullapplication.BaseAdapterListViewActivity;
import com.smu.fullapplication.CustomListViewActivity;
import com.smu.fullapplication.R;
import com.smu.fullapplication.SimpleListViewActivity;
import com.smu.fullapplication.adapter.FragmentDemoActivity;
import com.smu.fullapplication.database.StorageDemoActivity;
import com.smu.fullapplication.database.SqliteActivity;
import com.smu.fullapplication.room.RoomActivity;

public class MainActivity extends AppCompatActivity {

    Button btnSimple, btnArrayAdapter, btnCustom, btnBaseAdapter,showProgressBarButton,Fragment_Button,Storage_Button,Sqlite_Button,Room_Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSimple = findViewById(R.id.btnSimple);
        btnArrayAdapter = findViewById(R.id.btnArrayAdapter);
        btnCustom = findViewById(R.id.btnCustom);
        btnBaseAdapter = findViewById(R.id.btnBaseAdapter);

        btnSimple.setOnClickListener(v -> startActivity(new Intent(this, SimpleListViewActivity.class)));
        btnArrayAdapter.setOnClickListener(v -> startActivity(new Intent(this, ArrayAdapterActivity.class)));
        btnCustom.setOnClickListener(v -> startActivity(new Intent(this, CustomListViewActivity.class)));
        btnBaseAdapter.setOnClickListener(v -> startActivity(new Intent(this, BaseAdapterListViewActivity.class)));


        Button showDialogActivityButton;

// Inside onCreate method
        showDialogActivityButton = findViewById(R.id.showDialogActivityButton);
        showDialogActivityButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, DialogActivity.class);
            startActivity(intent);
        });


        showProgressBarButton = findViewById(R.id.showProgressBarButton);
        showProgressBarButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ProgressBarActivity.class);
            startActivity(intent);
        });

        Fragment_Button = findViewById(R.id.fragment_id);
        Fragment_Button.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, FragmentDemoActivity.class);
            startActivity(intent);
        });

        Storage_Button = findViewById(R.id.showStorageActivityButton);
        Storage_Button.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, StorageDemoActivity.class);
            startActivity(intent);
        });

        Sqlite_Button = findViewById(R.id.sqlite_id);
        Sqlite_Button.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SqliteActivity.class);
            startActivity(intent);
        });

        Room_Button = findViewById(R.id.room_id);
        Room_Button.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, RoomActivity.class);
            startActivity(intent);
        });


    }

}
