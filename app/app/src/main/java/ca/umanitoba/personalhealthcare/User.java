package ca.umanitoba.personalhealthcare;

public abstract class User {
    protected String ID;
    public User(String ID){
        this.ID = ID;
    }
    protected String getID(){return this.ID;}
    protected void setID(String ID){this.ID = ID;}
}