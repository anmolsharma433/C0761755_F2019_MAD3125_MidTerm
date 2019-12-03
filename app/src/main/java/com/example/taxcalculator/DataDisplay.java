package com.example.taxcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.SingleLineTransformationMethod;
import android.widget.EditText;
import android.widget.TextView;

public class DataDisplay extends AppCompatActivity {

    private TextView fullname;
    private TextView Age;
    private TextView SIN;
    private TextView GrossIncome;
    private TextView EI;
    private TextView CPP;
    private TextView TotalTaxPayed;
    private TextView TotalTaxableIncome;
    private TextView FederalTax;
    private TextView ProvincialTax;
    private TextView RRSP;


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
