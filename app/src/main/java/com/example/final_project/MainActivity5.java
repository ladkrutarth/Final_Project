package com.example.final_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class MainActivity5 extends AppCompatActivity {

    private Button newBtn;

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        listView = (ListView) findViewById(R.id.itemView);
        
        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("iphone6s");
        arrayList.add("iphone 6s Pulse");
        arrayList.add("iphone 7");
        arrayList.add("iphone 8");
        arrayList.add("iphone x");
        arrayList.add("iphone 11");
        arrayList.add("iphone 11 pro");
        arrayList.add("iphone 12 ");
        arrayList.add("iphone 12 pro");
        arrayList.add("Macbook Air");
        arrayList.add("Macbook pro 13 inch");
        arrayList.add("Macbook Pro 16 inch");


      ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1,arrayList);
        listView.setAdapter(arrayAdapter);



        newBtn = (Button) findViewById(R.id.button);
        newBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity6.class);
                startActivity(intent);
            }
        });

    }
}