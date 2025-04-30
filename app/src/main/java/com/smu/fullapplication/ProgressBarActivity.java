package com.smu.fullapplication;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ProgressBarActivity extends AppCompatActivity {

    private ProgressBar indeterminateBar, determinateBar;
    private Button startButton;
    private int progressStatus = 0;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);

        indeterminateBar = findViewById(R.id.indeterminateProgressBar);
        determinateBar = findViewById(R.id.determinateProgressBar);
        startButton = findViewById(R.id.startProgressButton);

        // Initially hide indeterminate bar
        indeterminateBar.setVisibility(View.GONE);

        startButton.setOnClickListener(v -> {
            // Show indeterminate progress bar
            indeterminateBar.setVisibility(View.VISIBLE);


            progressStatus = 0;
            determinateBar.setProgress(0);

            // Simulate a long task in background
            new Thread(() -> {
                while (progressStatus < 100) {
                    progressStatus += 1;

                    handler.post(() -> determinateBar.setProgress(progressStatus));

                    try {
                        Thread.sleep(50); // Simulate work
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                handler.post(() -> {
                    indeterminateBar.setVisibility(View.GONE);
                    Toast.makeText(ProgressBarActivity.this, "Task Completed", Toast.LENGTH_SHORT).show();
                });
            }).start();
        });
    }
}
