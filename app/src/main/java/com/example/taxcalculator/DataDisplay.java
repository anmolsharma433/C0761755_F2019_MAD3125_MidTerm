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
      // Age =findViewById(R.id.etDate);
       SIN = findViewById(R.id.etDsin);
       GrossIncome = findViewById(R.id.etDGrossIncome);
       EI = findViewById(R.id.etEI);
       CPP = findViewById(R.id.etCPP);
       TotalTaxPayed = findViewById(R.id.etTaxPayed);
       TotalTaxableIncome = findViewById(R.id.etTotalTaxableIncome);
       FederalTax = findViewById(R.id.etDFederaltax);
       ProvincialTax =findViewById(R.id.etProvincalTax);
       RRSP = findViewById(R.id.etDRrsp);
       //getting the parceable
       CRACustomer dataAll = getIntent().getParcelableExtra("data");

       //assigning the value
       fullname.setText(dataAll.Fullname());
       SIN.setText(String.valueOf(dataAll.getSin()));
       GrossIncome.setText(String.valueOf(dataAll.getGrossincome()));
        EI.setText(String.valueOf(dataAll.EI()));
        CPP.setText(String.valueOf(dataAll.CPP()));
        RRSP.setText(String.valueOf(dataAll.rrsp()));
        TotalTaxPayed.setText(String.valueOf(dataAll.totalTAxableIncome()));
        FederalTax.setText(String.valueOf(dataAll.federalTax()));
        ProvincialTax.setText(String.valueOf(dataAll.provincialTax()));




    }
}
