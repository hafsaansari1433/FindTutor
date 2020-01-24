package com.project.findtutor.Admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.project.findtutor.R;

public class AdminDashboard extends AppCompatActivity {
    Button student,tutor,subject,classes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);
        student = findViewById(R.id.student);
        tutor = findViewById(R.id.tutor);
        subject = findViewById(R.id.subject);
        classes = findViewById(R.id.classes);

        student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminDashboard.this, StudentList.class);
                startActivity(intent);

            }
        });
        tutor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminDashboard.this, StudentList.class);
                startActivity(intent);

            }
        });


    }
}
