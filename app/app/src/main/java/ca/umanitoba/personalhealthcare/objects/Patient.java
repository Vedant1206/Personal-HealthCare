package ca.umanitoba.personalhealthcare.objects;

import java.util.ArrayList;


public class Patient extends Member {
    private long num_profile = 0;
    ArrayList<Profile> profiles;
    Profile selected_profile;
    private String email;
    private String password;

    public Patient(String id, String email, String password,
                   String name, String address, int height, int weight,
                   int year, int month, int day,
                   char sex){
        super(id);
        Profile new_profile = new Profile(name, address, height , weight, year, month, day, sex);
        profiles = new ArrayList<Profile>();
        profiles.add(new_profile);
        selected_profile = new_profile;
        this.email = email;
        this.password = password;
        num_profile++;
    }

    // Get methods for the fields of the Patient class
    protected String getID(){return super.getID();}
    protected String getEmail(){return this.email;}
    protected String getPassword(){return this.password;}

    // Set methods for the fields of the Patient class
    protected void setID(String id){super.setID(id);}
    protected void setEmail(String email){this.email = email;}
    protected void setPassword(String password){
        // method to change the password

        this.password = password;}


    // profile handling
    protected void add_profile(String name, String address, int height, int weight,
                               int year, int month, int day, char sex){
        // Method to add new profile to the list (profiles).
        Profile new_profile = new Profile(name, address, height, weight, year, month, day, sex);
        profiles.add(new_profile);
        selected_profile = new_profile;
        num_profile++;
    }

    protected boolean delete_profile(String profile_name){
        // method to delete the profile with given name.
        boolean deleted = true;
        if(selected_profile == null || num_profile == 0){return !deleted;}
        if(select_profile(profile_name)){
            profiles.remove(selected_profile);
            num_profile--;
            return deleted;
        }else{
            return !deleted;
        }

    }

    protected boolean select_profile(String profile_name){
        // method to select the profile with given name.
        boolean select = true;
        for(Profile checking : profiles){
            if(checking.getName().equals(profile_name)){
                selected_profile = checking;
                return select;
            }

        }
        return !select;
    }

    protected long getNumProfiles(){return this.num_profile;}
    // method to return the number of profile created under this Patient.

    // password Checking
    protected boolean checkPassword(String password){
        boolean checked = true;
        if(this.password.equals(password)){
            return checked;
        }else{
            return !checked;
        }

    }

    

}
