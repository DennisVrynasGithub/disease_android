package com.example_calculator2.dennis.disease_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example_calculator2.dennis.disease_app.model.Users;
import com.example_calculator2.dennis.disease_app.service.User;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Profile extends AppCompatActivity {

    String json_user_id, base_url, json_user_email;
    EditText et1, et2, et3, et4;
    Button btn1,btn2,btn3,btn4,btn5;
    TextView tx1,tx2,tx3,tx4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        btn1 = findViewById(R.id.change_name);
        btn2 = findViewById(R.id.change_password);
        btn3 = findViewById(R.id.change_country);
        btn4 = findViewById(R.id.change_age);
        btn5 = findViewById(R.id.profile_back);
        et1 = findViewById(R.id.editText2);
        et2 = findViewById(R.id.editText4);
        et3 = findViewById(R.id.editText5);
        et4 = findViewById(R.id.editText6);
        tx1 = findViewById(R.id.textView65);
        tx2 = findViewById(R.id.textView66);
        tx3 = findViewById(R.id.textView67);
        tx4 = findViewById(R.id.textView68);

        tx1.setVisibility(View.INVISIBLE);
        tx2.setVisibility(View.INVISIBLE);
        tx3.setVisibility(View.INVISIBLE);
        tx4.setVisibility(View.INVISIBLE);

        base_url = "http://83.212.101.67:80/";
        json_user_id = getIntent().getExtras().getString("json_user_id");
        json_user_email = getIntent().getExtras().getString("json_user_email");

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Profile.this, Welcome.class);
                intent.putExtra("json_user_id", json_user_id);
                intent.putExtra("json_user_email", json_user_email);
                startActivity(intent);
                Profile.this.finish();

            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Objects.equals(et1.getText().toString(),"")){
                    Toast.makeText(Profile.this, "Please enter new user name", Toast.LENGTH_SHORT).show();
                }else {
                    Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl(base_url)
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();

                    User service = retrofit.create(User.class);
                    Users user = new Users();
                    user.setUser_name(et1.getText().toString());
                    user.setUser_email(json_user_email);

                    Call<Users> call = service.updatename(user.getUser_name(),
                            user.getUser_email()
                    );

                    call.enqueue(new Callback<Users>() {
                        @Override
                        public void onResponse(Call<Users> call, Response<Users> response) {
                            if (response.isSuccessful()) {
                                Toast.makeText(Profile.this, "Update successful", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<Users> call, Throwable t) {
                            Log.d("onFailure", t.toString());
                        }
                    });
                    tx1.setVisibility(View.VISIBLE);
                    tx2.setVisibility(View.INVISIBLE);
                    tx3.setVisibility(View.INVISIBLE);
                    tx4.setVisibility(View.INVISIBLE);
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Objects.equals(et2.getText().toString(),"")){
                    Toast.makeText(Profile.this, "Please enter new user password", Toast.LENGTH_SHORT).show();
                }else {
                    Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl(base_url)
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();

                    User service = retrofit.create(User.class);
                    Users user = new Users();
                    user.setUser_name(et2.getText().toString());
                    user.setUser_email(json_user_email);

                    Call<Users> call = service.updatepassword(user.getUser_name(),
                            user.getUser_email()
                    );

                    call.enqueue(new Callback<Users>() {
                        @Override
                        public void onResponse(Call<Users> call, Response<Users> response) {
                            if (response.isSuccessful()) {
                                Toast.makeText(Profile.this, "Update successful", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<Users> call, Throwable t) {
                            Log.d("onFailure", t.toString());
                        }
                    });
                    tx1.setVisibility(View.INVISIBLE);
                    tx2.setVisibility(View.VISIBLE);
                    tx3.setVisibility(View.INVISIBLE);
                    tx4.setVisibility(View.INVISIBLE);
                }
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Objects.equals(et3.getText().toString(),"")){
                    Toast.makeText(Profile.this, "Please enter new user country", Toast.LENGTH_SHORT).show();
                }else {
                    Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl(base_url)
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();

                    User service = retrofit.create(User.class);
                    Users user = new Users();
                    user.setUser_name(et3.getText().toString());
                    user.setUser_email(json_user_email);

                    Call<Users> call = service.updatecountry(user.getUser_name(),
                            user.getUser_email()
                    );

                    call.enqueue(new Callback<Users>() {
                        @Override
                        public void onResponse(Call<Users> call, Response<Users> response) {
                            if (response.isSuccessful()) {
                                Toast.makeText(Profile.this, "Update successful", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<Users> call, Throwable t) {
                            Log.d("onFailure", t.toString());
                        }
                    });
                    tx1.setVisibility(View.INVISIBLE);
                    tx2.setVisibility(View.INVISIBLE);
                    tx3.setVisibility(View.VISIBLE);
                    tx4.setVisibility(View.INVISIBLE);
                }
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Objects.equals(et3.getText().toString(),"")){
                    Toast.makeText(Profile.this, "Please enter new user age", Toast.LENGTH_SHORT).show();
                }else {
                    Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl(base_url)
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();

                    User service = retrofit.create(User.class);
                    Users user = new Users();
                    user.setUser_name(et4.getText().toString());
                    user.setUser_email(json_user_email);

                    Call<Users> call = service.updateage(user.getUser_name(),
                            user.getUser_email()
                    );

                    call.enqueue(new Callback<Users>() {
                        @Override
                        public void onResponse(Call<Users> call, Response<Users> response) {
                            if (response.isSuccessful()) {
                                Toast.makeText(Profile.this, "Update successful", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<Users> call, Throwable t) {
                            Log.d("onFailure", t.toString());
                        }
                    });
                    tx1.setVisibility(View.INVISIBLE);
                    tx2.setVisibility(View.INVISIBLE);
                    tx3.setVisibility(View.INVISIBLE);
                    tx4.setVisibility(View.VISIBLE);
                }
            }
        });

    }
}
