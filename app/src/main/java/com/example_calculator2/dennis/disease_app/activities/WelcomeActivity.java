package com.example_calculator2.dennis.disease_app.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example_calculator2.dennis.disease_app.R;

import java.util.Objects;

public class WelcomeActivity extends AppCompatActivity {

    Button button_disease, button_symptom, button_questionnaire, button_logout, button_profile, button_admin, buttonHistory;
    String json_user_id, json_user_email,json_user_password;
    public static final String MY_PREFS_NAME = "MyPrefsFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        json_user_id = getIntent().getExtras().getString("json_user_id");
        json_user_email = getIntent().getExtras().getString("json_user_email");
        json_user_password = getIntent().getExtras().getString("json_user_password");

        SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
        editor.putString("user_id_sp", json_user_id);
        editor.apply();

        button_disease = findViewById(R.id.w_disease);
        button_symptom = findViewById(R.id.w_symptom);
        button_questionnaire = findViewById(R.id.w_questionnaire);
        button_logout = findViewById(R.id.w_logout);
        button_profile = findViewById(R.id.button);
        button_admin = findViewById(R.id.button4);
        buttonHistory = findViewById(R.id.button7);

        button_admin.setVisibility(View.INVISIBLE);

        if (Objects.equals(json_user_email.trim(), "dionisis@gmail.com") && Objects.equals(json_user_password, "dennis")){
            button_admin.setVisibility(View.VISIBLE);
        }

        button_disease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WelcomeActivity.this, DiseaseActivity.class);
                intent.putExtra("json_user_id", json_user_id);
                intent.putExtra("json_user_email", json_user_email);
                intent.putExtra("json_user_password", json_user_password);
                startActivity(intent);
                WelcomeActivity.this.finish();
            }
        });

        buttonHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WelcomeActivity.this, HistoryActivity.class);
                intent.putExtra("json_user_id", json_user_id);
                intent.putExtra("json_user_email", json_user_email);
                intent.putExtra("json_user_password", json_user_password);
                startActivity(intent);
                WelcomeActivity.this.finish();
            }
        });

        button_symptom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WelcomeActivity.this, SymptomActivity.class);
                intent.putExtra("json_user_id", json_user_id);
                intent.putExtra("json_user_email", json_user_email);
                intent.putExtra("json_user_password", json_user_password);
                startActivity(intent);
                WelcomeActivity.this.finish();
            }
        });

        button_questionnaire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WelcomeActivity.this, FindQuestionnaireActivity.class);
                intent.putExtra("json_user_id", json_user_id);
                intent.putExtra("json_user_email", json_user_email);
                intent.putExtra("json_user_password", json_user_password);
                startActivity(intent);
                WelcomeActivity.this.finish();
            }
        });

        button_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WelcomeActivity.this, DashboardActivity.class);
                startActivity(intent);
                WelcomeActivity.this.finish();
            }
        });

        button_admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WelcomeActivity.this, AdminActivity.class);
                intent.putExtra("json_user_id", json_user_id);
                intent.putExtra("json_user_email", json_user_email);
                intent.putExtra("json_user_password", json_user_password);
                startActivity(intent);
                WelcomeActivity.this.finish();
            }
        });

        button_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WelcomeActivity.this, ProfileActivity.class);
                intent.putExtra("json_user_id", json_user_id);
                intent.putExtra("json_user_email", json_user_email);
                intent.putExtra("json_user_password", json_user_password);
                startActivity(intent);
                WelcomeActivity.this.finish();
            }
        });
    }
}
