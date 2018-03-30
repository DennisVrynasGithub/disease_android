package com.example_calculator2.dennis.disease_app.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.Patterns;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example_calculator2.dennis.disease_app.R;
import com.example_calculator2.dennis.disease_app.model.RegisterRequest;
import com.example_calculator2.dennis.disease_app.model.RegisterResponse;
import com.example_calculator2.dennis.disease_app.service.Api;
import com.example_calculator2.dennis.disease_app.utils.G;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RegisterActivity extends AppCompatActivity {

    TextView tx1,tx2;
    EditText editTextName, editTextPassword, editTextEmail, editTextCountry, editTextGender, editTextAge;
    Button button_register, button_back;
    String base_url;

    private Api api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        tx1 = findViewById(R.id.textView63);
        tx2 = findViewById(R.id.textView64);
        tx1.setVisibility(View.INVISIBLE);
        tx2.setVisibility(View.INVISIBLE);
        editTextName = findViewById(R.id.editText_user_name1);
        editTextPassword = findViewById(R.id.editText13);
        editTextEmail = findViewById(R.id.editText_user_email2);
        editTextCountry = findViewById(R.id.editText_country);
        editTextGender = findViewById(R.id.editText_gender);
        editTextAge = findViewById(R.id.editText_age);
        button_register = findViewById(R.id.bn_register2);
        button_back = findViewById(R.id.btn_register_back);
        base_url = "http://83.212.101.67:80/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(G.HOST_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(Api.class);

        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, DashboardActivity.class);
                startActivity(intent);
                RegisterActivity.this.finish();
            }
        });

        editTextGender.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    if (Objects.equals(editTextName.getText().toString(),"")) {
                        Toast.makeText(RegisterActivity.this, "Enter user name", Toast.LENGTH_LONG).show();
                    }else{
                        if (Objects.equals(editTextPassword.getText().toString(),"")){
                            Toast.makeText(RegisterActivity.this, "Enter user password", Toast.LENGTH_LONG).show();
                        }else{
                            if (Objects.equals(editTextEmail.getText().toString(),"")){
                                Toast.makeText(RegisterActivity.this, "Enter user email", Toast.LENGTH_LONG).show();
                            }else{
                                if (Objects.equals(editTextCountry.getText().toString(),"")){
                                    Toast.makeText(RegisterActivity.this, "Enter country", Toast.LENGTH_LONG).show();
                                }else{
                                    if (Objects.equals(editTextAge.getText().toString(),"")){
                                        Toast.makeText(RegisterActivity.this, "Enter user gender", Toast.LENGTH_LONG).show();
                                    }else{
                                        if (Objects.equals(editTextGender.getText().toString(),"")){
                                            Toast.makeText(RegisterActivity.this, "Enter user age", Toast.LENGTH_LONG).show();
                                        }else{

                                            register(
                                                    editTextName.getText().toString(),
                                                    editTextPassword.getText().toString(),
                                                    editTextEmail.getText().toString(),
                                                    editTextAge.getText().toString(),
                                                    editTextCountry.getText().toString(),
                                                    editTextGender.getText().toString()
                                            );

                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                return false;
            }
        });

        button_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             if (Objects.equals(editTextName.getText().toString(),"")) {
                 Toast.makeText(RegisterActivity.this, "Enter user name", Toast.LENGTH_LONG).show();
             }else{
                 if (Objects.equals(editTextPassword.getText().toString(),"")){
                     Toast.makeText(RegisterActivity.this, "Enter user password", Toast.LENGTH_LONG).show();
                 }else{
                     if (Objects.equals(editTextEmail.getText().toString(),"")){
                         Toast.makeText(RegisterActivity.this, "Enter user email", Toast.LENGTH_LONG).show();
                     }else{
                         if (Objects.equals(editTextCountry.getText().toString(),"")){
                             Toast.makeText(RegisterActivity.this, "Enter country", Toast.LENGTH_LONG).show();
                         }else{
                             if (Objects.equals(editTextGender.getText().toString(),"")){
                                 Toast.makeText(RegisterActivity.this, "Enter user gender", Toast.LENGTH_LONG).show();
                             }else{
                                 if (Objects.equals(editTextAge.getText().toString(),"")){
                                     Toast.makeText(RegisterActivity.this, "Enter user age", Toast.LENGTH_LONG).show();
                                 }else{

                                     register(
                                             editTextName.getText().toString(),
                                             editTextPassword.getText().toString(),
                                             editTextEmail.getText().toString(),
                                             editTextAge.getText().toString(),
                                             editTextCountry.getText().toString(),
                                             editTextGender.getText().toString()
                                             );

//                                     Users user = new Users();
//                                     user.setUser_name(editTextName.getText().toString());
//                                     user.setUser_password(editTextPassword.getText().toString());
//                                     user.setUser_email(editTextEmail.getText().toString());
//                                     user.setCountry(editTextCountry.getText().toString());
//                                     user.setAge(editTextAge.getText().toString());
//                                     user.setGendre(editTextGender.getText().toString());
//
//                                     Call<Users> call = service.insertUserRegister(user.getUser_name(),
//                                             user.getUser_password(),
//                                             user.getUser_email(),
//                                             user.getCountry(),
//                                             user.getAge(),
//                                             user.getGendre()
//                                     );
//
//                                     call.enqueue(new Callback<Users>() {
//                                         @Override
//                                         public void onResponse(Call<Users> call, Response<Users> response) {
//
//                                         }
//
//                                         @Override
//                                         public void onFailure(Call<Users> call, Throwable t) {
//                                             Log.d("onFailure", t.toString());
//                                             if (Objects.equals(t.toString(), "com.google.gson.stream.MalformedJsonException: Use JsonReader.setLenient(true) to accept malformed JSON at line 1 column 2 path $")) {
//                                                 tx1.setVisibility(View.VISIBLE);
//                                                 tx2.setVisibility(View.INVISIBLE);
//                                             } else {
//                                                 tx1.setVisibility(View.INVISIBLE);
//                                                 tx2.setVisibility(View.VISIBLE);
//                                             }
//                                         }
//                                     });
                                 }
                             }
                         }
                     }
                 }
             }
            }
        });
    }

    private void register(String userName, String userPassword,String userEmail, String userAge, String userCountry, String userGendre) {
        if (!Patterns.EMAIL_ADDRESS.matcher(userEmail).matches()) {
            Toast.makeText(this, "Invalid email!", Toast.LENGTH_LONG).show();
            return;
        }

        RegisterRequest request = new RegisterRequest(userEmail, userPassword, userName, userGendre, userCountry, userAge);
        api.register(request).enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                if (response.isSuccessful() && response.body() != null && response.body().isSuccess()) {
                    tx1.setVisibility(View.VISIBLE);
                    tx2.setVisibility(View.INVISIBLE);

                } else {
                    //error
//                    Toast.makeText(RegisterActivity.this, "Login failed!", Toast.LENGTH_LONG).show();
                    tx1.setVisibility(View.INVISIBLE);
                    tx2.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {
                Toast.makeText(RegisterActivity.this, "Register failed!", Toast.LENGTH_LONG).show();
            }
        });
    }
}
