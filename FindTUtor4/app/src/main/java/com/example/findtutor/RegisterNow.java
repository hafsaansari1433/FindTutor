package com.project.findtutor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterNow extends AppCompatActivity {
EditText Blank,Blank2,Blank3,sp2,cp2;
Button LN3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_now);
        Blank=(EditText)findViewById(R.id.Blank);
        Blank2=(EditText)findViewById(R.id.Blank2);
        Blank3=(EditText)findViewById(R.id.Blank3);
        sp2=(EditText)findViewById(R.id.sp2);
        cp2=(EditText)findViewById(R.id.cp2);
        LN3=(Button)findViewById(R.id.LN3);
        LN3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(RegisterNow.this,choose.class);
                startActivity(intent);
            }
        });

    }
}
