package com.smu.fullapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class StudentActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        String selectedSection = getIntent().getStringExtra("SELECTED_SECTION");
        TextView sectionTitle = findViewById(R.id.sectionTitle);
        sectionTitle.setText("Students in " + selectedSection);

        ListView studentListView = findViewById(R.id.studentListView);
        ArrayList<Student> students = getStudentsForSection(selectedSection);
        ArrayAdapter<Student> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, students) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView text = (TextView) view.findViewById(android.R.id.text1);
                text.setText(getItem(position).getName());
                return view;
            }
        };
        studentListView.setAdapter(adapter);

        studentListView.setOnItemClickListener((parent, view, position, id) -> {
            Student selectedStudent = students.get(position);
            Intent intent = new Intent(StudentActivity.this, StudentDetailActivity.class);
            intent.putExtra("STUDENT", selectedStudent);
            startActivity(intent);
        });
    }

    private ArrayList<Student> getStudentsForSection(String section) {
        ArrayList<Student> students = new ArrayList<>();
        switch (section) {
            case "Section B":
                students.add(new Student("Kids", 3.5, "Loves programming"));
                students.add(new Student("Semir", 3.7, "Aspiring data scientist"));
                students.add(new Student("Afomia", 3.6, "Interested in mobile development"));
                students.add(new Student("Fanuel", 3.4, "Enjoys database management"));
                students.add(new Student("Meron", 3.8, "Passionate about AI"));
                students.add(new Student("Fikreyonanes", 3.3, "Focused on web development"));
                students.add(new Student("abdulahi", 3.6, "Enthusiastic about cybersecurity"));
                students.add(new Student("arsema", 3.9, "Loves machine learning"));
                students.add(new Student("daniel", 3.2, "Interested in game development"));
                students.add(new Student("huda", 3.7, "Passionate about UI/UX design"));
                students.add(new Student("brook", 3.5, "Focused on cloud computing"));
                students.add(new Student("dagmawi", 3.4, "Enjoys software testing"));
                break;
            case "Section C":
                students.add(new Student("Meron", 3.8, "Passionate about AI"));
                students.add(new Student("Abel", 3.6, "Interested in cybersecurity"));
                students.add(new Student("Kidus", 3.5, "Loves programming"));
                students.add(new Student("Wubtsega", 3.7, "Focused on data analysis"));
                students.add(new Student("gelila", 3.4, "Enthusiastic about mobile app development"));
                students.add(new Student("amanuel", 3.9, "Interested in blockchain technology"));
                students.add(new Student("hayat", 3.3, "Enjoys front-end development"));
                students.add(new Student("naol", 3.6, "Passionate about IoT"));
                students.add(new Student("yonas", 3.5, "Focused on backend development"));
                students.add(new Student("nebiyu", 3.7, "Interested in AR/VR technologies"));
                students.add(new Student("natnael", 3.8, "Loves working with APIs"));
                break;
            case "Section D":
                students.add(new Student("Fraol", 3.6, "Interested in data visualization"));
                students.add(new Student("kalab", 3.4, "Passionate about network security"));
                students.add(new Student("melat", 3.8, "Loves working on AI projects"));
                students.add(new Student("noel", 3.5, "Focused on cloud architecture"));
                students.add(new Student("Adonay", 3.7, "Enthusiastic about DevOps"));
                students.add(new Student("Abel", 3.6, "Interested in cybersecurity"));
                students.add(new Student("helina", 3.9, "Passionate about machine learning"));
                students.add(new Student("dawit", 3.3, "Enjoys working with databases"));
                students.add(new Student("Yonatan", 3.5, "Focused on mobile app development"));
                students.add(new Student("tuba", 3.7, "Interested in web accessibility"));
                break;
            case "Section E":
                students.add(new Student("Abdulaziz", 3.5, "Passionate about big data"));
                students.add(new Student("Hikma", 3.8, "Interested in quantum computing"));
                students.add(new Student("Nahom", 3.6, "Loves working on robotics"));
                students.add(new Student("tsedniya", 3.7, "Focused on natural language processing"));
                students.add(new Student("abdulkrim", 3.4, "Enthusiastic about computer vision"));
                students.add(new Student("girum", 3.9, "Interested in embedded systems"));
                students.add(new Student("kalid", 3.5, "Passionate about game development"));
                students.add(new Student("eyrusalem", 3.6, "Enjoys working on UI/UX design"));
                break;
            default:
                students.add(new Student("Unknown Section", 0.0, "No students found for this section"));
                break;
        }
        return students;
    }
}