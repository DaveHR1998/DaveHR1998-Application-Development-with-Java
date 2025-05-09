package com.smu.fullapplication;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
public class StudentDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_detail);

        Student student = (Student) getIntent().getSerializableExtra("STUDENT");

        TextView nameTextView = findViewById(R.id.studentNameTextView);
        TextView gpaTextView = findViewById(R.id.studentGpaTextView);
        TextView infoTextView = findViewById(R.id.studentInfoTextView);
        Button submitButton = findViewById(R.id.submitButton);

        nameTextView.setText(student.getName());
        gpaTextView.setText("GPA: " + student.getGpa());
        infoTextView.setText("Personal Info: " + student.getPersonalInfo());

        submitButton.setOnClickListener(v -> showConfirmationDialog());
    }

    private void showConfirmationDialog() {
        new AlertDialog.Builder(this)
                .setTitle("Confirm Submission")
                .setMessage("Are you sure you want to submit?")
                .setPositiveButton("Yes", (dialog, which) -> {

                    Intent intent = new Intent(StudentDetailActivity.this, MainActivity.class);
                    startActivity(intent);
                })
                .setNegativeButton("No", ((dialog, which) -> {
                    Intent intent = new Intent(StudentDetailActivity.this, StudentActivity.class);
                    startActivity(intent);
                }))
                .show();
    }
}