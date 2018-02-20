package com.example_calculator2.dennis.disease_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DisplayListView extends AppCompatActivity {

    String Json_string;
    JSONObject jsonObject;
    JSONArray jsonArray;
    PlayerAdapter playerAdapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_list_view);

        //Receive Json
        Json_string = getIntent().getExtras().getString("Json_data");
        listView = findViewById(R.id.listview);
        playerAdapter = new PlayerAdapter(this, R.layout.activity_row_layout);
        listView.setAdapter(playerAdapter);

        try {
            // Transform json to json object
            jsonObject = new JSONObject(Json_string);
            // Create array with name disease
            jsonArray = jsonObject.getJSONArray("disease");
            int count =0 ;
            String id,name,a2z,fact,description;
            while ( count < jsonArray.length()){
                // Put id , name and a2z into array
                JSONObject JO = jsonArray.getJSONObject(count);
                id = JO.getString("id");
                name = JO.getString("name");
                a2z = JO.getString("a2z");
                fact = JO.getString("fact");
                description = JO.getString("description");
                Players players = new Players(id,a2z,name,fact, description);
                playerAdapter.add(players);
                count++;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
