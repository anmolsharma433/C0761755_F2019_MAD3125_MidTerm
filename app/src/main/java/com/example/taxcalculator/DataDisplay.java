package com.example.taxcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class DataDisplay extends AppCompatActivity {

    private EditText fullname;
    private EditText Age;
    private EditText SIN;
    private EditText GrossIncome;
    private EditText EI;
    private EditText CPP;
    private EditText TotalTaxPayed;
    private EditText TotalTaxableIncome;
    private EditText FederalTax;
    private EditText ProvincialTax;
    private EditText RRSP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_display);
       fullname = findViewById(R.id.etFullname);
       Age =findViewById(R.id.etDate);
       SIN = findViewById(R.id.etSin);
       GrossIncome = findViewById(R.id.etGrossIncome);
       EI = findViewById(R.id.etEI);
       CPP = findViewById(R.id.etCPP);
       TotalTaxPayed = findViewById(R.id.etTaxPayed);
       TotalTaxableIncome = findViewById(R.id.etTotalTaxableIncome);
       FederalTax = findViewById(R.id.etDFederaltax);
       ProvincialTax =findViewById(R.id.etRrsp);
       CRACustomer dataAll = getIntent().getParcelableExtra("data");
       fullname.setText(dataAll.getFirstName());



    }
}
