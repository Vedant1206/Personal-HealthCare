package ca.umanitoba.personalhealthcare.objects;

public abstract class User {
    protected String id;
    public User(String id){
        this.id = id;
    }
    protected String getID(){return this.id;}
    protected void setID(String ID){this.id = id;}
}
