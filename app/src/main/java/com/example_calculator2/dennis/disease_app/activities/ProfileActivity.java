package com.example_calculator2.dennis.disease_app.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example_calculator2.dennis.disease_app.R;
import com.example_calculator2.dennis.disease_app.model.LoginRequest;
import com.example_calculator2.dennis.disease_app.model.LoginResponse;
import com.example_calculator2.dennis.disease_app.model.ProfileChangeAgeRequest;
import com.example_calculator2.dennis.disease_app.model.ProfileChangeAgeResponse;
import com.example_calculator2.dennis.disease_app.model.ProfileChangeCountryRequest;
import com.example_calculator2.dennis.disease_app.model.ProfileChangeCountryResponse;
import com.example_calculator2.dennis.disease_app.model.ProfileChangeNameRequest;
import com.example_calculator2.dennis.disease_app.model.ProfileChangeNameResponse;
import com.example_calculator2.dennis.disease_app.model.ProfileChangePasswordRequest;
import com.example_calculator2.dennis.disease_app.model.ProfileChangePasswordResponse;
import com.example_calculator2.dennis.disease_app.model.Users;
import com.example_calculator2.dennis.disease_app.service.Api;
import com.example_calculator2.dennis.disease_app.utils.G;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProfileActivity extends AppCompatActivity {

    String json_user_id, json_user_email, json_user_password;
    EditText editTextName, editTextPassword, editTextCountry, editTextAge;
    Button button_change_name, button_change_password, button_change_country, button_change_age, button_back;
    TextView tx1, tx2, tx3, tx4;

    private Api api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        button_change_name = findViewById(R.id.change_name);
        button_change_password = findViewById(R.id.change_password);
        button_change_country = findViewById(R.id.change_country);
        button_change_age = findViewById(R.id.change_age);
        button_back = findViewById(R.id.profile_back);
        editTextName = findViewById(R.id.editText2);
        editTextPassword = findViewById(R.id.editText4);
        editTextCountry = findViewById(R.id.editText5);
        editTextAge = findViewById(R.id.editText6);
        tx1 = findViewById(R.id.textView65);
        tx2 = findViewById(R.id.textView66);
        tx3 = findViewById(R.id.textView67);
        tx4 = findViewById(R.id.textView68);

        tx1.setVisibility(View.INVISIBLE);
        tx2.setVisibility(View.INVISIBLE);
        tx3.setVisibility(View.INVISIBLE);
        tx4.setVisibility(View.INVISIBLE);

        json_user_id = getIntent().getExtras().getString("json_user_id");
        json_user_email = getIntent().getExtras().getString("json_user_email");
        json_user_password = getIntent().getExtras().getString("json_user_password");

        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileActivity.this, WelcomeActivity.class);
                intent.putExtra("json_user_id", json_user_id);
                intent.putExtra("json_user_email", json_user_email);
                intent.putExtra("json_user_password", json_user_password);
                startActivity(intent);
                ProfileActivity.this.finish();

            }
        });

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(G.HOST_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(Api.class);

        button_change_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Objects.equals(editTextName.getText().toString(), "")) {
                    Toast.makeText(ProfileActivity.this, "Please enter new user name", Toast.LENGTH_SHORT).show();
                } else {

                    changeName(json_user_email,editTextName.getText().toString());
//                    Users user = new Users();
//                    user.setUser_name(editTextName.getText().toString());
//                    user.setUser_email(json_user_email);
//
//                    Call<Users> call = api.updatename(user.getUser_name(),
//                            user.getUser_email()
//                    );
//
//                    call.enqueue(new Callback<Users>() {
//                        @Override
//                        public void onResponse(Call<Users> call, Response<Users> response) {
//                            if (response.isSuccessful()) {
//                                Toast.makeText(ProfileActivity.this, "Update successful", Toast.LENGTH_SHORT).show();
//                            }
//                        }
//
//                        @Override
//                        public void onFailure(Call<Users> call, Throwable t) {
//                            Log.d("onFailure", t.toString());
//                        }
//                    });
//
//                    tx1.setVisibility(View.VISIBLE);
//                    tx2.setVisibility(View.INVISIBLE);
//                    tx3.setVisibility(View.INVISIBLE);
//                    tx4.setVisibility(View.INVISIBLE);
                }
            }
        });

        button_change_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Objects.equals(editTextPassword.getText().toString(), "")) {
                    Toast.makeText(ProfileActivity.this, "Please enter new user password", Toast.LENGTH_SHORT).show();
                } else {

                    changeAge(json_user_email,editTextPassword.getText().toString());

//                    Users user = new Users();
//                    user.setUser_name(editTextPassword.getText().toString());
//                    user.setUser_email(json_user_email);
//
//                    Call<Users> call = api.updatepassword(user.getUser_name(),
//                            user.getUser_email()
//                    );
//
//                    call.enqueue(new Callback<Users>() {
//                        @Override
//                        public void onResponse(Call<Users> call, Response<Users> response) {
//                            if (response.isSuccessful()) {
//                                Toast.makeText(ProfileActivity.this, "Update successful", Toast.LENGTH_SHORT).show();
//                            }
//                        }
//
//                        @Override
//                        public void onFailure(Call<Users> call, Throwable t) {
//                            Log.d("onFailure", t.toString());
//                        }
//                    });
//                    tx1.setVisibility(View.INVISIBLE);
//                    tx2.setVisibility(View.VISIBLE);
//                    tx3.setVisibility(View.INVISIBLE);
//                    tx4.setVisibility(View.INVISIBLE);
                }
            }
        });

        button_change_country.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Objects.equals(editTextCountry.getText().toString(), "")) {
                    Toast.makeText(ProfileActivity.this, "Please enter new user country", Toast.LENGTH_SHORT).show();
                } else {

                    changeCountry(json_user_email,editTextCountry.getText().toString());

//                    Users user = new Users();
//                    user.setUser_name(editTextCountry.getText().toString());
//                    user.setUser_email(json_user_email);
//
//                    Call<Users> call = api.updatecountry(user.getUser_name(),
//                            user.getUser_email()
//                    );
//
//                    call.enqueue(new Callback<Users>() {
//                        @Override
//                        public void onResponse(Call<Users> call, Response<Users> response) {
//                            if (response.isSuccessful()) {
//                                Toast.makeText(ProfileActivity.this, "Update successful", Toast.LENGTH_SHORT).show();
//                            }
//                        }
//
//                        @Override
//                        public void onFailure(Call<Users> call, Throwable t) {
//                            Log.d("onFailure", t.toString());
//                        }
//                    });
//                    tx1.setVisibility(View.INVISIBLE);
//                    tx2.setVisibility(View.INVISIBLE);
//                    tx3.setVisibility(View.VISIBLE);
//                    tx4.setVisibility(View.INVISIBLE);
                }
            }
        });

        button_change_age.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Objects.equals(editTextAge.getText().toString(), "")) {
                    Toast.makeText(ProfileActivity.this, "Please enter new user age", Toast.LENGTH_SHORT).show();
                } else {

                    changeAge(json_user_email,editTextAge.getText().toString());
//                    Users user = new Users();
//                    user.setUser_name(editTextAge.getText().toString());
//                    user.setUser_email(json_user_email);
//
//                    Call<Users> call = api.updateage(user.getUser_name(),
//                            user.getUser_email()
//                    );
//
//                    call.enqueue(new Callback<Users>() {
//                        @Override
//                        public void onResponse(Call<Users> call, Response<Users> response) {
//                            if (response.isSuccessful()) {
//                                Toast.makeText(ProfileActivity.this, "Update successful", Toast.LENGTH_SHORT).show();
//                            }
//                        }
//
//                        @Override
//                        public void onFailure(Call<Users> call, Throwable t) {
//                            Log.d("onFailure", t.toString());
//                        }
//                    });
//                    tx1.setVisibility(View.INVISIBLE);
//                    tx2.setVisibility(View.INVISIBLE);
//                    tx3.setVisibility(View.INVISIBLE);
//                    tx4.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    private void changeName(String userEmail, String userName) {
        if (userEmail == null || userName == null) {
            Toast.makeText(this, "Invalid input!", Toast.LENGTH_LONG).show();
            return;
        }

        ProfileChangeNameRequest request = new ProfileChangeNameRequest(userName, userEmail);
        api.changeName(request).enqueue(new Callback<ProfileChangeNameResponse>() {
            @Override
            public void onResponse(Call<ProfileChangeNameResponse> call, Response<ProfileChangeNameResponse> response) {
                if (response.isSuccessful() && response.body() != null && response.body().isSuccess()) {

                    tx1.setVisibility(View.VISIBLE);
                    tx2.setVisibility(View.INVISIBLE);
                    tx3.setVisibility(View.INVISIBLE);
                    tx4.setVisibility(View.INVISIBLE);
                } else {
                    //error
                    Toast.makeText(ProfileActivity.this, "Login failed!", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<ProfileChangeNameResponse> call, Throwable t) {
                Toast.makeText(ProfileActivity.this, "Login failed!", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void changePassword(String userEmail, String userName) {
        if (userEmail == null || userName == null) {
            Toast.makeText(this, "Invalid input!", Toast.LENGTH_LONG).show();
            return;
        }

        ProfileChangePasswordRequest request = new ProfileChangePasswordRequest(userName, userEmail);
        api.changePassword(request).enqueue(new Callback<ProfileChangePasswordResponse>() {
            @Override
            public void onResponse(Call<ProfileChangePasswordResponse> call, Response<ProfileChangePasswordResponse> response) {
                if (response.isSuccessful() && response.body() != null && response.body().isSuccess()) {

                    tx1.setVisibility(View.INVISIBLE);
                    tx2.setVisibility(View.VISIBLE);
                    tx3.setVisibility(View.INVISIBLE);
                    tx4.setVisibility(View.INVISIBLE);
                } else {
                    //error
                    Toast.makeText(ProfileActivity.this, "Login failed!", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<ProfileChangePasswordResponse> call, Throwable t) {
                Toast.makeText(ProfileActivity.this, "Login failed!", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void changeCountry(String userEmail, String userName) {
        if (userEmail == null || userName == null) {
            Toast.makeText(this, "Invalid input!", Toast.LENGTH_LONG).show();
            return;
        }

        ProfileChangeCountryRequest request = new ProfileChangeCountryRequest(userName, userEmail);
        api.changeCountry(request).enqueue(new Callback<ProfileChangeCountryResponse>() {
            @Override
            public void onResponse(Call<ProfileChangeCountryResponse> call, Response<ProfileChangeCountryResponse> response) {
                if (response.isSuccessful() && response.body() != null && response.body().isSuccess()) {

                    tx1.setVisibility(View.INVISIBLE);
                    tx2.setVisibility(View.INVISIBLE);
                    tx3.setVisibility(View.VISIBLE);
                    tx4.setVisibility(View.INVISIBLE);
                } else {
                    //error
                    Toast.makeText(ProfileActivity.this, "Login failed!", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<ProfileChangeCountryResponse> call, Throwable t) {
                Toast.makeText(ProfileActivity.this, "Login failed!", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void changeAge(String userEmail, String userName) {
        if (userEmail == null || userName == null) {
            Toast.makeText(this, "Invalid input!", Toast.LENGTH_LONG).show();
            return;
        }

        ProfileChangeAgeRequest request = new ProfileChangeAgeRequest(userName, userEmail);
        api.changeAge(request).enqueue(new Callback<ProfileChangeAgeResponse>() {
            @Override
            public void onResponse(Call<ProfileChangeAgeResponse> call, Response<ProfileChangeAgeResponse> response) {
                if (response.isSuccessful() && response.body() != null && response.body().isSuccess()) {

                    tx1.setVisibility(View.INVISIBLE);
                    tx2.setVisibility(View.INVISIBLE);
                    tx3.setVisibility(View.INVISIBLE);
                    tx4.setVisibility(View.VISIBLE);
                } else {
                    //error
                    Toast.makeText(ProfileActivity.this, "Login failed!", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<ProfileChangeAgeResponse> call, Throwable t) {
                Toast.makeText(ProfileActivity.this, "Login failed!", Toast.LENGTH_LONG).show();
            }
        });
    }
}
