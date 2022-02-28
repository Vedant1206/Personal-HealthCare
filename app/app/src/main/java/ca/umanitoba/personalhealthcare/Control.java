package main.java.ca.umanitoba.personalhealthcare;

public class Control {
    private Member selected_member = null;
    public Control(){}
    public Control(Patient user1){
        this.selected_member = user1;
    }
    public String to_String(){
        if(selected_member == null){
            //case the none of the member is selected.
            System.out.println("Select member first");
            
        }
    }
    public boolean check_password(String password){
        if(selected_member == null){
            // case the none of the member is selected.
            System.out.println("Select member first");
        }
        if()
    }

}
