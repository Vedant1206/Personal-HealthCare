package ca.umanitoba.personalhealthcare;


public class Guest extends User{
    
    public Guest(String id) {
        super(id);        
    }
    
    protected String getID(){return super.getID();}
    protected void setID(String id){super.setID(id);}
}
