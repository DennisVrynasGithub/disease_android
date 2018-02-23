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

import com.example_calculator2.dennis.disease_app.model.Quest3;
import com.example_calculator2.dennis.disease_app.model.Quest4;
import com.example_calculator2.dennis.disease_app.service.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Questionnaire4 extends AppCompatActivity {

    RadioGroup radioGroup1, radioGroup2, radioGroup3, radioGroup4, radioGroup5, radioGroup6;
    Button btn;
    String json_user_id,base_url, radioButton_string,radioButton_string2, radioButton_string3, radioButton_string4, radioButton_string5,  radioButton_string6;
    TextView tx1,tx2,tx3,tx4,tx5,tx6,tx7,tx8,tx9;
    Integer in1, in2, in3, in4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnaire4);

        radioGroup1 = findViewById(R.id.radiogroup41);
        radioGroup2 = findViewById(R.id.radiogroup42);
        radioGroup3 = findViewById(R.id.radiogroup43);
        radioGroup4 = findViewById(R.id.radiogroup44);
        radioGroup5 = findViewById(R.id.radiogroupr45);
        radioGroup6 = findViewById(R.id.radiogroup46);
        tx1 = findViewById(R.id.textView454);
        tx2 = findViewById(R.id.textView455);
        tx3 = findViewById(R.id.textView456);
        tx4 = findViewById(R.id.textView457);
        tx5 = findViewById(R.id.textView458);
        tx6 = findViewById(R.id.textView459);
        tx7 = findViewById(R.id.textView460);
        tx8 = findViewById(R.id.textView461);
        tx9 = findViewById(R.id.textView462);
        btn = findViewById(R.id.btn_q4_send);
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

        radioGroup6.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch(i){
                    case R.id.radioButton195:
                        radioButton_string6 = "10";
                        break;
                    case R.id.radioButton196:
                        radioButton_string6 = "9";
                        break;
                    case R.id.radioButton197:
                        radioButton_string6 = "8";
                        break;
                    case R.id.radioButton198:
                        radioButton_string6 = "7";
                        break;
                    case R.id.radioButton199:
                        radioButton_string6 = "6";
                        break;
                    case R.id.radioButton200:
                        radioButton_string6 = "5";
                        break;
                    case R.id.radioButton201:
                        radioButton_string6 = "4";
                        break;
                    case R.id.radioButton203:
                        radioButton_string6 = "3";
                        break;
                    case R.id.radioButton204:
                        radioButton_string6 = "2";
                        break;
                    case R.id.radioButton205:
                        radioButton_string6 = "1";
                        break;
                }
            }
        });

        radioGroup5.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch(i){
                    case R.id.radioButton185:
                        radioButton_string5 = "10";
                        break;
                    case R.id.radioButton186:
                        radioButton_string5 = "9";
                        break;
                    case R.id.radioButton187:
                        radioButton_string5 = "8";
                        break;
                    case R.id.radioButton188:
                        radioButton_string5 = "7";
                        break;
                    case R.id.radioButton189:
                        radioButton_string5 = "6";
                        break;
                    case R.id.radioButton190:
                        radioButton_string5 = "5";
                        break;
                    case R.id.radioButton191:
                        radioButton_string5 = "4";
                        break;
                    case R.id.radioButton193:
                        radioButton_string5 = "3";
                        break;
                    case R.id.radioButton194:
                        radioButton_string5 = "2";
                        break;
                    case R.id.radioButton195:
                        radioButton_string5 = "1";
                        break;
                }
            }
        });

        radioGroup4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch(i){
                    case R.id.radioButton175:
                        radioButton_string4 = "10";
                        break;
                    case R.id.radioButton176:
                        radioButton_string4 = "9";
                        break;
                    case R.id.radioButton177:
                        radioButton_string4 = "8";
                        break;
                    case R.id.radioButton178:
                        radioButton_string4 = "7";
                        break;
                    case R.id.radioButton179:
                        radioButton_string4 = "6";
                        break;
                    case R.id.radioButton180:
                        radioButton_string4 = "5";
                        break;
                    case R.id.radioButton181:
                        radioButton_string4 = "4";
                        break;
                    case R.id.radioButton183:
                        radioButton_string4 = "3";
                        break;
                    case R.id.radioButton184:
                        radioButton_string4 = "2";
                        break;
                    case R.id.radioButton185:
                        radioButton_string4 = "1";
                        break;
                }
            }
        });

        radioGroup3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch(i){
                    case R.id.radioButton165:
                        radioButton_string3 = "10";
                        break;
                    case R.id.radioButton166:
                        radioButton_string3 = "9";
                        break;
                    case R.id.radioButton167:
                        radioButton_string3 = "8";
                        break;
                    case R.id.radioButton168:
                        radioButton_string3 = "7";
                        break;
                    case R.id.radioButton169:
                        radioButton_string3 = "6";
                        break;
                    case R.id.radioButton170:
                        radioButton_string3 = "5";
                        break;
                    case R.id.radioButton171:
                        radioButton_string3 = "4";
                        break;
                    case R.id.radioButton173:
                        radioButton_string3 = "3";
                        break;
                    case R.id.radioButton174:
                        radioButton_string3 = "2";
                        break;
                    case R.id.radioButton175:
                        radioButton_string3 = "1";
                        break;
                }
            }
        });

        radioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch(i){
                    case R.id.radioButton158:
                        radioButton_string2 = "70-80";
                        break;
                    case R.id.radioButton159:
                        radioButton_string2 = "60-70";
                        break;
                    case R.id.radioButton160:
                        radioButton_string2 = "50-60";
                        break;
                    case R.id.radioButton161:
                        radioButton_string2 = "40-50";
                        break;
                    case R.id.radioButton163:
                        radioButton_string2 = "30-40";
                        break;
                    case R.id.radioButton164:
                        radioButton_string2 = "20-30";
                        break;
                    case R.id.radioButton165:
                        radioButton_string2 = "10-20";
                        break;
                }
            }
        });

        radioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch(i){
                    case R.id.radioButton158:
                        radioButton_string = "5";
                        break;
                    case R.id.radioButton157:
                        radioButton_string = "4";
                        break;
                    case R.id.radioButton156:
                        radioButton_string = "3";
                        break;
                    case R.id.radioButton155:
                        radioButton_string = "2";
                        break;
                    case R.id.radioButton154:
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
                Quest4 quest4 = new Quest4();
                quest4.setAge(radioButton_string2);
                quest4.setIllnes(radioButton_string3);
                quest4.setCaused_other(radioButton_string4);
                quest4.setTime(radioButton_string6);
                quest4.setTreatment(radioButton_string5);
                quest4.setId_2(json_user_id);
                quest4.setGender(radioButton_string);

                Call<Quest4> call = service.insertQuset4(quest4.getGender(),
                        quest4.getAge(),
                        quest4.getIllnes(),
                        quest4.getCaused_other(),
                        quest4.getTreatment(),
                        quest4.getTime(),
                        quest4.getId_2()
                );

                call.enqueue(new Callback<Quest4>() {
                    @Override
                    public void onResponse(Call<Quest4> call, Response<Quest4> response) {

                    }

                    @Override
                    public void onFailure(Call<Quest4> call, Throwable t) {
                        Log.d("onFailure", t.toString());
                        in1 = Integer.parseInt(radioButton_string6);
                        in2 = Integer.parseInt(radioButton_string3);
                        in3 = Integer.parseInt(radioButton_string4);
                        in4 = Integer.parseInt(radioButton_string5);
                        Integer sum = in1 + in2 + in3 + in4;
                        if (sum >= 0 && sum <= 15) {
                            tx1.setVisibility(View.VISIBLE);
                            tx2.setVisibility(View.VISIBLE);
                            tx3.setVisibility(View.VISIBLE);
                            tx4.setVisibility(View.INVISIBLE);
                            tx5.setVisibility(View.INVISIBLE);
                            tx6.setVisibility(View.INVISIBLE);
                            tx7.setVisibility(View.INVISIBLE);
                            tx8.setVisibility(View.INVISIBLE);
                            tx9.setVisibility(View.INVISIBLE);
                        }else if(sum >= 16 && sum <= 30){
                            tx1.setVisibility(View.INVISIBLE);
                            tx2.setVisibility(View.INVISIBLE);
                            tx3.setVisibility(View.INVISIBLE);
                            tx4.setVisibility(View.VISIBLE);
                            tx5.setVisibility(View.VISIBLE);
                            tx6.setVisibility(View.VISIBLE);
                            tx7.setVisibility(View.INVISIBLE);
                            tx8.setVisibility(View.INVISIBLE);
                            tx9.setVisibility(View.INVISIBLE);
                        }else if (sum >= 31){
                            tx1.setVisibility(View.INVISIBLE);
                            tx2.setVisibility(View.INVISIBLE);
                            tx3.setVisibility(View.INVISIBLE);
                            tx4.setVisibility(View.INVISIBLE);
                            tx5.setVisibility(View.INVISIBLE);
                            tx6.setVisibility(View.INVISIBLE);
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
