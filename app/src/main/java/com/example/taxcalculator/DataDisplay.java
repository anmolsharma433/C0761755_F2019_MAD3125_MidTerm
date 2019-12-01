package com.example.taxcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class DataDisplay extends AppCompatActivity {

    private EditText fullname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_display);
       fullname = findViewById(R.id.etFullname);


    }
}
