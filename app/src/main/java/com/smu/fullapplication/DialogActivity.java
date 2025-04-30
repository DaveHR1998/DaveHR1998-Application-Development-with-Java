package com.smu.fullapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class DialogActivity extends AppCompatActivity {

    private Button showAlertDialogButton;
    private Button showSingleChoiceDialogButton;
    private Button showMultiChoiceDialogButton;
    private Button showDatePickerDialogButton;
    private Button showTimePickerDialogButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        // Initialize buttons
        showAlertDialogButton = findViewById(R.id.showAlertDialogButton);
        showSingleChoiceDialogButton = findViewById(R.id.showSingleChoiceDialogButton);
        showMultiChoiceDialogButton = findViewById(R.id.showMultiChoiceDialogButton);
        showDatePickerDialogButton = findViewById(R.id.showDatePickerDialogButton);
        showTimePickerDialogButton = findViewById(R.id.showTimePickerDialogButton);

        // Show Alert Dialog
        showAlertDialogButton.setOnClickListener(v -> showAlertDialog());

        // Show Single Choice Dialog
        showSingleChoiceDialogButton.setOnClickListener(v -> showSingleChoiceDialog());

        // Show Multi Choice Dialog
        showMultiChoiceDialogButton.setOnClickListener(v -> showMultiChoiceDialog());

        // Show Date Picker Dialog
        showDatePickerDialogButton.setOnClickListener(v -> showDatePickerDialog());

        // Show Time Picker Dialog
        showTimePickerDialogButton.setOnClickListener(v -> showTimePickerDialog());
    }

    // Alert Dialog
    private void showAlertDialog() {
        new AlertDialog.Builder(this)
                .setTitle("Simple Alert")
                .setMessage("This is a simple alert dialog.")
                .setPositiveButton("OK", (dialog, which) -> Toast.makeText(DialogActivity.this, "OK clicked", Toast.LENGTH_SHORT).show())
                .setNegativeButton("Cancel", (dialog, which) -> Toast.makeText(DialogActivity.this, "Cancel clicked", Toast.LENGTH_SHORT).show())
                .show();
    }

    // Single Choice Dialog
    private void showSingleChoiceDialog() {
        final String[] options = {"Option 1", "Option 2", "Option 3"};
        new AlertDialog.Builder(this)
                .setTitle("Single Choice Dialog")
                .setSingleChoiceItems(options, -1, (dialog, which) -> Toast.makeText(DialogActivity.this, "Selected: " + options[which], Toast.LENGTH_SHORT).show())
                .setPositiveButton("OK", null)
                .setNegativeButton("Cancel", null)
                .show();
    }

    // Multi Choice Dialog
    private void showMultiChoiceDialog() {
        final String[] options = {"Option 1", "Option 2", "Option 3"};
        boolean[] checkedItems = {false, false, false};
        new AlertDialog.Builder(this)
                .setTitle("Multi Choice Dialog")
                .setMultiChoiceItems(options, checkedItems, (dialog, which, isChecked) -> Toast.makeText(DialogActivity.this, options[which] + (isChecked ? " selected" : " deselected"), Toast.LENGTH_SHORT).show())
                .setPositiveButton("OK", null)
                .setNegativeButton("Cancel", null)
                .show();
    }

    // Date Picker Dialog
    private void showDatePickerDialog() {
        DatePickerDialogFragment newFragment = new DatePickerDialogFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    // Time Picker Dialog
    private void showTimePickerDialog() {
        TimePickerDialogFragment newFragment = new TimePickerDialogFragment();
        newFragment.show(getSupportFragmentManager(), "timePicker");
    }
}
