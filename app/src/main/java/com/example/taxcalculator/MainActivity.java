package com.example.taxcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

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
    private RadioGroup Gender;
    final Calendar calendar = Calendar.getInstance();
    //DatePickerDialog datePickerDialog;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dob = findViewById(R.id.etDate);

        //https://www.bragitoff.com/2017/03/how-to-hide-the-status-bar-solved-android-studio/
        // Hide the status bar.
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        // https://stackoverflow.com/questions/14933330/datepicker-how-to-popup-datepicker-when-click-on-edittext
        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, monthOfYear);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                dateFormat();
            }
        };
        dob.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                new DatePickerDialog(MainActivity.this, date, calendar
                        .get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        fname = findViewById(R.id.etFname);
        lanme = findViewById(R.id.etLname);
        sin = findViewById(R.id.etSin);
        grossincome = findViewById(R.id.etGrossIncome);
        crrsp = findViewById(R.id.etRrsp);
        male = findViewById(R.id.rbMale);
        female = findViewById(R.id.rbFemale);
        other = findViewById(R.id.rbOther);
        result = findViewById(R.id.btnResult);
        Gender = findViewById(R.id.rbGroup);
        Gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int i) {

                if (male.isChecked())
                    Toast.makeText(MainActivity.this, "You Chose Male", Toast.LENGTH_SHORT).show();
                if (female.isChecked())
                    Toast.makeText(MainActivity.this, "You Chose Female", Toast.LENGTH_SHORT).show();
                if (other.isChecked())
                    Toast.makeText(MainActivity.this, "You Chose Others", Toast.LENGTH_SHORT).show();
            }
        });

        //Result Button
        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double Dgrossincome = Double.parseDouble(grossincome.getText().toString());
                Double Drssp = Double.parseDouble(crrsp.getText().toString());

                CRACustomer cra = new CRACustomer(fname.getText().toString(),lanme.getText().toString(),Dgrossincome,Drssp);
                Intent intent = new Intent(MainActivity.this,DataDisplay.class);
                intent.putExtra("data",cra);
                startActivity(intent);



            }
        });
    }
    private void dateFormat() {
        String myFormat = "dd/MMM/yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        //getAge(sdf.format(calendar.getTime()));
        dob.setText(sdf.format(calendar.getTime()));
        return;

    }



}
