package com.smu.fullapplication.database;

import android.app.AlertDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.smu.fullapplication.R;

public class SqliteActivity extends AppCompatActivity {
    EditText nameInput, ageInput, idInput;
    Button btnAdd, btnView, btnUpdate, btnDelete;
    SQLiteHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);
        dbHelper = new SQLiteHelper(this);

        nameInput = findViewById(R.id.nameInput);
        ageInput = findViewById(R.id.ageInput);
        idInput = findViewById(R.id.idInput);
        btnAdd = findViewById(R.id.btnAdd);
        btnView = findViewById(R.id.btnView);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);

        btnAdd.setOnClickListener(v -> {
            String name = nameInput.getText().toString();
            int age = Integer.parseInt(ageInput.getText().toString());
            dbHelper.insertPerson(name, age);
            Toast.makeText(this, "Added", Toast.LENGTH_SHORT).show();
        });

        btnView.setOnClickListener(v -> {
            Cursor cursor = dbHelper.getAllPersons();
            if (cursor.getCount() == 0) {
                Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
                return;
            }

            StringBuilder builder = new StringBuilder();
            while (cursor.moveToNext()) {
                builder.append("ID: ").append(cursor.getInt(0)).append("\n");
                builder.append("Name: ").append(cursor.getString(1)).append("\n");
                builder.append("Age: ").append(cursor.getInt(2)).append("\n\n");
            }

            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setTitle("People");
            dlg.setMessage(builder.toString());
            dlg.setPositiveButton("OK", null);
            dlg.show();

//            if (cursor == null || cursor.getCount() == 0) {
//                Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
//                return;
//            }
//
//            CursorAdapter cursorAdapter = new PersonCursorAdapter(this, cursor, 0);
//            ListView listView = findViewById(R.id.listView);
//            listView.setAdapter(cursorAdapter);
        });



        btnUpdate.setOnClickListener(v -> {
            int id = Integer.parseInt(idInput.getText().toString());
            String name = nameInput.getText().toString();
            int age = Integer.parseInt(ageInput.getText().toString());
            dbHelper.updatePerson(id, name, age);
            Toast.makeText(this, "Updated", Toast.LENGTH_SHORT).show();
        });

        btnDelete.setOnClickListener(v -> {
            int id = Integer.parseInt(idInput.getText().toString());
            dbHelper.deletePerson(id);
            Toast.makeText(this, "Deleted", Toast.LENGTH_SHORT).show();
        });
    }
}
