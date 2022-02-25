package com.example.personal_health_care;

import java.util.ArrayList;
import java.time.*;
import java.util.*;


public class Patient extends Member{
    ArrayList<Profile> profiles;
    public Patient(String ID, String name, String addres, int height,
                   int year, int month, int day,
                   char sex){
        super(ID);
        Profile new_profile = new Profile(name, addres, height, year, month, day, sex)
        profiles = new ArrayList<Profile>();
        profiles.add(new_profile);
    }
    protected String getID(){return super.getID();}
    protected void setID(String ID){super.setID(ID);}
    protected void add_profile(Profile new_profile){
        //TODO: FINISH add profile
        profiles.add(new_profile);
    }
    protected void delete_profile(Profile delete){
        //TODO: FINISH delete profile
        profiles.remove(delete);
    }
    protected String getID(){return super.getID();}
    protected void setID(String ID){super.setID(ID);}
    
    private class Profile{
        private String name;
        private String addres;
        private int height;
        private int month;// DOB
        private int day;
        private int year;
        private int age;
        private char sex;
        Profile(String name, String addres, int height, int year, int month, int day, char sex){
            this.name = name;
            this.addres = addres;
            this.height = height;
            this.month = month;
            this.day = day;
            this.sex = sex;
            this.age = cal_age();
        }
        int cal_age(){
            int age;
            LocalDate birth_date = LocalDate.of(year, month, day);
            LocalDate current_date = LocalDate.now();
            Period period = Period.between(birth_date, current_date);
            age = period.getYears();
            return age;
        }

    }
}

