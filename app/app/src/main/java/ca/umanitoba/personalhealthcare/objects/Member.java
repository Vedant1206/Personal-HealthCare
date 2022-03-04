
package ca.umanitoba.personalhealthcare.objects;

import ca.umanitoba.personalhealthcare.objects.User;

public abstract class Member extends User {
    public Member(String id){
        super(id);
    }
    protected String getID(){return super.getID();}
    protected void setID(String id){super.setID(id);}
}
