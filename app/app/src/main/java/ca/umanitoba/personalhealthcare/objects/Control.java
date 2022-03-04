package ca.umanitoba.personalhealthcare.objects;

/**
=======

>>>>>>> 77999061a3db5a87a5bc5bf7fb7d34641374c807
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
        return null;
    }
    public boolean check_password(String password){
        if(selected_member == null){
            // case the none of the member is selected.
            System.out.println("Select member first");
        }
        //if()
        return false;
    }

}*/
