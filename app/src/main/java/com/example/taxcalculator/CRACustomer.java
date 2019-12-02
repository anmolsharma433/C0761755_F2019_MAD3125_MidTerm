package com.example.taxcalculator;

import android.os.Parcel;
import android.os.Parcelable;

public class CRACustomer{
    private String FirstName;
    private String LastName;
    private String FullName;
    private int Sin;
    private Double grossincome;
    private Double rrsp;

    //Constructor


    public CRACustomer(String firstName, String lastName,Double grossincome,Double rrsp) {
        this.FirstName = firstName;
        this.LastName = lastName;
        this.grossincome = grossincome;
        this.rrsp = rrsp;
    }

    //Functions
    //Function for fullname + formatting
    public String Fullname()
    {
        String fname = FirstName.substring(0,1).toUpperCase() + FirstName.substring(1);
        return LastName.toUpperCase() + "," + fname;
    }

    // Function for CPP calculation
    public Double CPP()
    {
        if (grossincome > 57400)
        {
            Double applicablegrossincome = grossincome - 57400;
            Double finalcpp = applicablegrossincome * 0.0510;
            return finalcpp;
        }
        else{
            Double finalcpp = grossincome * 0.0150;
            return finalcpp;
        }
    }

    // Function for Employer insurance
    public Double EI()
    {
        if(grossincome >53100)
        {
            Double applicablegrossincome = grossincome - 53100;
            Double EI = applicablegrossincome * 0.0162;
            return EI;

        }
        else{
            Double EI = grossincome * 0.0162;
            return  EI;
        }
    }





    //Getter And Setters

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public int getSin() {
        return Sin;
    }

    public void setSin(int sin) {
        Sin = sin;
    }

    public Double getGrossincome() {
        return grossincome;
    }

    public void setGrossincome(Double grossincome) {
        this.grossincome = grossincome;
    }

    public Double getRrsp() {
        return rrsp;
    }

    public void setRrsp(Double rrsp) {
        this.rrsp = rrsp;
    }
}
