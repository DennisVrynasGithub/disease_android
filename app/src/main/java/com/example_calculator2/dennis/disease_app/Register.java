package com.example_calculator2.dennis.disease_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example_calculator2.dennis.disease_app.model.Users;
import com.example_calculator2.dennis.disease_app.service.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class Register extends AppCompatActivity {

    EditText et1, et2, et3, et4, et5, et6;
    Button btn1, btn2;
    String base_url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        et1 = findViewById(R.id.editText_user_name1);
        et2 = findViewById(R.id.editText_user_pasword2);
        et3 = findViewById(R.id.editText_user_email2);
        et4 = findViewById(R.id.editText_country);
        et5 = findViewById(R.id.editText_gender);
        et6 = findViewById(R.id.editText_age);
        btn1 = findViewById(R.id.bn_register2);
        btn2 = findViewById(R.id.btn_register_back);
        base_url = "http://192.168.1.73:8080/";

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Register.this, Dashboard.class);
                startActivity(intent);
                Register.this.finish();
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(base_url)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                User service = retrofit.create(User.class);
                Users user = new Users();
                user.setUser_name(et1.getText().toString());
                user.setUser_password(et2.getText().toString());
                user.setUser_email(et3.getText().toString());
                user.setCountry(et4.getText().toString());
                user.setAge(et6.getText().toString());
                user.setGendre(et5.getText().toString());

                Call<Users> call = service.insertUserRegister(user.getUser_name(),
                        user.getUser_password(),
                        user.getUser_email(),
                        user.getCountry(),
                        user.getAge(),
                        user.getGendre()
                );

                call.enqueue(new Callback<Users>() {
                    @Override
                    public void onResponse(Call<Users> call, Response<Users> response) {
//                        if (response.isSuccessful()) {
//                            Toast.makeText(Register.this, "Register successful", Toast.LENGTH_SHORT).show();
//                            Intent intent = new Intent(Register.this, Login.class);
//                            startActivity(intent);
//                            Register.this.finish();
//                        }
                    }

                    @Override
                    public void onFailure(Call<Users> call, Throwable t) {
                        Log.d("onFailure", t.toString());
                    }
                });
            }
        });
    }
}
