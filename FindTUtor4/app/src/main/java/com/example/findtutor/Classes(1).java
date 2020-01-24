package com.project.findtutor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.strictmode.CredentialProtectedWhileLockedViolation;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;

import java.util.ArrayList;

public class Classes extends AppCompatActivity {
    Button zero, one, two, three, four, five;
    CheckBox FSC, med, ics, dcom, ICOM;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classes);
        zero = (Button) findViewById(R.id.zero);
        one = (Button) findViewById(R.id.one);
        two = (Button) findViewById(R.id.two);
        three = (Button) findViewById(R.id.three);
        four = (Button) findViewById(R.id.four);
        five = (Button) findViewById(R.id.five);
        FSC = (CheckBox) findViewById(R.id.FSC);
        med = (CheckBox) findViewById(R.id.med);
        ics = (CheckBox) findViewById(R.id.ics);
        dcom = (CheckBox) findViewById(R.id.dcom);
        ICOM = (CheckBox) findViewById(R.id.ICOM);
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Classes.this, Subjects.class);
                startActivity(intent);
            }
        });
    }
}
