package com.example_calculator2.dennis.disease_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FindQuestionnaire extends AppCompatActivity {

    Button btn1, btn2, btn3, btn4, btn5, btn6, btn;
    String json_user_id, json_user_email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_questionnaire);

        json_user_id = getIntent().getExtras().getString("json_user_id");
        json_user_email = getIntent().getExtras().getString("json_user_email");

        btn1 = findViewById(R.id.btn_q1);
        btn2 = findViewById(R.id.btn_q2);
        btn3 = findViewById(R.id.btn_q3);
        btn4 = findViewById(R.id.btn_q4);
        btn5 = findViewById(R.id.btn_q5);
        btn6 = findViewById(R.id.btn_q6);
        btn = findViewById(R.id.btn_quest_back);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FindQuestionnaire.this, Questionnaire1.class);
                intent.putExtra("json_user_id", json_user_id);
                startActivity(intent);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FindQuestionnaire.this, Questionnaire2.class);
                intent.putExtra("json_user_id", json_user_id);
                startActivity(intent);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FindQuestionnaire.this, Questionnaire3.class);
                intent.putExtra("json_user_id", json_user_id);
                startActivity(intent);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FindQuestionnaire.this, Questionnaire4.class);
                intent.putExtra("json_user_id", json_user_id);
                startActivity(intent);
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FindQuestionnaire.this, Questionnaire5.class);
                intent.putExtra("json_user_id", json_user_id);
                startActivity(intent);
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FindQuestionnaire.this, Questionnaire6.class);
                intent.putExtra("json_user_id", json_user_id);
                startActivity(intent);
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FindQuestionnaire.this, Welcome.class);
                intent.putExtra("json_user_id", json_user_id);
                intent.putExtra("json_user_email", json_user_email);
                startActivity(intent);
                FindQuestionnaire.this.finish();

            }
        });
    }
}
