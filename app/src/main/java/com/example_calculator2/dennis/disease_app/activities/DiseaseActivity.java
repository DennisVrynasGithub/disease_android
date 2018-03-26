package com.example_calculator2.dennis.disease_app.activities;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example_calculator2.dennis.disease_app.listView.DisplayListView;
import com.example_calculator2.dennis.disease_app.R;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Objects;

public class DiseaseActivity extends AppCompatActivity {

    protected TextView tx3;
    protected EditText editeTextDisease;
    protected Button button_disease, button_back;
    private String Json, json_user_id,json_user_email,json_user_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disease);

        json_user_id = getIntent().getExtras().getString("json_user_id");
        json_user_email = getIntent().getExtras().getString("json_user_email");
        json_user_password = getIntent().getExtras().getString("json_user_password");

        tx3 = findViewById(R.id.textView3);
        editeTextDisease = findViewById(R.id.editText3);
        button_disease = findViewById(R.id.btn_find_disease);
        button_back = findViewById(R.id.btn_disease_back);

        button_disease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Objects.equals(editeTextDisease.getText().toString(),"")){
                    Toast.makeText(DiseaseActivity.this, "Enter disease", Toast.LENGTH_LONG).show();
                }else {
                    new BackgroundWorker().execute(editeTextDisease.getText().toString());
                    Toast.makeText(DiseaseActivity.this, "Please wait....loading", Toast.LENGTH_LONG).show();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent intent = new Intent(DiseaseActivity.this, DisplayListView.class);
                            intent.putExtra("Json_data", Json);
                            startActivity(intent);
                        }
                    }, 9000);
                }
            }
        });

        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DiseaseActivity.this, WelcomeActivity.class);
                intent.putExtra("json_user_id", json_user_id);
                intent.putExtra("json_user_email", json_user_email);
                intent.putExtra("json_user_password", json_user_password);
                startActivity(intent);
                DiseaseActivity.this.finish();
            }
        });
    }

    private class BackgroundWorker extends AsyncTask<String, Void, String> {
        private AlertDialog alertDialog;
        private String result;

        @Override
        protected void onPreExecute() {
            alertDialog = new AlertDialog.Builder(DiseaseActivity.this).create();
            alertDialog.setTitle("DiseaseActivity process");
        }

        @Override
        protected String doInBackground(String... params) {
            String login_url = "http://83.212.101.67:80/get_all_diseases.php";
//            String login_url = "http://83.212.101.67:8010/index/getDisease";
            try {
                String name = params[0];
                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("name", "UTF-8") + "=" + URLEncoder.encode(name, "UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                StringBuilder stringBuilder = new StringBuilder();
                result = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            Json = result;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }
    }

}
