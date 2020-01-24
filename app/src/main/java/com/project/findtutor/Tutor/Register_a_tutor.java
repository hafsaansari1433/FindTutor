package com.project.findtutor.Tutor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.project.findtutor.R;

public class Register_a_tutor extends AppCompatActivity {
    Button update1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_a_tutor);
        update1=(Button)findViewById(R.id.update1);
        update1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Register_a_tutor.this, "Updated", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
