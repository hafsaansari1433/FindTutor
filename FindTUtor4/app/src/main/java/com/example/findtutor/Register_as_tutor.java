package com.project.findtutor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Register_as_tutor extends AppCompatActivity {
    TextView avail2,set2;
    EditText set3;
    CheckBox am,pm;
    Spinner module;
    Button CV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_as_tutor);
        avail2=(TextView)findViewById(R.id.avail2);
        set2=(TextView)findViewById(R.id.set2);
        set3=(EditText)findViewById(R.id.set3);
        am=(CheckBox)findViewById(R.id.am);
        pm=(CheckBox)findViewById(R.id.pm);
        module=(Spinner)findViewById(R.id.module);
        CV=(Button)findViewById(R.id.CV);
    }
}
