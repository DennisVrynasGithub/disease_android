package com.example_calculator2.dennis.disease_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DisplayListVIewQ4 extends AppCompatActivity {

    String Json_string;
    JSONObject jsonObject;
    JSONArray jsonArray;
    Result_Q4 playerAdapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_list_view_q4);

        //Receive Json
        Json_string = getIntent().getExtras().getString("Json_data");
        listView = findViewById(R.id.listview_q1);
        playerAdapter = new Result_Q4(this, R.layout.activity_row_q2);
        listView.setAdapter(playerAdapter);

        try {
            // Transform json to json object
            jsonObject = new JSONObject(Json_string);
            // Create array with name disease
            jsonArray = jsonObject.getJSONArray("disease");
            int count =0 ;
            String id_2,Date,Score;
            while ( count < jsonArray.length()){
                // Put id , name and a2z into array
                JSONObject JO = jsonArray.getJSONObject(count);
                id_2 = JO.getString("id_2");
                Date = JO.getString("Date");
                Score = JO.getString("Score");
                Results_Q players = new Results_Q(id_2,Date,Score);
                playerAdapter.add(players);
                count++;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
