package com.smu.fullapplication.room;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.smu.fullapplication.R;

public class RoomActivity extends AppCompatActivity {
    private PersonViewModel viewModel;
    private EditText nameInput, ageInput;
    private PersonAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);

        nameInput = findViewById(R.id.nameInput);
        ageInput = findViewById(R.id.ageInput);
        Button addButton = findViewById(R.id.btnAdd);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        adapter = new PersonAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        viewModel = new ViewModelProvider(this).get(PersonViewModel.class);
        viewModel.getAllPersons().observe(this, adapter::setPersons);

        addButton.setOnClickListener(v -> {
            String name = nameInput.getText().toString();
            String ageStr = ageInput.getText().toString();
            if (!name.isEmpty() && !ageStr.isEmpty()) {
                int age = Integer.parseInt(ageStr);
                viewModel.insert(new PersonEntity(name, age));
                nameInput.setText("");
                ageInput.setText("");
            }
        });
    }
}
