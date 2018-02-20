package com.example_calculator2.dennis.disease_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class Dashboard extends AppCompatActivity {

    protected TextView tx1, tx2;
    protected Button btn1, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_dashboard);

        tx1 = findViewById(R.id.textView1);
        tx2 = findViewById(R.id.textView2);
        btn1 = findViewById(R.id.btn_login);
        btn2 = findViewById(R.id.btn_register);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this, Login.class);
                startActivity(intent);
                Dashboard.this.finish();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this, Register.class);
                startActivity(intent);
                Dashboard.this.finish();
            }
        });
    }
}
