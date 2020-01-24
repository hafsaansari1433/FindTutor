
package com.project.findtutor.RegisterLogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import com.project.findtutor.R;
import com.project.findtutor.RegisterLogin.RegisterNow;

public class MainActivity extends AppCompatActivity {
    Button AR, RN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AR = (Button) findViewById(R.id.AR);
        RN = (Button) findViewById(R.id.RN);
        AR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Login.class);
                startActivity(intent);
            }
        });
        RN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RegisterNow.class);
                startActivity(intent);
            }
        });

    }
}
