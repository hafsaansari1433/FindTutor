package com.project.findtutor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import javax.security.auth.Subject;

public class Register_as_student extends AppCompatActivity {
  TextView studname1,Fstudname1,Email3,phoneno9,Add1;
  EditText studname2,Fstudname2,NO_Email,Phone10,add9;
  Button sel;
  @Override
    protected void onCreate(final Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_register_as_student);
      studname1 = (TextView) findViewById(R.id.studname1);
      Fstudname1 = (TextView) findViewById(R.id.Fstudname1);
      Email3 = (TextView) findViewById(R.id.Email3);
      phoneno9 = (TextView) findViewById(R.id.phoneno9);
      Add1 = (TextView) findViewById(R.id.Add1);
      studname2 = (EditText) findViewById(R.id.studname2);
      Fstudname2 = (EditText) findViewById(R.id.Fstudname2);
      NO_Email = (EditText) findViewById(R.id.NO_Email);
      Phone10 = (EditText) findViewById(R.id.Phone10);
      add9 = (EditText) findViewById(R.id.add9);
      sel = (Button) findViewById(R.id.sel);
      sel.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent intent = new Intent(Register_as_student.this, MainPage.class);
              startActivity(intent);
          }
      });

  }
}