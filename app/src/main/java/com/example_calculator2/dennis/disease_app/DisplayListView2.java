package com.example_calculator2.dennis.disease_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DisplayListView2 extends AppCompatActivity {


    JSONObject jsonObject;
    JSONArray jsonArray;
    Admin_user_list admin_user_list;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_list_view2);

        //Receive Json
        String json_string = getIntent().getExtras().getString("Json_data");
        listView = findViewById(R.id.listview_admin);
        admin_user_list = new Admin_user_list(this,R.layout.activity_row_admin_user_list);
        listView.setAdapter(admin_user_list);
        try {
            // Transform json to json object
            jsonObject = new JSONObject(json_string);
            // Create array with name disease
            jsonArray = jsonObject.getJSONArray("disease");
            int count = 0;
            String user_id, user_name;
            while (count < jsonArray.length()) {
                // Put id , name and a2z into array
                JSONObject JO = jsonArray.getJSONObject(count);
                user_id = JO.getString("user_id");
                user_name = JO.getString("user_name");
                Admin_user_list_result symptoms = new Admin_user_list_result(user_id, user_name);
                admin_user_list.add(symptoms);
                count++;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
