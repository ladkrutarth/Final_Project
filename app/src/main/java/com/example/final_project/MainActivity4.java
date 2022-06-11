package com.example.final_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity4 extends AppCompatActivity {

    private Button newbtn2;
    private Button submitBtn;
    private EditText studentName, studentPhoneNum, studentID, studentCity;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    StudentInfo studentInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        studentName = findViewById(R.id.editTextTextPersonName);
        studentPhoneNum = findViewById(R.id.editTextPhone2);
        studentID  = findViewById(R.id.editTextPhone3);
        studentCity = findViewById(R.id.editTextTextPostalAddress);

        firebaseDatabase = FirebaseDatabase.getInstance();

        databaseReference = firebaseDatabase.getReference("Student Info");

        studentInfo = new StudentInfo();

        submitBtn = findViewById(R.id.button5);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = studentName.getText().toString();
                String phone = studentPhoneNum.getText().toString();
                String id= studentID.getText().toString();
                String city = studentCity.getText().toString();

                if (TextUtils.isEmpty(name) && TextUtils.isEmpty(phone) && TextUtils.isEmpty(city)&& TextUtils.isEmpty(id)) {
                    // if the text fields are empty
                    // then show the below message.
                    Toast.makeText(MainActivity4.this, "Please add some data.", Toast.LENGTH_SHORT).show();
                } else {
                    // else call the method to add
                    // data to our database.
                    addDatatoFirebase(name, phone, city, id);
                }
            }
        });
        newbtn2 = (Button) findViewById(R.id.button6);
        newbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity5.class);
                startActivity(intent);
            }
        });
    }


    private void addDatatoFirebase(String name, String phone, String city, String id)
    {

        studentInfo.setName(name);
        studentInfo.setPhonenum(phone);
        studentInfo.setCityName(city);
        studentInfo.setID(id);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                databaseReference.setValue(studentInfo);

                Toast.makeText(MainActivity4.this,"DATA ADDED",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(MainActivity4.this,"Fail to add data"+error,Toast.LENGTH_SHORT).show();
            }
        });

    }
}