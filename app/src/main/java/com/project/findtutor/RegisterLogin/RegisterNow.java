package com.project.findtutor.RegisterLogin;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.project.findtutor.Models.StudentModel;
import com.project.findtutor.Models.TutorModel;
import com.project.findtutor.ProjectDatabase;
import com.project.findtutor.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterNow extends AppCompatActivity {
    EditText name, username, email, password;
    Button register;
    String strName, strUserName, strEmail, strPassword;
    ProjectDatabase projectDatabase;
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    Boolean isStudent;
    private AwesomeValidation awesomeValidation;

    public boolean isValidPassword(final String password) {

        Pattern pattern;
        Matcher matcher;

        final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{4,}$";

        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);

        return matcher.matches();

    }

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_now);
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        name = (EditText) findViewById(R.id.name);
        username = (EditText) findViewById(R.id.username);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        register = (Button) findViewById(R.id.register);

        awesomeValidation.addValidation(this, R.id.name, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
        awesomeValidation.addValidation(this, R.id.username, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.usernameerror);
        awesomeValidation.addValidation(this, R.id.email, Patterns.EMAIL_ADDRESS, R.string.emailerror);

//        String regexPassword = "(?=.*[a-z])(?=.*[A-Z])(?=.*[\\d])(?=.*[~`!@#\\$%\\^&\\*\\(\\)\\-_\\+=\\{\\}\\[\\]\\|\\;:\"<>,./\\?]).{8,}";
//        String regexPassword = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\\\S+$).{4,}$";
        awesomeValidation.addValidation(this, R.id.password, "(?=.*[a-z])(?=.*[A-Z])(?=.*[\\d])(?=.*[~`!@#\\$%\\^&\\*\\(\\)\\-_\\+=\\{\\}\\[\\]\\|\\;:\"<>,./\\?]).{8,}", R.string.passworderror);

//        awesomeValidation.addValidation(this, R.id.password, regexPassword, R.string.passworderror);

       /* if (isValidPassword(password.getText().toString().trim())) {
            Toast.makeText(this, "Valid", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "InVa


            lid Password", Toast.LENGTH_SHORT).show();
        }*/
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (awesomeValidation.validate()) {
                        int selectedId = radioGroup.getCheckedRadioButtonId();
                        radioButton = (RadioButton) findViewById(selectedId);
                        projectDatabase = new ProjectDatabase(RegisterNow.this);
                        strName = name.getText().toString();
                        strUserName = username.getText().toString();
                        strEmail = email.getText().toString();
                        strPassword = password.getText().toString();
                        Log.e("Username", strUserName);
                        Log.e("password", strPassword);
                        if (radioButton.getText().equals("As Student")) {
                            if (!strName.matches("") && !strUserName.matches("") && !strPassword.matches("") && !strEmail.matches("")) {
                                long val = projectDatabase.RegisterStudentUser(strName, strUserName, strEmail, strPassword);
                                if (val > 0) {
                                    Intent intent = new Intent(RegisterNow.this, MainActivity.class);
                                    startActivity(intent);
                                    Toast.makeText(RegisterNow.this, "Registered As Student", Toast.LENGTH_SHORT).show();

                                } else {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(RegisterNow.this);
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
                                Toast.makeText(RegisterNow.this, "Enter Values", Toast.LENGTH_SHORT).show();
                            }
                        } else if (radioButton.getText().equals("As Tutor")) {
                            if (!strName.matches("") && !strUserName.matches("") && !strPassword.matches("") && !strEmail.matches("")) {
                                isStudent = false;
                                long val = projectDatabase.RegisterTutor(strName, strUserName, strEmail, strPassword,
                                        null, null, null, null, null, null, null, null);
                                if (val > 0) {
                                    Intent intent = new Intent(RegisterNow.this, MainActivity.class);
                                    startActivity(intent);
                                    Toast.makeText(RegisterNow.this, "Registered As Tutor", Toast.LENGTH_SHORT).show();

                                } else {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(RegisterNow.this);
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
                                Toast.makeText(RegisterNow.this, "Enter Values", Toast.LENGTH_SHORT).show();
                            }
                        } else
                            Toast.makeText(RegisterNow.this, "Something Went Wrong", Toast.LENGTH_SHORT).show();

                    }
                } catch (Exception e) {
                    Log.e("Register Exception", e.getMessage());
                    AlertDialog.Builder builder = new AlertDialog.Builder(RegisterNow.this);
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
