package com.example.taxcalculator;

public class CRACustomer{
    private String FirstName;
    private String LastName;
    private String FullName;
    private int Sin;
    private float grossincome;
    private float rrsp;

    //Constructor


    public CRACustomer(String firstName, String lastName,float rrsp) {
        this.FirstName = firstName;
        this.LastName = lastName;
        this.rrsp = rrsp;
    }

    //Functions
    //Function for fullname + formatting
    public String Fullname()
    {
        String fname = FirstName.substring(0,1).toUpperCase() + FirstName.substring(1);
        return LastName.toUpperCase() + "," + fname;
    }

    // Function for rrsp calculation
    public float rrsp()
    {
        float carryforwardrrsp
        float expectedrrsp = (grossincome * (18/100));
        float maxrrsp =18000;
        if (expectedrrsp > 18000)
        {
            carryforwardrrsp = expectedrrsp - maxrrsp;
            return carryforwardrrsp;
        }
        return rrspcalculation;
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

    public float getGrossincome() {
        return grossincome;
    }

    public void setGrossincome(float grossincome) {
        this.grossincome = grossincome;
    }

    public float getRrsp() {
        return rrsp;
    }

    public void setRrsp(float rrsp) {
        this.rrsp = rrsp;
    }
}
