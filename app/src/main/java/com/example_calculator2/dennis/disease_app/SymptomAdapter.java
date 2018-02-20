package com.example_calculator2.dennis.disease_app;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

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
import java.util.ArrayList;
import java.util.List;

import static android.support.v4.content.ContextCompat.startActivity;

///**
// * Created by Dennis on 9/1/2018.
// */

class SymptomAdapter extends ArrayAdapter {

    private List list = new ArrayList();
    Button btn_description;
    String Json;

    SymptomAdapter(Context context, int resource) {
        super(context, resource);
    }

    @Override
    public void add(Object object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        View row;
        row = convertView;
        final PlayerHolder playerHolder;
        if (row == null){
            LayoutInflater layoutInflater = (LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.activity_row_layout1,parent,false);
            playerHolder = new PlayerHolder();
            playerHolder.column1 = row.findViewById(R.id.symptom_id);
            playerHolder.column2 = row.findViewById(R.id.symptom_a2z);
            playerHolder.column3 = row.findViewById(R.id.symptom_name);
            playerHolder.column4 = row.findViewById(R.id.symptom_fact);
            row.setTag(playerHolder);
        }else {
            playerHolder = (PlayerHolder)row.getTag();
        }
        final Symptoms symptoms = (Symptoms) this.getItem(position);
        assert symptoms != null;
        playerHolder.column1.setText((symptoms.getId()));
        playerHolder.column2.setText((symptoms.getA2z()));
        playerHolder.column3.setText((symptoms.getName()));
        playerHolder.column4.setText((symptoms.getFact()));

        return row;
    }

    private static class PlayerHolder{
        TextView column1,column2,column3,column4;
    }

//    private class BackgroundWorker extends AsyncTask<String, Void, String> {
//        private String result;
//
//        @Override
//        protected void onPreExecute() {
//
//        }
//
//        @Override
//        protected String doInBackground(String... params) {
//            String login_url = "http://192.168.1.73:8080/complete.php";
//            try {
//                String id = params[0];
//                URL url = new URL(login_url);
//                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
//                httpURLConnection.setRequestMethod("POST");
//                httpURLConnection.setDoOutput(true);
//                httpURLConnection.setDoInput(true);
//                OutputStream outputStream = httpURLConnection.getOutputStream();
//                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
//                String post_data = URLEncoder.encode("id", "UTF-8") + "=" + URLEncoder.encode(id, "UTF-8");
//                bufferedWriter.write(post_data);
//                bufferedWriter.flush();
//                bufferedWriter.close();
//                outputStream.close();
//                InputStream inputStream = httpURLConnection.getInputStream();
//                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
//                result = "";
//                String line = "";
//                while ((line = bufferedReader.readLine()) != null) {
//                    result += line;
//                }
//                bufferedReader.close();
//                inputStream.close();
//                httpURLConnection.disconnect();
//                return result;
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            return null;
//        }
//
//        @Override
//        protected void onPostExecute(String result) {
//            Json = result;
//        }
//
//        @Override
//        protected void onProgressUpdate(Void... values) {
//            super.onProgressUpdate(values);
//        }
//    }
}
