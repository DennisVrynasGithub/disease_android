package com.example_calculator2.dennis.disease_app.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.example_calculator2.dennis.disease_app.R;

public class DashboardActivity extends AppCompatActivity {

    protected Button button_dashboard_login, button_dashboard_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_dashboard);

        button_dashboard_login = findViewById(R.id.btn_dashboard_login);
        button_dashboard_register = findViewById(R.id.btn_register);

        button_dashboard_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DashboardActivity.this, LoginActivity.class);
                startActivity(intent);
                DashboardActivity.this.finish();
            }
        });

        button_dashboard_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DashboardActivity.this, RegisterActivity.class);
                startActivity(intent);
                DashboardActivity.this.finish();
            }
        });
    }
}
