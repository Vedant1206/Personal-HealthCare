package com.example.personal_health_care;

public class Guest extends User{
    
    public Guest(String ID) {
        super(ID);        
    }
    
    protected String getID(){return this.ID;}
    protected void setID(String ID){this.ID = ID;}
}