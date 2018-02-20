package com.example_calculator2.dennis.disease_app;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

public class Disease extends AppCompatActivity {

    protected TextView tx3,tx_result;
    protected EditText et3;
    protected Button btn,btn1;
    private String Json, json_user_id,json_user_email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disease);

        json_user_id = getIntent().getExtras().getString("json_user_id");
        json_user_email = getIntent().getExtras().getString("json_user_email");

        tx3 = findViewById(R.id.textView3);
        tx_result = findViewById(R.id.textView_result_disease);
        et3 = findViewById(R.id.editText3);
        btn = findViewById(R.id.btn_find_disease);
        btn1 = findViewById(R.id.btn_disease_back);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new BackgroundWorker().execute(et3.getText().toString());
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(Disease.this, DisplayListView.class);
                        intent.putExtra("Json_data", Json);
                        startActivity(intent);
                    }
                }, 9000);
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Disease.this, Welcome.class);
                intent.putExtra("json_user_id", json_user_id);
                intent.putExtra("json_user_email", json_user_email);
                startActivity(intent);
                Disease.this.finish();
            }
        });
    }

    private class BackgroundWorker extends AsyncTask<String, Void, String> {
        private AlertDialog alertDialog;
        private String result;

        @Override
        protected void onPreExecute() {
            alertDialog = new AlertDialog.Builder(Disease.this).create();
            alertDialog.setTitle("Disease process");
        }

        @Override
        protected String doInBackground(String... params) {
            String login_url = "http://192.168.1.73:8080/get_all_diseases.php";
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
//                    stringBuilder.append(line).append("\n");
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
//                String result_2 = stringBuilder.toString().trim();
                return result;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
//            alertDialog.setMessage(result);
//            alertDialog.show();
//            tx_result.setText(result);
            Json = result;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }
    }

}