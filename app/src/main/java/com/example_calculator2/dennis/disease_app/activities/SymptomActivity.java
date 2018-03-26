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

import com.example_calculator2.dennis.disease_app.listView.DisplayListView1;
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

public class SymptomActivity extends AppCompatActivity {

    protected TextView tx1, tx2;
    protected EditText editTextSymptom;
    protected Button buttonSymptom, buton_back;
    private String Json, json_user_id,json_user_email,json_user_password;
    String [] str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symptom);

        json_user_id = getIntent().getExtras().getString("json_user_id");
        json_user_email = getIntent().getExtras().getString("json_user_email");
        json_user_password = getIntent().getExtras().getString("json_user_password");

        tx1 = findViewById(R.id.textView_symptom);
        editTextSymptom = findViewById(R.id.editText_symptom);
        buttonSymptom = findViewById(R.id.btn_symptom);
        buton_back = findViewById(R.id.btn_symptom_back);

        buttonSymptom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Objects.equals(editTextSymptom.getText().toString(),"")){
                    Toast.makeText(SymptomActivity.this, "Enter symptom", Toast.LENGTH_LONG).show();
                }else {
                    str = editTextSymptom.getText().toString().split(" ");
                    Integer i = str.length;

                    if (i==1){
                        new BackgroundWorker().execute(str[0]);
                        Toast.makeText(SymptomActivity.this, "Please wait....loading", Toast.LENGTH_LONG).show();
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Intent intent = new Intent(SymptomActivity.this, DisplayListView1.class);
                                intent.putExtra("Json_data", Json);
                                startActivity(intent);
                            }
                        }, 9000);
                    }
                    else if (i==2){
                        new BackgroundWorker2().execute(str[0],str[1]);
                        Toast.makeText(SymptomActivity.this, "Please wait....loading", Toast.LENGTH_LONG).show();
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Intent intent = new Intent(SymptomActivity.this, DisplayListView1.class);
                                intent.putExtra("Json_data", Json);
                                startActivity(intent);
                            }
                        }, 9000);}
                    else if (i==3){
                        new BackgroundWorker3().execute(str[0],str[1],str[2]);
                        Toast.makeText(SymptomActivity.this, "Please wait....loading", Toast.LENGTH_LONG).show();
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Intent intent = new Intent(SymptomActivity.this, DisplayListView1.class);
                                intent.putExtra("Json_data", Json);
                                startActivity(intent);
                            }
                        }, 9000);}
                    else if (i==4){
                        new BackgroundWorker4().execute(str[0],str[1],str[2],str[3]);
                        Toast.makeText(SymptomActivity.this, "Please wait....loading", Toast.LENGTH_LONG).show();
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Intent intent = new Intent(SymptomActivity.this, DisplayListView1.class);
                                intent.putExtra("Json_data", Json);
                                startActivity(intent);
                            }
                        }, 9000);}
                    else if (i==5){
                        new BackgroundWorker5().execute(str[0],str[1],str[2],str[3],str[4]);
                        Toast.makeText(SymptomActivity.this, "Please wait....loading", Toast.LENGTH_LONG).show();
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Intent intent = new Intent(SymptomActivity.this, DisplayListView1.class);
                                intent.putExtra("Json_data", Json);
                                startActivity(intent);
                            }
                        }, 9000);}
                        else{
                        Toast.makeText(SymptomActivity.this, "You have to fill less symptoms", Toast.LENGTH_LONG).show();
                    }

                }
            }
        });

        buton_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SymptomActivity.this, WelcomeActivity.class);
                intent.putExtra("json_user_id", json_user_id);
                intent.putExtra("json_user_email", json_user_email);
                intent.putExtra("json_user_password", json_user_password);
                startActivity(intent);
                SymptomActivity.this.finish();
            }
        });
    }

    private class BackgroundWorker extends AsyncTask<String, Void, String> {
        private AlertDialog alertDialog;
        private String result;

        @Override
        protected void onPreExecute() {
            alertDialog = new AlertDialog.Builder(SymptomActivity.this).create();
            alertDialog.setTitle("DiseaseActivity process");
        }

        @Override
        protected String doInBackground(String... params) {
            String login_url = "http://83.212.101.67:80/get_one_symptom.php";
            try {
                String word = params[0];
                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("word", "UTF-8") + "=" + URLEncoder.encode(word, "UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
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

    private class BackgroundWorker2 extends AsyncTask<String, Void, String> {
        private String result;

        @Override
        protected void onPreExecute() {
        }

        @Override
        protected String doInBackground(String... params) {
            String login_url = "http://83.212.101.67:80/get_two_symptom.php";
            try {
                String word = params[0];
                String word1 = params[1];
                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("word", "UTF-8") + "=" + URLEncoder.encode(word, "UTF-8") + "&" + URLEncoder.encode("word1", "UTF-8") + "=" + URLEncoder.encode(word1, "UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
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

    private class BackgroundWorker3 extends AsyncTask<String, Void, String> {
        private AlertDialog alertDialog;
        private String result;

        @Override
        protected void onPreExecute() {
            alertDialog = new AlertDialog.Builder(SymptomActivity.this).create();
            alertDialog.setTitle("DiseaseActivity process");
        }

        @Override
        protected String doInBackground(String... params) {
            String login_url = "http://83.212.101.67:80/get_three_symptom.php";
            try {
                String word = params[0];
                String word2 = params[1];
                String word3 = params[2];
                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("word", "UTF-8") + "=" + URLEncoder.encode(word, "UTF-8") + "&" + URLEncoder.encode("word2", "UTF-8") + "=" + URLEncoder.encode(word2, "UTF-8") + "&" + URLEncoder.encode("word3", "UTF-8") + "=" + URLEncoder.encode(word3, "UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
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

    private class BackgroundWorker4 extends AsyncTask<String, Void, String> {
        private AlertDialog alertDialog;
        private String result;

        @Override
        protected void onPreExecute() {
            alertDialog = new AlertDialog.Builder(SymptomActivity.this).create();
            alertDialog.setTitle("DiseaseActivity process");
        }

        @Override
        protected String doInBackground(String... params) {
            String login_url = "http://83.212.101.67:80/get_four_symptom.php";
            try {
                String word = params[0];
                String word2 = params[1];
                String word3 = params[2];
                String word4 = params[3];
                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("word", "UTF-8") + "=" + URLEncoder.encode(word, "UTF-8") + "&" + URLEncoder.encode("word2", "UTF-8") + "=" + URLEncoder.encode(word2, "UTF-8") + "&" + URLEncoder.encode("word3", "UTF-8") + "=" + URLEncoder.encode(word3, "UTF-8") + "&" + URLEncoder.encode("word4", "UTF-8") + "=" + URLEncoder.encode(word4, "UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
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

    private class BackgroundWorker5 extends AsyncTask<String, Void, String> {
        private AlertDialog alertDialog;
        private String result;

        @Override
        protected void onPreExecute() {
            alertDialog = new AlertDialog.Builder(SymptomActivity.this).create();
            alertDialog.setTitle("DiseaseActivity process");
        }

        @Override
        protected String doInBackground(String... params) {
            String login_url = "http://83.212.101.67:80/get_five_symptom.php";
            try {
                String word = params[0];
                String word2 = params[1];
                String word3 = params[2];
                String word4 = params[3];
                String word5 = params[4];
                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("word", "UTF-8") + "=" + URLEncoder.encode(word, "UTF-8") + "&" + URLEncoder.encode("word2", "UTF-8") + "=" + URLEncoder.encode(word2, "UTF-8") + "&" + URLEncoder.encode("word3", "UTF-8") + "=" + URLEncoder.encode(word3, "UTF-8") + "&" + URLEncoder.encode("word4", "UTF-8") + "=" + URLEncoder.encode(word4, "UTF-8") + "&" + URLEncoder.encode("word5", "UTF-8") + "=" + URLEncoder.encode(word5, "UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
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
