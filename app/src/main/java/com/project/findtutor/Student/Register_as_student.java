package com.project.findtutor.Student;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.project.findtutor.Constants;
import com.project.findtutor.Models.StudentModel;
import com.project.findtutor.ProjectDatabase;
import com.project.findtutor.R;
import com.project.findtutor.RegisterLogin.MainActivity;

public class Register_as_student extends AppCompatActivity {
    EditText name, fathername, phoneno, address, stdclass, subject;
    Button next;
    String strName, strFathername, strPhoneno, strAddress, strStdclass, strSubject;
    ProjectDatabase projectDatabase;
    private AwesomeValidation awesomeValidation;
    String getUsername;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_as_student);
        getUsername = getIntent().getStringExtra(Constants.std_col_username);

        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        name = (EditText) findViewById(R.id.name);
        fathername = (EditText) findViewById(R.id.fathername);
        phoneno = (EditText) findViewById(R.id.phoneno);
        address = (EditText) findViewById(R.id.address);
        stdclass = (EditText) findViewById(R.id.stdclass);
        subject = (EditText) findViewById(R.id.subject);

        next = (Button) findViewById(R.id.next);
        awesomeValidation.addValidation(this, R.id.name, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
        awesomeValidation.addValidation(this, R.id.fathername, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.fathernameerror);
        awesomeValidation.addValidation(this, R.id.address, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.addresserror);
        awesomeValidation.addValidation(this, R.id.stdclass, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.stdclasserror);
        awesomeValidation.addValidation(this, R.id.subject, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.subjecterror);


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (awesomeValidation.validate()) {
                        projectDatabase = new ProjectDatabase(Register_as_student.this);
                        strName = name.getText().toString();
                        strFathername = fathername.getText().toString();
                        strPhoneno = phoneno.getText().toString();
                        strAddress = address.getText().toString();
                        strStdclass = stdclass.getText().toString();
                        strSubject = subject.getText().toString();

                        if (!strName.matches("") && !strFathername.matches("") && !strPhoneno.matches("") && !strAddress.matches("") && !strStdclass.matches("") && !strSubject.matches("")) {
                            long val = projectDatabase.UpdateStudent(getUsername, strName, strFathername, strPhoneno, strAddress, strStdclass, strSubject);
                            if (val > 0) {
                                Intent intent = new Intent(Register_as_student.this, Classes.class);
                                startActivity(intent);
                                Toast.makeText(Register_as_student.this, "Registered", Toast.LENGTH_SHORT).show();

                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(Register_as_student.this);
                                builder.setTitle("Error");
                                builder.setMessage("Registration Error");
                                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.cancel();
                                    }
                                });
                                builder.show();
                            }
                        } else {
                            Toast.makeText(Register_as_student.this, "Enter Values", Toast.LENGTH_SHORT).show();
                        }
                    }
                } catch (Exception e) {
                    Log.e("Register Exception", e.getMessage());
                    AlertDialog.Builder builder = new AlertDialog.Builder(Register_as_student.this);
                    builder.setTitle("Error");
                    builder.setMessage(e.getMessage());
                    builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
                    builder.show();
                }
            }
        });
    }
}


