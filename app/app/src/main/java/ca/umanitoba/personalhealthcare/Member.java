
package ca.umanitoba.personalhealthcare;

import java.util.ArrayList;
import java.time.*;
import java.util.*;

public abstract class Member extends User{
    public Member(String id){
        super(id);
    }
    protected String getID(){return super.getID();}
    protected void setID(String id){super.setID(id);}
}
