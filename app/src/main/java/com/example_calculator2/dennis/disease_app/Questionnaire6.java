package com.example_calculator2.dennis.disease_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example_calculator2.dennis.disease_app.model.Quest5;
import com.example_calculator2.dennis.disease_app.model.Quest6;
import com.example_calculator2.dennis.disease_app.service.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Questionnaire6 extends AppCompatActivity {

    RadioGroup radioGroup1, radioGroup2, radioGroup3, radioGroup4, radioGroup5;
    Button btn;
    String json_user_id,base_url, radioButton_string, radioButton_string2, radioButton_string3, radioButton_string4, radioButton_string5;
    TextView tx1,tx2,tx3,tx4,tx5,tx6,tx7,tx8,tx9;
    Integer in1, in2, in3, in4, in5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnaire6);

        radioGroup1 = findViewById(R.id.radiogroup61);
        radioGroup2 = findViewById(R.id.radiogroup62);
        radioGroup3 = findViewById(R.id.radiogroup63);
        radioGroup4 = findViewById(R.id.radiogroup64);
        radioGroup5 = findViewById(R.id.radiogroup65);
        tx1 = findViewById(R.id.textView654);
        tx2 = findViewById(R.id.textView655);
        tx3 = findViewById(R.id.textView656);
        tx4 = findViewById(R.id.textView657);
        tx5 = findViewById(R.id.textView658);
        tx6 = findViewById(R.id.textView659);
        tx7 = findViewById(R.id.textView660);
        tx8 = findViewById(R.id.textView661);
        tx9 = findViewById(R.id.textView662);
        btn = findViewById(R.id.btn_q6_send);
        base_url = "http://83.212.101.67:80/";
        json_user_id = getIntent().getExtras().getString("json_user_id");

        tx1.setVisibility(View.INVISIBLE);
        tx2.setVisibility(View.INVISIBLE);
        tx3.setVisibility(View.INVISIBLE);
        tx4.setVisibility(View.INVISIBLE);
        tx5.setVisibility(View.INVISIBLE);
        tx6.setVisibility(View.INVISIBLE);
        tx7.setVisibility(View.INVISIBLE);
        tx8.setVisibility(View.INVISIBLE);
        tx9.setVisibility(View.INVISIBLE);

        radioGroup5.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch(i){
                    case R.id.radioButton293:
                        radioButton_string5 = "10";
                        break;
                    case R.id.radioButton294:
                        radioButton_string5 = "9";
                        break;
                    case R.id.radioButton295:
                        radioButton_string5 = "8";
                        break;
                    case R.id.radioButton296:
                        radioButton_string5 = "7";
                        break;
                    case R.id.radioButton297:
                        radioButton_string5 = "6";
                        break;
                    case R.id.radioButton298:
                        radioButton_string5 = "5";
                        break;
                    case R.id.radioButton299:
                        radioButton_string5 = "4";
                        break;
                    case R.id.radioButton300:
                        radioButton_string5 = "3";
                        break;
                    case R.id.radioButton301:
                        radioButton_string5 = "2";
                        break;
                    case R.id.radioButton302:
                        radioButton_string5 = "1";
                        break;
                }
            }
        });

        radioGroup4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch(i){
                    case R.id.radioButton283:
                        radioButton_string4 = "10";
                        break;
                    case R.id.radioButton284:
                        radioButton_string4 = "9";
                        break;
                    case R.id.radioButton285:
                        radioButton_string4 = "8";
                        break;
                    case R.id.radioButton286:
                        radioButton_string4 = "7";
                        break;
                    case R.id.radioButton287:
                        radioButton_string4 = "6";
                        break;
                    case R.id.radioButton288:
                        radioButton_string4 = "5";
                        break;
                    case R.id.radioButton289:
                        radioButton_string4 = "4";
                        break;
                    case R.id.radioButton290:
                        radioButton_string4 = "3";
                        break;
                    case R.id.radioButton291:
                        radioButton_string4 = "2";
                        break;
                    case R.id.radioButton292:
                        radioButton_string4 = "1";
                        break;
                }
            }
        });

        radioGroup3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch(i){
                    case R.id.radioButton273:
                        radioButton_string3 = "10";
                        break;
                    case R.id.radioButton274:
                        radioButton_string3 = "9";
                        break;
                    case R.id.radioButton275:
                        radioButton_string3 = "8";
                        break;
                    case R.id.radioButton276:
                        radioButton_string3 = "7";
                        break;
                    case R.id.radioButton277:
                        radioButton_string3 = "6";
                        break;
                    case R.id.radioButton278:
                        radioButton_string3 = "5";
                        break;
                    case R.id.radioButton279:
                        radioButton_string3 = "4";
                        break;
                    case R.id.radioButton280:
                        radioButton_string3 = "3";
                        break;
                    case R.id.radioButton281:
                        radioButton_string3 = "2";
                        break;
                    case R.id.radioButton282:
                        radioButton_string3 = "1";
                        break;
                }
            }
        });

        radioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch(i){
                    case R.id.radioButton263:
                        radioButton_string2 = "10";
                        break;
                    case R.id.radioButton264:
                        radioButton_string2 = "9";
                        break;
                    case R.id.radioButton265:
                        radioButton_string2 = "8";
                        break;
                    case R.id.radioButton266:
                        radioButton_string2 = "7";
                        break;
                    case R.id.radioButton267:
                        radioButton_string2 = "6";
                        break;
                    case R.id.radioButton268:
                        radioButton_string2 = "5";
                        break;
                    case R.id.radioButton269:
                        radioButton_string2 = "4";
                        break;
                    case R.id.radioButton270:
                        radioButton_string2 = "3";
                        break;
                    case R.id.radioButton271:
                        radioButton_string2 = "2";
                        break;
                    case R.id.radioButton272:
                        radioButton_string2 = "1";
                        break;
                }
            }
        });

        radioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch(i){
                    case R.id.radioButton66:
                        radioButton_string = "10";
                        break;
                    case R.id.radioButton254:
                        radioButton_string = "9";
                        break;
                    case R.id.radioButton255:
                        radioButton_string = "8";
                        break;
                    case R.id.radioButton256:
                        radioButton_string = "7";
                        break;
                    case R.id.radioButton257:
                        radioButton_string = "6";
                        break;
                    case R.id.radioButton258:
                        radioButton_string = "5";
                        break;
                    case R.id.radioButton259:
                        radioButton_string = "4";
                        break;
                    case R.id.radioButton260:
                        radioButton_string = "3";
                        break;
                    case R.id.radioButton261:
                        radioButton_string = "2";
                        break;
                    case R.id.radioButton262:
                        radioButton_string = "1";
                        break;
                }
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(base_url)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                User service = retrofit.create(User.class);
                Quest6 quest6 = new Quest6();
                quest6.setAge(radioButton_string2);
                quest6.setHeredity_history(radioButton_string3);
                quest6.setIllnes_heredity(radioButton_string4);
                quest6.setTreatment(radioButton_string5);
                quest6.setId_2(json_user_id);
                quest6.setGender(radioButton_string);

                Call<Quest6> call = service.insertQuset6 (quest6.getGender(),
                        quest6.getAge(),
                        quest6.getHeredity_history(),
                        quest6.getIllnes_heredity(),
                        quest6.getTreatment(),
                        quest6.getId_2()
                );

                call.enqueue(new Callback<Quest6>() {
                    @Override
                    public void onResponse(Call<Quest6> call, Response<Quest6> response) {

                    }

                    @Override
                    public void onFailure(Call<Quest6> call, Throwable t) {
                        Log.d("onFailure", t.toString());
                        in1 = Integer.parseInt(radioButton_string2);
                        in2 = Integer.parseInt(radioButton_string3);
                        in3 = Integer.parseInt(radioButton_string4);
                        in4 = Integer.parseInt(radioButton_string5);
                        in5 = Integer.parseInt(radioButton_string);
                        Integer sum = in1 + in2 + in3 + in4 + in5;
                        if (sum >= 0 && sum <= 20) {
                            tx1.setVisibility(View.VISIBLE);
                            tx2.setVisibility(View.VISIBLE);
                            tx3.setVisibility(View.VISIBLE);
                        }else if(sum >= 21 && sum <= 40){
                            tx4.setVisibility(View.VISIBLE);
                            tx5.setVisibility(View.VISIBLE);
                            tx6.setVisibility(View.VISIBLE);
                        }else if (sum >= 41){
                            tx7.setVisibility(View.VISIBLE);
                            tx8.setVisibility(View.VISIBLE);
                            tx9.setVisibility(View.VISIBLE);
                        }
                    }
                });
            }
        });
    }
}
