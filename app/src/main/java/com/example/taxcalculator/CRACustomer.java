package com.example.taxcalculator;

import android.os.Parcel;
import android.os.Parcelable;

import java.text.NumberFormat;
import java.util.Locale;

public class CRACustomer{
    private String FirstName;
    private String LastName;
    private String FullName;
    private int Sin;
    private Double grossincome;
    private Double rrspContributed;
    double mrssp;


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

    //Function for RRSP
    public Double rrsp()
    {
        Double maxrrsp = grossincome * .18;
        mrssp = maxrrsp;
        Double CFrrsp;
        if( rrspContributed > maxrrsp)
        {
            CFrrsp = maxrrsp - rrspContributed;
            System.out.println("WArning rrsp limit reached" + maxrrsp);
            return  CFrrsp;
        }
        else {
            return rrspContributed;
        }

    }

    //Function for total taxable income
    public Double totalTAxableIncome()
    {
        Double TTI = grossincome - (CPP() + EI() + mrssp);
        //totalTaxableAmount = TTI;
        return TTI;
    }

    //Function for Federal tax


    // Function for Provincial tax
    public double provincialTax(){
        double tempTaxableIncome = totalTAxableIncome();
        System.out.println(tempTaxableIncome);
       double tax = 0.0;
        if(tempTaxableIncome > 0.0 && tempTaxableIncome <= 10582.0)
        {

            tax = 0.0;
        }
        else if(tempTaxableIncome >= 10582.1 && tempTaxableIncome <= 43906.0)
        {
            tempTaxableIncome = tempTaxableIncome-10582;
            tax = (tempTaxableIncome * 5.05)/100;
        }
        else if(tempTaxableIncome >= 43906.0 && tempTaxableIncome <= 87813.0)
        {

            tempTaxableIncome = tempTaxableIncome-43906;
            double backtax = ((43906-10582)*5.05)/100;
            double temptax = (tempTaxableIncome * 9.15)/100;
            tax = backtax + temptax;
        }
        else if(tempTaxableIncome >= 87813.0 && tempTaxableIncome <= 150000.0)
        {

            tempTaxableIncome = tempTaxableIncome-87813.0;
            double backtax = ((43906-10582)*5.05)/100;
            double backtax2 = ((87813-43906)*9.15)/100;
            double temptax = (tempTaxableIncome * 11.16)/100;

            tax = backtax + backtax2 + temptax;
        }
        else if(tempTaxableIncome >= 150000.0 && tempTaxableIncome <= 220000.0)
        {

            tempTaxableIncome = tempTaxableIncome-150000.0;
            double backtax = ((43906-10582)*5.05)/100;
            double backtax2 = ((87813-43906)*9.15)/100;
            double backtax3 = ((150000-87813)*11.16)/100;
            double temptax = (tempTaxableIncome * 12.16)/100;

            tax = backtax + backtax2 + backtax3 + temptax;
        }
        else if(tempTaxableIncome >= 220000.0)
        {

            tempTaxableIncome = tempTaxableIncome-220000;
            double backtax = ((43906-10582)*5.05)/100;
            double backtax2 = ((87813-43906)*9.15)/100;
            double backtax3 = ((150000-87813)*11.16)/100;
            double backtax4 = ((220000-150000)*12.16)/100;

            double temptax = (tempTaxableIncome * 13.16)/100;

            tax = backtax + backtax2 + backtax3 + backtax4 + temptax;
        }
        return tax;
    }


    //Dunction for Total tax payed
    public Double totaltaxPayed()
    {
        Double TTP = provincialTax();
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

    //String formatter
    public String amountFomatter()
    {
        NumberFormat nf = NumberFormat.getInstance(new Locale("en", "US"));
        String val = nf.format("$"+this);

        return val;

    }
}
