package com.example.taxcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    private EditText fname;
    private EditText lanme;
    private EditText age;
    private EditText dob;
    private EditText sin;
    private EditText grossincome;
    private EditText crrsp;
    private RadioButton male;
    private RadioButton female;
    private RadioButton other;
    private Button result;

    //object od cra customer



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fname = findViewById(R.id.etFname);
        lanme = findViewById(R.id.etLname);
        dob = findViewById(R.id.etDate);
        sin = findViewById(R.id.etSin);
        grossincome = findViewById(R.id.etGrossIncome);
        crrsp = findViewById(R.id.etRrsp);
        male = findViewById(R.id.rbMale);
        female = findViewById(R.id.rbFemale);
        other = findViewById(R.id.rbOther);
        result = findViewById(R.id.btnResult);
        //final CRACustomer cra = new CRACustomer(fname.getText().toString(),lanme.getText().toString());
        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double Dgrossincome = Double.parseDouble(grossincome.getText().toString());
                Double Drssp = Double.parseDouble(crrsp.getText().toString());
                CRACustomer cra = new CRACustomer(fname.getText().toString(),lanme.getText().toString(),Dgrossincome,Drssp);
                System.out.println(cra.Fullname());
                System.out.println("Gross Income = " + cra.getGrossincome());
                System.out.println("EI = " + cra.EI());
                System.out.println(" rrsp = "+ cra.rrsp());
                //System.out.println("Federal tax = " + cra.federalTax());
                System.out.println("CPP = "+ cra.CPP());
                System.out.println(" total taxaable income "+cra.totalTAxableIncome());
                System.out.println("Provincal tax = " + cra.provincialTax());


                //System.out.println(" total tax payed "+cra.totaltaxPayed());



            }
        });
    }
}
