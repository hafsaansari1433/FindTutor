package com.project.findtutor.RegisterLogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.project.findtutor.R;
import com.project.findtutor.Student.Register_as_student;
import com.project.findtutor.Tutor.Register_a_tutor;

public class choose extends AppCompatActivity {
    Button stud1, Tutor1;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
        stud1 = (Button) findViewById(R.id.stud1);
        Tutor1 = (Button) findViewById(R.id.Tutor1);
        stud1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(choose.this, Register_as_student.class);
                startActivity(intent);
            }
        });
        Tutor1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(choose.this, Register_a_tutor.class);
                startActivity(intent);
            }
        });
    }
}
