package com.project.findtutor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class AlreadyRegistered extends AppCompatActivity {
EditText un5,password;
Button fp,LN2;
CheckBox RME;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_already_registered);
        un5 = (EditText) findViewById(R.id.un5);
        password = (EditText) findViewById(R.id.password);
        RME = (CheckBox) findViewById(R.id.RME);
        fp = (Button) findViewById(R.id.fp);
        LN2 = (Button) findViewById(R.id.LN2);
        fp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(AlreadyRegistered.this,recovernow.class);
                startActivity(intent);

            }
        });
        LN2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(AlreadyRegistered.this,choose.class);
                startActivity(intent);
            }
        });


    }


}
