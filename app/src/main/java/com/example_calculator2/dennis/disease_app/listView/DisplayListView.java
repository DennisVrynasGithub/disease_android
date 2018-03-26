package com.example_calculator2.dennis.disease_app.listView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import com.example_calculator2.dennis.disease_app.R;
import com.example_calculator2.dennis.disease_app.adapter.PlayerAdapter;
import com.example_calculator2.dennis.disease_app.model.Players;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DisplayListView extends AppCompatActivity {

    String Json_string;
    JSONObject jsonObject;
    JSONArray jsonArray;
    PlayerAdapter playerAdapter;
    ListView listView;
    Button button_add_history_disease;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_list_view);

        //Receive Json
        Json_string = getIntent().getExtras().getString("Json_data");
        listView = findViewById(R.id.listview);
        button_add_history_disease = findViewById(R.id.button3);
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