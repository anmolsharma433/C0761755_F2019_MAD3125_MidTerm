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
    double totalTaxableAmount;
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

    //Function for total taxable income
    public Double totalTAxableIncome()
    {
        Double TTI = grossincome - (CPP() + EI() + mrssp);
        totalTaxableAmount = TTI;
        return TTI;
    }

    //Function for Federal tax
    public Double federalTax()
    {
        Double FT;
        double fedtax=0.0;

        double firstSlabPerc = .15;
        double firstSlab = 35561;

        double secondSlabPerc = .2050;
        double secondSlab = 47628.99;

        double thirdSlabPerc = .0026;
        double thirdSlab = 52407.99;

        double fourthSlabPerc = .0029;
        double fourthSlab = 60703.99;

        double finalSlab = 0.01;
        double finalSlabPerc = .0033;
        totalTaxableAmount = totalTAxableIncome() -12069.00;
        if(totalTaxableAmount <= firstSlab)
        {
            FT = firstSlab * 0.015;
            totalTaxableAmount = totalTaxableAmount -firstSlab;
            return Double.valueOf((String.format("%.0f",FT)));
        }
        else if(totalTaxableAmount <= secondSlab)
        {
            FT = secondSlab * .2050;
            totalTaxableAmount = totalTaxableAmount - secondSlab;
            return Double.valueOf((String.format("%.0f",FT)));
        }
        else if (totalTaxableAmount <= thirdSlab)
        {
            FT =  thirdSlab * .0026;
            totalTaxableAmount = totalTaxableAmount - thirdSlab;
            return Double.valueOf((String.format("%.0f",FT)));
        }
        else if (totalTaxableAmount <= fourthSlab)
        {
            FT = fourthSlab * .0029;
            totalTaxableAmount = totalTaxableAmount - fourthSlab;
            return Double.valueOf((String.format("%.0f",FT)));
        }
        else {
            FT = finalSlab * .0033;
            return Double.valueOf((String.format("%.0f",FT)));
        }
    }

    // Function for Provincal tax
    public Double provincalTax()
    {
        double ProvisionalTax = 0.0;

        double firstSlabPerc=5.05;
        double firstSlab=33324;

        double secondSlabPerc=.0915;
        double secondSlab=43907;

        double thirdSlabPerc=11.16;
        double thirdSlab=62187;

        double fourthSlabPerc=12.16;
        double fourthSlab=70000;

        double finalSlab=0.01;
        double finalSlabPerc=13.16;
        totalTaxableAmount=totalTaxableAmount - 10582.00;
        if(totalTaxableAmount <= firstSlab) {
            ProvisionalTax = firstSlab  * .0505 ;
            totalTaxableAmount = totalTaxableAmount - firstSlab;
            return  ProvisionalTax;
        }

        else if(totalTaxableAmount <= secondSlab) {
            System.out.println(totalTaxableAmount);
            ProvisionalTax = secondSlab * .0915;
            System.out.println(ProvisionalTax);
            totalTaxableAmount = totalTaxableAmount - secondSlab;
            return  ProvisionalTax;
        }
        else if(totalTaxableAmount <= thirdSlab) {
            ProvisionalTax = thirdSlab * .1116;
            totalTaxableAmount = totalTaxableAmount - thirdSlab;
            return  ProvisionalTax;
        }
        else if(totalTaxableAmount <= fourthSlab) {
            ProvisionalTax = fourthSlab * .1216;
            totalTaxableAmount = totalTaxableAmount - fourthSlab;
            return  ProvisionalTax;
        }
        else if(totalTaxableAmount <= finalSlab) {
            ProvisionalTax = finalSlab * .1316;
            return  ProvisionalTax;
        }
        return ProvisionalTax;
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
