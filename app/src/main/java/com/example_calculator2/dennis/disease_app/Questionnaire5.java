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

import com.example_calculator2.dennis.disease_app.model.Quest4;
import com.example_calculator2.dennis.disease_app.model.Quest5;
import com.example_calculator2.dennis.disease_app.service.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Questionnaire5 extends AppCompatActivity {

    RadioGroup radioGroup1, radioGroup2, radioGroup3, radioGroup4, radioGroup5, radioGroup6;
    EditText et1, et2, et3, et4, et5, et6;
    Button btn;
    String json_user_id,base_url, radioButton_string, radioButton_string2,radioButton_string3, radioButton_string4, radioButton_string5, radioButton_string6;
    TextView tx1,tx2,tx3,tx4,tx5,tx6,tx7,tx8,tx9;
    Integer in1, in2, in3, in4, in5, in6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnaire5);

        radioGroup1 = findViewById(R.id.radiogroup51);
        radioGroup2 = findViewById(R.id.radiogroup52);
        radioGroup3 = findViewById(R.id.radiogroup53);
        radioGroup4 = findViewById(R.id.radiogroup54);
        radioGroup5 = findViewById(R.id.radiogroup55);
        radioGroup6 = findViewById(R.id.radiogroup56);
        tx1 = findViewById(R.id.textView554);
        tx2 = findViewById(R.id.textView555);
        tx3 = findViewById(R.id.textView556);
        tx4 = findViewById(R.id.textView557);
        tx5 = findViewById(R.id.textView558);
        tx6 = findViewById(R.id.textView559);
        tx7 = findViewById(R.id.textView560);
        tx8 = findViewById(R.id.textView561);
        tx9 = findViewById(R.id.textView562);
        btn = findViewById(R.id.btn_q5_send);
        base_url = "http://192.168.1.73:8080/";
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
                    case R.id.radioButton244:
                        radioButton_string6 = "10";
                        break;
                    case R.id.radioButton245:
                        radioButton_string6 = "9";
                        break;
                    case R.id.radioButton246:
                        radioButton_string6 = "8";
                        break;
                    case R.id.radioButton247:
                        radioButton_string6 = "7";
                        break;
                    case R.id.radioButton248:
                        radioButton_string6 = "6";
                        break;
                    case R.id.radioButton249:
                        radioButton_string6 = "5";
                        break;
                    case R.id.radioButton250:
                        radioButton_string6 = "4";
                        break;
                    case R.id.radioButton251:
                        radioButton_string6 = "3";
                        break;
                    case R.id.radioButton252:
                        radioButton_string6 = "2";
                        break;
                    case R.id.radioButton253:
                        radioButton_string6 = "1";
                        break;
                }
            }
        });

        radioGroup5.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch(i){
                    case R.id.radioButton234:
                        radioButton_string5 = "10";
                        break;
                    case R.id.radioButton235:
                        radioButton_string5 = "9";
                        break;
                    case R.id.radioButton236:
                        radioButton_string5 = "8";
                        break;
                    case R.id.radioButton237:
                        radioButton_string5 = "7";
                        break;
                    case R.id.radioButton238:
                        radioButton_string5 = "6";
                        break;
                    case R.id.radioButton239:
                        radioButton_string5 = "5";
                        break;
                    case R.id.radioButton240:
                        radioButton_string5 = "4";
                        break;
                    case R.id.radioButton241:
                        radioButton_string5 = "3";
                        break;
                    case R.id.radioButton242:
                        radioButton_string5 = "2";
                        break;
                    case R.id.radioButton243:
                        radioButton_string5 = "1";
                        break;
                }
            }
        });

        radioGroup4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch(i){
                    case R.id.radioButton224:
                        radioButton_string4 = "10";
                        break;
                    case R.id.radioButton225:
                        radioButton_string4 = "9";
                        break;
                    case R.id.radioButton226:
                        radioButton_string4 = "8";
                        break;
                    case R.id.radioButton227:
                        radioButton_string4 = "7";
                        break;
                    case R.id.radioButton228:
                        radioButton_string4 = "6";
                        break;
                    case R.id.radioButton229:
                        radioButton_string4 = "5";
                        break;
                    case R.id.radioButton230:
                        radioButton_string4 = "4";
                        break;
                    case R.id.radioButton231:
                        radioButton_string4 = "3";
                        break;
                    case R.id.radioButton232:
                        radioButton_string4 = "2";
                        break;
                    case R.id.radioButton233:
                        radioButton_string4 = "1";
                        break;
                }
            }
        });

        radioGroup3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch(i){
                    case R.id.radioButton214:
                        radioButton_string3 = "10";
                        break;
                    case R.id.radioButton215:
                        radioButton_string3 = "9";
                        break;
                    case R.id.radioButton216:
                        radioButton_string3 = "8";
                        break;
                    case R.id.radioButton217:
                        radioButton_string3 = "7";
                        break;
                    case R.id.radioButton218:
                        radioButton_string3 = "6";
                        break;
                    case R.id.radioButton219:
                        radioButton_string3 = "5";
                        break;
                    case R.id.radioButton220:
                        radioButton_string3 = "4";
                        break;
                    case R.id.radioButton221:
                        radioButton_string3 = "3";
                        break;
                    case R.id.radioButton222:
                        radioButton_string3 = "2";
                        break;
                    case R.id.radioButton223:
                        radioButton_string3 = "1";
                        break;
                }
            }
        });

        radioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch(i){
                    case R.id.radioButton152:
                        radioButton_string2 = "10";
                        break;
                    case R.id.radioButton153:
                        radioButton_string2 = "9";
                        break;
                    case R.id.radioButton206:
                        radioButton_string2 = "8";
                        break;
                    case R.id.radioButton207:
                        radioButton_string2 = "7";
                        break;
                    case R.id.radioButton208:
                        radioButton_string2 = "6";
                        break;
                    case R.id.radioButton209:
                        radioButton_string2 = "5";
                        break;
                    case R.id.radioButton210:
                        radioButton_string2 = "4";
                        break;
                    case R.id.radioButton211:
                        radioButton_string2 = "3";
                        break;
                    case R.id.radioButton212:
                        radioButton_string2 = "2";
                        break;
                    case R.id.radioButton213:
                        radioButton_string2 = "1";
                        break;
                }
            }
        });

        radioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch(i){
                    case R.id.radioButton43:
                        radioButton_string = "10";
                        break;
                    case R.id.radioButton44:
                        radioButton_string = "9";
                        break;
                    case R.id.radioButton52:
                        radioButton_string = "8";
                        break;
                    case R.id.radioButton54:
                        radioButton_string = "7";
                        break;
                    case R.id.radioButton146:
                        radioButton_string = "6";
                        break;
                    case R.id.radioButton147:
                        radioButton_string = "5";
                        break;
                    case R.id.radioButton148:
                        radioButton_string = "4";
                        break;
                    case R.id.radioButton149:
                        radioButton_string = "3";
                        break;
                    case R.id.radioButton150:
                        radioButton_string = "2";
                        break;
                    case R.id.radioButton151:
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
                Quest5 quest5 = new Quest5();
                quest5.setAge(radioButton_string2);
                quest5.setIllnes(radioButton_string3);
                quest5.setMedical(radioButton_string4);
                quest5.setNew_medical(radioButton_string6);
                quest5.setSide_effect(radioButton_string5);
                quest5.setId_2(json_user_id);
                quest5.setGender(radioButton_string);

                Call<Quest5> call = service.insertQuset5 (quest5.getGender(),
                        quest5.getAge(),
                        quest5.getIllnes(),
                        quest5.getMedical(),
                        quest5.getSide_effect(),
                        quest5.getNew_medical(),
                        quest5.getId_2()
                );

                call.enqueue(new Callback<Quest5>() {
                    @Override
                    public void onResponse(Call<Quest5> call, Response<Quest5> response) {

                    }

                    @Override
                    public void onFailure(Call<Quest5> call, Throwable t) {
                        Log.d("onFailure", t.toString());
                        in1 = Integer.parseInt(radioButton_string2);
                        in2 = Integer.parseInt(radioButton_string3);
                        in3 = Integer.parseInt(radioButton_string4);
                        in4 = Integer.parseInt(radioButton_string5);
                        in5 = Integer.parseInt(radioButton_string6);
                        in6 = Integer.parseInt(radioButton_string);
                        Integer sum = in1 + in2 + in3 + in4 + in5 + in6;
                        if (sum >= 0 && sum <= 29) {
                            tx1.setVisibility(View.VISIBLE);
                            tx2.setVisibility(View.VISIBLE);
                            tx3.setVisibility(View.VISIBLE);
                        }else if(sum >= 30 && sum <= 50){
                            tx4.setVisibility(View.VISIBLE);
                            tx5.setVisibility(View.VISIBLE);
                            tx6.setVisibility(View.VISIBLE);
                        }else if (sum >= 51){
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