package com.example_calculator2.dennis.disease_app;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
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

public class Login extends AppCompatActivity {

    Button btn1, btn3;
    EditText et1, et2;
    String base_url, json_user_id;
    Integer metavliti;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn1 = findViewById(R.id.btn_login2);
        btn3 = findViewById(R.id.btn_symptom);
        et1 = findViewById(R.id.et_user_email);
        et2 = findViewById(R.id.et_user_password);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new BackgroundWorker().execute(et1.getText().toString(),et2.getText().toString());
            }
        });
    }

    private class BackgroundWorker extends AsyncTask<String, Void, String> {
        private String result;

        @Override
        protected void onPreExecute() { }

        @Override
        protected String doInBackground(String... params) {
            base_url = "http://83.212.101.67:80/disease_login.php";

            try {
                String user_email = params[0];
                String user_password = params[1];
                URL url = new URL(base_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("user_email", "UTF-8") + "=" + URLEncoder.encode(user_email, "UTF-8") +  "&" + URLEncoder.encode("user_password", "UTF-8") + "=" + URLEncoder.encode(user_password, "UTF-8");
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


                return result.trim();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            json_user_id = result;
            if (Objects.equals(json_user_id, "0 results")){
                Toast.makeText(Login.this, result, Toast.LENGTH_SHORT).show();
            }else {
                try {
                    metavliti = Integer.parseInt(json_user_id);
                    if (metavliti > 0) {
                        Intent intent = new Intent(Login.this, Welcome.class);
                        intent.putExtra("json_user_id", json_user_id);
                        intent.putExtra("json_user_email", et1.getText().toString());
                        startActivity(intent);
                        Login.this.finish();
                    }
                }
                catch (NumberFormatException e){
                    Toast.makeText(Login.this, "Connection failed", Toast.LENGTH_SHORT).show();
                }
            }
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }
    }

}
