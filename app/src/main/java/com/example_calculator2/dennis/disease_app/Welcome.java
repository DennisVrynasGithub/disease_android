package com.example_calculator2.dennis.disease_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Welcome extends AppCompatActivity {

    Button btn1, btn2, btn3, btn4, btn5;
    String json_user_id, json_user_email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        json_user_id = getIntent().getExtras().getString("json_user_id");
        json_user_email = getIntent().getExtras().getString("json_user_email");

        btn1 = findViewById(R.id.w_disease);
        btn2 = findViewById(R.id.w_symptom);
        btn3 = findViewById(R.id.w_questionnaire);
        btn4 = findViewById(R.id.w_logout);
        btn5 = findViewById(R.id.button);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Welcome.this, Disease.class);
                intent.putExtra("json_user_id", json_user_id);
                startActivity(intent);
                Welcome.this.finish();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Welcome.this, Symptom.class);
                intent.putExtra("json_user_id", json_user_id);
                startActivity(intent);
                Welcome.this.finish();
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Welcome.this, FindQuestionnaire.class);
                intent.putExtra("json_user_id", json_user_id);
                startActivity(intent);
                Welcome.this.finish();
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Welcome.this, Dashboard.class);
                startActivity(intent);
                Welcome.this.finish();
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Welcome.this, Profile.class);
                intent.putExtra("json_user_id", json_user_id);
                intent.putExtra("json_user_email", json_user_email);
                startActivity(intent);
                Welcome.this.finish();
            }
        });
    }
}
