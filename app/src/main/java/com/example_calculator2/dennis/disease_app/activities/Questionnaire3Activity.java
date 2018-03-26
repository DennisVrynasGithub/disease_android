package com.example_calculator2.dennis.disease_app.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example_calculator2.dennis.disease_app.R;
import com.example_calculator2.dennis.disease_app.model.Quest3;
import com.example_calculator2.dennis.disease_app.service.Api;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Questionnaire3Activity extends AppCompatActivity {

    RadioGroup radioGroup1, radioGroup2, radioGroup3, radioGroup4, radioGroup5;
    EditText et1,et;
    Button btn,btn_n1,btn_p2,btn_n2,btn_p3,btn_n3,btn_p4,btn_p5,btn_n4,btn_p6,btn_n5,btn_dn,btn_dp,btn_back;
    String json_user_id,base_url, radioButton_string, radioButton_string2, radioButton_string3, radioButton_string4, radioButton_string5;
    TextView tx1,tx2,tx3,tx4,tx5,tx6,tx7,tx8,tx9,TX1,TX2,TX3,TX4,TX5;
    Integer in1, in2, in3, in4, in5;
    LinearLayout ln1,ln2,ln3,ln4,ln5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnaire3);

        radioGroup1 = findViewById(R.id.radiogroup31);
        radioGroup2 = findViewById(R.id.radiogroup32);
        radioGroup3 = findViewById(R.id.radiogroup33);
        radioGroup4 = findViewById(R.id.radiogroup34);
        radioGroup5 = findViewById(R.id.radiogroup35);

        ln1 = findViewById(R.id.linearLayout7);
        ln2 = findViewById(R.id.linearLayout8);
        ln3 = findViewById(R.id.linearLayout9);
        ln4 = findViewById(R.id.linearLayout10);
        ln5 = findViewById(R.id.linearLayout27);

        tx1 = findViewById(R.id.textView354);
        tx2 = findViewById(R.id.textView355);
        tx3 = findViewById(R.id.textView356);
        tx4 = findViewById(R.id.textView357);
        tx5 = findViewById(R.id.textView358);
        tx6 = findViewById(R.id.textView359);
        tx7 = findViewById(R.id.textView360);
        tx8 = findViewById(R.id.textView361);
        tx9 = findViewById(R.id.textView362);
        et1 = findViewById(R.id.et_q3_age);
        et = findViewById(R.id.editText9);
        btn = findViewById(R.id.btn_q3_send);

        TX1 = findViewById(R.id.textView12);
        TX2 = findViewById(R.id.textView23);
        TX3 = findViewById(R.id.textView24);
        TX4 = findViewById(R.id.textView25);
        TX5 = findViewById(R.id.textView26);

        btn_n1 = findViewById(R.id.q3_n1);
        btn_back = findViewById(R.id.q3_back);
        btn_n2 = findViewById(R.id.q3_n2);
        btn_p2 = findViewById(R.id.q3_p2);
        btn_n3 = findViewById(R.id.q3_n3);
        btn_p3 = findViewById(R.id.q3_p3);
        btn_n4 = findViewById(R.id.q3_n4);
        btn_n5 = findViewById(R.id.q3_n5);
        btn_p4 = findViewById(R.id.q3_p4);
        btn_p6 = findViewById(R.id.q3_p6);
        btn_p5 = findViewById(R.id.q3_p5);
        btn_dn = findViewById(R.id.q3_dn);
        btn_dp = findViewById(R.id.q3_dp);

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

        ln2.setVisibility(View.INVISIBLE);
        ln1.setVisibility(View.INVISIBLE);
        ln3.setVisibility(View.INVISIBLE);
        ln4.setVisibility(View.INVISIBLE);
        ln5.setVisibility(View.INVISIBLE);

        btn_n2.setVisibility(View.INVISIBLE);
        btn_n3.setVisibility(View.INVISIBLE);
        btn_n4.setVisibility(View.INVISIBLE);
        btn_n5.setVisibility(View.INVISIBLE);
        btn.setVisibility(View.INVISIBLE);
        btn_p2.setVisibility(View.INVISIBLE);
        btn_p3.setVisibility(View.INVISIBLE);
        btn_p4.setVisibility(View.INVISIBLE);
        btn_p5.setVisibility(View.INVISIBLE);
        btn_p6.setVisibility(View.INVISIBLE);
        btn_dn.setVisibility(View.INVISIBLE);
        btn_dp.setVisibility(View.INVISIBLE);

        TX2.setVisibility(View.INVISIBLE);
        TX1.setVisibility(View.INVISIBLE);
        TX3.setVisibility(View.INVISIBLE);
        TX4.setVisibility(View.INVISIBLE);
        TX5.setVisibility(View.INVISIBLE);
        et.setVisibility(View.INVISIBLE);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Questionnaire3Activity.this, DashboardActivity.class);
                startActivity(intent);
                Questionnaire3Activity.this.finish();
            }
        });

        btn_n1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et1.setVisibility(View.INVISIBLE);
                btn_back.setVisibility(View.INVISIBLE);
                btn_n1.setVisibility(View.INVISIBLE);

                TX1.setVisibility(View.VISIBLE);
                ln1.setVisibility(View.VISIBLE);
                btn_p2.setVisibility(View.VISIBLE);
                btn_n2.setVisibility(View.VISIBLE);
            }
        });
        btn_n2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TX1.setVisibility(View.INVISIBLE);
                ln1.setVisibility(View.INVISIBLE);
                btn_p2.setVisibility(View.INVISIBLE);
                btn_n2.setVisibility(View.INVISIBLE);

                TX2.setVisibility(View.VISIBLE);
                ln2.setVisibility(View.VISIBLE);
                btn_p3.setVisibility(View.VISIBLE);
                btn_n3.setVisibility(View.VISIBLE);
            }
        });
        btn_n3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TX2.setVisibility(View.INVISIBLE);
                ln2.setVisibility(View.INVISIBLE);
                btn_p3.setVisibility(View.INVISIBLE);
                btn_n3.setVisibility(View.INVISIBLE);

                TX3.setVisibility(View.VISIBLE);
                ln3.setVisibility(View.VISIBLE);
                btn_p4.setVisibility(View.VISIBLE);
                btn_n4.setVisibility(View.VISIBLE);
            }
        });
        btn_n4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TX3.setVisibility(View.INVISIBLE);
                ln3.setVisibility(View.INVISIBLE);
                btn_p4.setVisibility(View.INVISIBLE);
                btn_n4.setVisibility(View.INVISIBLE);

                TX4.setVisibility(View.VISIBLE);
                ln4.setVisibility(View.VISIBLE);
                btn_n5.setVisibility(View.VISIBLE);
                btn_p5.setVisibility(View.VISIBLE);
            }
        });
        btn_dn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et.setVisibility(View.INVISIBLE);
                btn_dn.setVisibility(View.INVISIBLE);
                btn_dp.setVisibility(View.INVISIBLE);

                TX5.setVisibility(View.VISIBLE);
                ln5.setVisibility(View.VISIBLE);
                btn.setVisibility(View.VISIBLE);
                btn_p6.setVisibility(View.VISIBLE);
            }
        });
        btn_n5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TX4.setVisibility(View.INVISIBLE);
                ln4.setVisibility(View.INVISIBLE);
                btn_n5.setVisibility(View.INVISIBLE);
                btn_p5.setVisibility(View.INVISIBLE);

                et.setVisibility(View.VISIBLE);
                btn_dn.setVisibility(View.VISIBLE);
                btn_dp.setVisibility(View.VISIBLE);
            }
        });
        btn_p6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TX5.setVisibility(View.INVISIBLE);
                ln5.setVisibility(View.INVISIBLE);
                btn.setVisibility(View.INVISIBLE);
                btn_p6.setVisibility(View.INVISIBLE);

                et.setVisibility(View.VISIBLE);
                btn_dp.setVisibility(View.VISIBLE);
                btn_dn.setVisibility(View.VISIBLE);
            }
        });
        btn_dp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et.setVisibility(View.INVISIBLE);
                btn_dp.setVisibility(View.INVISIBLE);
                btn_dn.setVisibility(View.INVISIBLE);

                TX4.setVisibility(View.VISIBLE);
                ln4.setVisibility(View.VISIBLE);
                btn_p5.setVisibility(View.VISIBLE);
                btn_n5.setVisibility(View.VISIBLE);
            }
        });
        btn_p5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TX4.setVisibility(View.INVISIBLE);
                ln4.setVisibility(View.INVISIBLE);
                btn_n5.setVisibility(View.INVISIBLE);
                btn_p5.setVisibility(View.INVISIBLE);

                TX3.setVisibility(View.VISIBLE);
                ln3.setVisibility(View.VISIBLE);
                btn_p4.setVisibility(View.VISIBLE);
                btn_n4.setVisibility(View.VISIBLE);
            }
        });
        btn_p4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TX3.setVisibility(View.INVISIBLE);
                ln3.setVisibility(View.INVISIBLE);
                btn_n4.setVisibility(View.INVISIBLE);
                btn_p4.setVisibility(View.INVISIBLE);

                TX2.setVisibility(View.VISIBLE);
                ln2.setVisibility(View.VISIBLE);
                btn_n3.setVisibility(View.VISIBLE);
                btn_p3.setVisibility(View.VISIBLE);
            }
        });
        btn_p3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TX2.setVisibility(View.INVISIBLE);
                ln2.setVisibility(View.INVISIBLE);
                btn_n3.setVisibility(View.INVISIBLE);
                btn_p3.setVisibility(View.INVISIBLE);

                TX1.setVisibility(View.VISIBLE);
                ln1.setVisibility(View.VISIBLE);
                btn_n2.setVisibility(View.VISIBLE);
                btn_p2.setVisibility(View.VISIBLE);
            }
        });
        btn_p2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TX1.setVisibility(View.INVISIBLE);
                ln1.setVisibility(View.INVISIBLE);
                btn_n2.setVisibility(View.INVISIBLE);
                btn_p2.setVisibility(View.INVISIBLE);

                et1.setVisibility(View.VISIBLE);
                btn_n1.setVisibility(View.VISIBLE);
                btn_back.setVisibility(View.VISIBLE);
            }
        });


        radioGroup5.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch(i){
                    case R.id.radioButton136:
                        radioButton_string5 = "10";
                        break;
                    case R.id.radioButton137:
                        radioButton_string5 = "9";
                        break;
                    case R.id.radioButton138:
                        radioButton_string5 = "8";
                        break;
                    case R.id.radioButton139:
                        radioButton_string5 = "7";
                        break;
                    case R.id.radioButton140:
                        radioButton_string5 = "6";
                        break;
                    case R.id.radioButton141:
                        radioButton_string5 = "5";
                        break;
                    case R.id.radioButton142:
                        radioButton_string5 = "4";
                        break;
                    case R.id.radioButton143:
                        radioButton_string5 = "3";
                        break;
                    case R.id.radioButton144:
                        radioButton_string5 = "2";
                        break;
                    case R.id.radioButton145:
                        radioButton_string5 = "1";
                        break;
                }
            }
        });

        radioGroup4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch(i){
                    case R.id.radioButton126:
                        radioButton_string4 = "10";
                        break;
                    case R.id.radioButton127:
                        radioButton_string4 = "9";
                        break;
                    case R.id.radioButton128:
                        radioButton_string4 = "8";
                        break;
                    case R.id.radioButton129:
                        radioButton_string4 = "7";
                        break;
                    case R.id.radioButton130:
                        radioButton_string4 = "6";
                        break;
                    case R.id.radioButton131:
                        radioButton_string4 = "5";
                        break;
                    case R.id.radioButton132:
                        radioButton_string4 = "4";
                        break;
                    case R.id.radioButton133:
                        radioButton_string4 = "3";
                        break;
                    case R.id.radioButton134:
                        radioButton_string4 = "2";
                        break;
                    case R.id.radioButton135:
                        radioButton_string4 = "1";
                        break;
                }
            }
        });

        radioGroup3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch(i){
                    case R.id.radioButton116:
                        radioButton_string3 = "10";
                        break;
                    case R.id.radioButton117:
                        radioButton_string3 = "9";
                        break;
                    case R.id.radioButton118:
                        radioButton_string3 = "8";
                        break;
                    case R.id.radioButton119:
                        radioButton_string3 = "7";
                        break;
                    case R.id.radioButton120:
                        radioButton_string3 = "6";
                        break;
                    case R.id.radioButton121:
                        radioButton_string3 = "5";
                        break;
                    case R.id.radioButton122:
                        radioButton_string3 = "4";
                        break;
                    case R.id.radioButton123:
                        radioButton_string3 = "3";
                        break;
                    case R.id.radioButton124:
                        radioButton_string3 = "2";
                        break;
                    case R.id.radioButton125:
                        radioButton_string3 = "1";
                        break;
                }
            }
        });

        radioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch(i){
                    case R.id.radioButton67:
                        radioButton_string2 = "10";
                        break;
                    case R.id.radioButton107:
                        radioButton_string2 = "9";
                        break;
                    case R.id.radioButton108:
                        radioButton_string2 = "8";
                        break;
                    case R.id.radioButton109:
                        radioButton_string2 = "7";
                        break;
                    case R.id.radioButton110:
                        radioButton_string2 = "6";
                        break;
                    case R.id.radioButton111:
                        radioButton_string2 = "5";
                        break;
                    case R.id.radioButton112:
                        radioButton_string2 = "4";
                        break;
                    case R.id.radioButton113:
                        radioButton_string2 = "3";
                        break;
                    case R.id.radioButton114:
                        radioButton_string2 = "2";
                        break;
                    case R.id.radioButton115:
                        radioButton_string2 = "1";
                        break;
                }
            }
        });

        radioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch(i){
                    case R.id.radioButton10:
                        radioButton_string = "10";
                        break;
                    case R.id.radioButton23:
                        radioButton_string = "9";
                        break;
                    case R.id.radioButton32:
                        radioButton_string = "8";
                        break;
                    case R.id.radioButton33:
                        radioButton_string = "7";
                        break;
                    case R.id.radioButton59:
                        radioButton_string = "6";
                        break;
                    case R.id.radioButton60:
                        radioButton_string = "5";
                        break;
                    case R.id.radioButton61:
                        radioButton_string = "4";
                        break;
                    case R.id.radioButton63:
                        radioButton_string = "3";
                        break;
                    case R.id.radioButton64:
                        radioButton_string = "2";
                        break;
                    case R.id.radioButton65:
                        radioButton_string = "1";
                        break;
                }
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(base_url)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                Api service = retrofit.create(Api.class);
                Quest3 quest3 = new Quest3();
                quest3.setAge(radioButton_string);
                quest3.setMedical(radioButton_string4);
                quest3.setChronic_problem(radioButton_string2);
                quest3.setYears(radioButton_string3);
                quest3.setOther_illnes(radioButton_string5);
                quest3.setId_2(json_user_id);
                quest3.setGender(et1.getText().toString());

                Call<Quest3> call = service.insertQuset3(quest3.getGender(),
                        quest3.getAge(),
                        quest3.getChronic_problem(),
                        quest3.getYears(),
                        quest3.getMedical(),
                        quest3.getOther_illnes(),
                        quest3.getId_2(),
                        quest3.getDate(),
                        quest3.getScore()
                );

                call.enqueue(new Callback<Quest3>() {
                    @Override
                    public void onResponse(Call<Quest3> call, Response<Quest3> response) {

                    }

                    @Override
                    public void onFailure(Call<Quest3> call, Throwable t) {
                        Log.d("onFailure", t.toString());
                    }
                });
            }
        });
    }
}
