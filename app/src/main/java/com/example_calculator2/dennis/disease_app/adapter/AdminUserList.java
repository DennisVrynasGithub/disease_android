package com.example_calculator2.dennis.disease_app.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example_calculator2.dennis.disease_app.R;
import com.example_calculator2.dennis.disease_app.activities.ResultAdminActivity;
import com.example_calculator2.dennis.disease_app.activities.ResultAdminQ1Activity;
import com.example_calculator2.dennis.disease_app.activities.ResultAdminQ3Activity;
import com.example_calculator2.dennis.disease_app.activities.ResultAdminQ4Activity;
import com.example_calculator2.dennis.disease_app.activities.ResultAdminQ5Activity;
import com.example_calculator2.dennis.disease_app.activities.ResultAdminQ6Activity;
import com.example_calculator2.dennis.disease_app.model.Admin_user_list_result;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dennis on 8/3/2018.
 */

public class AdminUserList extends ArrayAdapter {

    private List list = new ArrayList();
    private Context c;

    public AdminUserList(Context context, int resource) {
        super(context, resource);
        this.c = context;
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
        final AdminUserList.PlayerHolder playerHolder;
        if (row == null){
            LayoutInflater layoutInflater = (LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.activity_row_admin_user_list,parent,false);
            playerHolder = new AdminUserList.PlayerHolder();
            playerHolder.column1 = row.findViewById(R.id.tx_id);
            playerHolder.column2 = row.findViewById(R.id.tx_name);
            playerHolder.column5 = row.findViewById(R.id.btn_admin_user);
            playerHolder.column6 = row.findViewById(R.id.btn_admin_q1);
            playerHolder.column7 = row.findViewById(R.id.btn_admin_q3);
            playerHolder.column8 = row.findViewById(R.id.btn_admin_q4);
            playerHolder.column9 = row.findViewById(R.id.btn_admin_q5);
            playerHolder.column10 = row.findViewById(R.id.btn_admin_q6);
            row.setTag(playerHolder);
        }else {
            playerHolder = (AdminUserList.PlayerHolder)row.getTag();
        }
        final Admin_user_list_result symptoms = (Admin_user_list_result) this.getItem(position);
        assert symptoms != null;
        playerHolder.column1.setText((symptoms.getId()));
        playerHolder.column2.setText((symptoms.getName()));
        playerHolder.column5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(c.getApplicationContext(), ResultAdminActivity.class);
                intent.putExtra("Json_data", playerHolder.column1.getText().toString());
                c.startActivity(intent);


            }
        });
        playerHolder.column6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(c.getApplicationContext(), ResultAdminQ1Activity.class);
                intent.putExtra("Json_data", playerHolder.column1.getText().toString());
                c.startActivity(intent);


            }
        });
        playerHolder.column7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(c.getApplicationContext(), ResultAdminQ3Activity.class);
                intent.putExtra("Json_data", playerHolder.column1.getText().toString());
                c.startActivity(intent);


            }
        });
        playerHolder.column8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(c.getApplicationContext(), ResultAdminQ4Activity.class);
                intent.putExtra("Json_data", playerHolder.column1.getText().toString());
                c.startActivity(intent);


            }
        });
        playerHolder.column9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(c.getApplicationContext(), ResultAdminQ5Activity.class);
                intent.putExtra("Json_data", playerHolder.column1.getText().toString());
                c.startActivity(intent);


            }
        });
        playerHolder.column10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(c.getApplicationContext(), ResultAdminQ6Activity.class);
                intent.putExtra("Json_data", playerHolder.column1.getText().toString());
                c.startActivity(intent);


            }
        });
        return row;
    }

    private static class PlayerHolder{
        TextView column1,column2;
        Button column5,column6,column7,column8,column9,column10;
    }

}