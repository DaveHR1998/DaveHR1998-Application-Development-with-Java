package com.smu.fullapplication.database;

import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;


import android.Manifest;
import com.smu.fullapplication.R;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;


public class StorageDemoActivity extends AppCompatActivity {
    private static final String FILE_NAME = "demo.txt";
    private static final String PREF_NAME = "MyPrefs";
    private TextView txtOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage_demo);

//        if (ContextCompat.checkSelfPermission(this,
//                Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
//            ActivityCompat.requestPermissions(this,
//                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
//        } else {
//            Toast.makeText(this, "Permission already granted", Toast.LENGTH_SHORT).show();
//        }


        txtOutput = findViewById(R.id.txtOutput);

        findViewById(R.id.btnSaveInternal).setOnClickListener(v -> saveToInternalStorage());
        findViewById(R.id.btnReadInternal).setOnClickListener(v -> readFromInternalStorage());
        findViewById(R.id.btnSaveShared).setOnClickListener(v -> saveToSharedStorage());
        findViewById(R.id.btnSavePref).setOnClickListener(v -> saveToPreferences());
        findViewById(R.id.btnReadPref).setOnClickListener(v -> readFromPreferences());

//        ListView listView = findViewById(R.id.listView);
//        db = new DatabaseHelper(this);
//        nameList = db.getAllNames();
//
//        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, nameList);
//        listView.setAdapter(adapter);
    }

    // 1. App-Specific Internal Storage
    private void saveToInternalStorage() {
        try (FileOutputStream fos = openFileOutput(FILE_NAME, MODE_PRIVATE)) {
            fos.write("Hello from internal storage!".getBytes());
            txtOutput.setText("Saved to internal storage.");
        } catch (IOException e) {
            txtOutput.setText("Error: " + e.getMessage());
        }
    }

    private void readFromInternalStorage() {
        try (FileInputStream fis = openFileInput(FILE_NAME)) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
            StringBuilder result = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line).append("\n");
            }
            txtOutput.setText(result.toString());
        } catch (IOException e) {
            txtOutput.setText("Error: " + e.getMessage());
        }
    }

    // 2. Shared Storage (External)
    private void saveToSharedStorage() {
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            File sharedFile = new File(getExternalFilesDir(null), "shared.txt");
            try (FileWriter writer = new FileWriter(sharedFile)) {
                writer.write("Hello from shared storage!");
                txtOutput.setText("Saved to shared storage at:\n" + sharedFile.getAbsolutePath());
            } catch (IOException e) {
                txtOutput.setText("Error: " + e.getMessage());
            }
        } else {
            txtOutput.setText("External storage not available.");
        }
    }

    // 3. SharedPreferences
    private void saveToPreferences() {
        SharedPreferences prefs = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        prefs.edit().putString("greeting", "Hello from SharedPreferences!").apply();
        txtOutput.setText("Saved to SharedPreferences.");
    }

    private void readFromPreferences() {
        SharedPreferences prefs = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        String message = prefs.getString("greeting", "No data found.");
        txtOutput.setText(message);
    }
}
