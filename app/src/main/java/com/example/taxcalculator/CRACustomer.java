package com.example.taxcalculator;

import android.os.Parcel;
import android.os.Parcelable;

public class CRACustomer{
    private String FirstName;
    private String LastName;
    private String FullName;
    private int Sin;
    private Double grossincome;
    private Double rrspContributed;

    public CRACustomer(String firstName, String lastName, Double grossincome, Double rrspContributed) {
        this.FirstName = firstName;
        this.LastName = lastName;
        this.grossincome = grossincome;
        this.rrspContributed = rrspContributed;
    }
//Constructor




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
            Double finalcpp = 57400 * 0.0510;
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
        if(grossincome >= 53100)
        {
            Double EI = 53100 * 0.0162;
            return EI;

        }
        else{
            Double EI = grossincome * 0.0162;
            return  EI;
        }
    }

    //Function for Federal tax
    public Double federalTax()
    {
        Double FT;
        if(grossincome <= 12069)
        {
            return 0.0;
        }
        else if(grossincome <= 47630)
        {
            FT = grossincome * 0.015;
            return FT;
        }
        else if(grossincome <= 95259)
        {
            FT = grossincome * .2050;
            return FT;
        }
        else if (grossincome <= 147667)
        {
            FT = grossincome * .0026;
            return FT;
        }
        else if (grossincome <= 210371)
        {
            FT = grossincome * .0029;
            return FT;
        }
        else {
            FT = grossincome * .0033;
            return FT;
        }
    }

    // Function for Provincal tax
    public Double provincalTax()
    {
        Double PT;
        if(grossincome <= 10582)
        {
            return 0.0;
        }
        else if(grossincome <= 43906)
        {
            PT = grossincome * .0505;
            return PT;
        }
        else if(grossincome <= 87813)
        {
            PT = grossincome * .0915;
            return PT;
        }
        else if (grossincome <= 150000)
        {
            PT = grossincome * .1116;
            return PT;
        }
        else if (grossincome <= 220000)
        {
            PT = grossincome * .1216;
            return PT;
        }
        else {
            PT = grossincome * .1316;
            return PT;
        }
    }

    //Function for RRSP
    public Double rrsp()
    {
        Double maxrrsp = grossincome * .0018;
        Double CFrrsp;
        if(rrspContributed >= maxrrsp)
        {
            Double RRSP = maxrrsp - rrspContributed;
            CFrrsp = RRSP;
            return maxrrsp;
        }
        else {
            return rrspContributed;
        }
    }

    //Function for total taxable income
    public Double totalTAxableIncome()
    {
        Double TTI = grossincome - (CPP() + EI() + rrsp());
        return TTI;
    }

    //Dunction for Total tax payed
    public Double totaltaxPayed()
    {
        Double TTP = federalTax() + provincalTax();
        return  TTP;
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

    public Double getRrspContributed() {
        return rrspContributed;
    }

    public void setRrspContributed(Double rrspContributed) {
        this.rrspContributed = rrspContributed;
    }
}
