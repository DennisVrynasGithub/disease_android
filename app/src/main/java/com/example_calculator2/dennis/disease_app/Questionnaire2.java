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

import com.example_calculator2.dennis.disease_app.model.Quest1;
import com.example_calculator2.dennis.disease_app.model.Quest2;
import com.example_calculator2.dennis.disease_app.service.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Questionnaire2 extends AppCompatActivity {

    RadioGroup radioGroup1, radioGroup2,radioGroup3, radioGroup4;
    Button btn;
    EditText et4;
    String json_user_id,base_url, radioButton_string, radioButton_string2, radioButton_string3, radioButton_string4;
    TextView tx1,tx2,tx3,tx4,tx5,tx6,tx7,tx8,tx9;
    Integer in1, in2, in3, in4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnaire2);

        radioGroup1 = findViewById(R.id.radiogroup21);
        radioGroup2 = findViewById(R.id.radiogroup22);
        radioGroup3 = findViewById(R.id.radiogroup23);
        radioGroup4 = findViewById(R.id.radiogroup24);
        tx1 = findViewById(R.id.textView54);
        tx2 = findViewById(R.id.textView55);
        tx3 = findViewById(R.id.textView56);
        tx4 = findViewById(R.id.textView57);
        tx5 = findViewById(R.id.textView58);
        tx6 = findViewById(R.id.textView59);
        tx7 = findViewById(R.id.textView60);
        tx8 = findViewById(R.id.textView61);
        tx9 = findViewById(R.id.textView62);
        et4 = findViewById(R.id.editText);
        btn = findViewById(R.id.btn_q2_send);
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

        radioGroup4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch(i){
                    case R.id.radioButton97:
                        radioButton_string4 = "10";
                        break;
                    case R.id.radioButton98:
                        radioButton_string4 = "9";
                        break;
                    case R.id.radioButton99:
                        radioButton_string4 = "8";
                        break;
                    case R.id.radioButton100:
                        radioButton_string4 = "7";
                        break;
                    case R.id.radioButton101:
                        radioButton_string4 = "6";
                        break;
                    case R.id.radioButton102:
                        radioButton_string4 = "5";
                        break;
                    case R.id.radioButton103:
                        radioButton_string4 = "4";
                        break;
                    case R.id.radioButton104:
                        radioButton_string4 = "3";
                        break;
                    case R.id.radioButton105:
                        radioButton_string4 = "2";
                        break;
                    case R.id.radioButton106:
                        radioButton_string4 = "1";
                        break;
                }
            }
        });

        radioGroup3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch(i){
                    case R.id.radioButton87:
                        radioButton_string3 = "10";
                        break;
                    case R.id.radioButton88:
                        radioButton_string3 = "9";
                        break;
                    case R.id.radioButton89:
                        radioButton_string3 = "8";
                        break;
                    case R.id.radioButton90:
                        radioButton_string3 = "7";
                        break;
                    case R.id.radioButton91:
                        radioButton_string3 = "6";
                        break;
                    case R.id.radioButton92:
                        radioButton_string3 = "5";
                        break;
                    case R.id.radioButton93:
                        radioButton_string3 = "4";
                        break;
                    case R.id.radioButton94:
                        radioButton_string3 = "3";
                        break;
                    case R.id.radioButton95:
                        radioButton_string3 = "2";
                        break;
                    case R.id.radioButton96:
                        radioButton_string3 = "1";
                        break;
                }
            }
        });

        radioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch(i){
                    case R.id.radioButton77:
                        radioButton_string2 = "10";
                        break;
                    case R.id.radioButton78:
                        radioButton_string2 = "9";
                        break;
                    case R.id.radioButton79:
                        radioButton_string2 = "8";
                        break;
                    case R.id.radioButton80:
                        radioButton_string2 = "7";
                        break;
                    case R.id.radioButton81:
                        radioButton_string2 = "6";
                        break;
                    case R.id.radioButton82:
                        radioButton_string2 = "5";
                        break;
                    case R.id.radioButton83:
                        radioButton_string2 = "4";
                        break;
                    case R.id.radioButton84:
                        radioButton_string2 = "3";
                        break;
                    case R.id.radioButton85:
                        radioButton_string2 = "2";
                        break;
                    case R.id.radioButton86:
                        radioButton_string2 = "1";
                        break;
                }
            }
        });

        radioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch(i){
                    case R.id.radioButton22:
                        radioButton_string = "10";
                        break;
                    case R.id.radioButton68:
                        radioButton_string = "9";
                        break;
                    case R.id.radioButton69:
                        radioButton_string = "8";
                        break;
                    case R.id.radioButton70:
                        radioButton_string = "7";
                        break;
                    case R.id.radioButton71:
                        radioButton_string = "6";
                        break;
                    case R.id.radioButton72:
                        radioButton_string = "5";
                        break;
                    case R.id.radioButton73:
                        radioButton_string = "4";
                        break;
                    case R.id.radioButton74:
                        radioButton_string = "3";
                        break;
                    case R.id.radioButton75:
                        radioButton_string = "2";
                        break;
                    case R.id.radioButton76:
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
                Quest2 quest2 = new Quest2();
                quest2.setAge(radioButton_string);
                quest2.setIllnes(radioButton_string2);
                quest2.setIllnes_history(radioButton_string4);
                quest2.setMedical_history(radioButton_string3);
                quest2.setId_2(json_user_id);
                quest2.setGender(et4.getText().toString());


                Call<Quest2> call = service.insertQuset2(quest2.getGender(),
                        quest2.getAge(),
                        quest2.getMedical_history(),
                        quest2.getIllnes(),
                        quest2.getIllnes_history(),
                        quest2.getId_2()
                );

                call.enqueue(new Callback<Quest2>() {
                    @Override
                    public void onResponse(Call<Quest2> call, Response<Quest2> response) {

                    }

                    @Override
                    public void onFailure(Call<Quest2> call, Throwable t) {
                        Log.d("onFailure", t.toString());
                        in1 = Integer.parseInt(radioButton_string2);
                        in2 = Integer.parseInt(radioButton_string3);
                        in3 = Integer.parseInt(radioButton_string4);
                        in4 = Integer.parseInt(radioButton_string);
                        Integer sum = in1 + in2 + in3 + in4;
                        if (sum >= 0 && sum <= 15) {
                            tx1.setVisibility(View.VISIBLE);
                            tx2.setVisibility(View.VISIBLE);
                            tx3.setVisibility(View.VISIBLE);
                        }else if(sum >= 16 && sum <= 30){
                            tx4.setVisibility(View.VISIBLE);
                            tx5.setVisibility(View.VISIBLE);
                            tx6.setVisibility(View.VISIBLE);
                        }else if (sum >= 31){
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
