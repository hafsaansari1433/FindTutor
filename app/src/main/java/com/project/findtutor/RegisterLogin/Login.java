package com.project.findtutor.RegisterLogin;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.project.findtutor.Admin.AdminDashboard;
import com.project.findtutor.Constants;
import com.project.findtutor.ProjectDatabase;
import com.project.findtutor.R;
import com.project.findtutor.Student.Register_as_student;
import com.project.findtutor.Tutor.Register_a_tutor;

public class Login extends AppCompatActivity {
    EditText username, password;
    Button fp, login;
    CheckBox RME;
    String strUsername, strPassword;
    ProjectDatabase projectDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    projectDatabase = new ProjectDatabase(Login.this);
                    strUsername = username.getText().toString();
                    strPassword = password.getText().toString();
                    Log.e("Data", strUsername + " -- " + strPassword);
                    boolean stdRes = projectDatabase.checkStudent(strUsername, strPassword);
                    Log.e("Std Result", String.valueOf(stdRes));

                    if (!strUsername.matches("") && !strPassword.matches(""))
                        if (strUsername.contains("admin") && strPassword.equals("123")) {
                            startActivity(new Intent(Login.this, AdminDashboard.class));
                        } else if (stdRes) {
                            Toast.makeText(Login.this, "Successfully Login", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(Login.this, Register_as_student.class);
                            intent.putExtra(Constants.std_col_username, strUsername);
                            startActivity(intent);
                        } else {
                            boolean tutRes = projectDatabase.checkTutor(strUsername, strPassword);
                            Log.e(" Tutu Result", String.valueOf(tutRes));

                            if (tutRes) {
                                Toast.makeText(Login.this, "Successfully Login", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(Login.this, Register_a_tutor.class);
                                intent.putExtra("username", strUsername);
                                startActivity(intent);
                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(Login.this);
                                builder.setTitle("Error");
                                builder.setMessage("Login Error");
                                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.cancel();
                                    }
                                });
                            }

                        }
                    else {
                        Toast.makeText(Login.this, "Enter Values", Toast.LENGTH_SHORT).show();
                    }

                } catch (Exception e) {
                    Log.e("Login Exception", e.getMessage());
                    AlertDialog.Builder builder = new AlertDialog.Builder(Login.this);
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
