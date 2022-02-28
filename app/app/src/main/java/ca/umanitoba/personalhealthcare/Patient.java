package com.example.personal_health_care;

import java.util.ArrayList;
import java.time.*;
import java.util.*;


public class Patient extends Member{
    private long num_profile = 0;
    ArrayList<Profile> profiles;
    Profile selected_profile;
    public Patient(String ID, String name, String address, int height, int weight,
                   int year, int month, int day,
                   char sex){
        super(ID);
        Profile new_profile = new Profile(name, address, height , weight, year, month, day, sex);
        profiles = new ArrayList<Profile>();
        profiles.add(new_profile);
        selected_profile = new_profile;
        num_profile++;
    }

    // ID handling
    protected String getID(){return super.getID();}
    protected void setID(String ID){super.setID(ID);}
    
    // Name handling
    protected String getName(){return selected_profile.getName();}
    protected void setName(String name){selected_profile.setName(name);}

    // Address handling
    protected String getAddress(){return selected_profile.getAddress();}
    protected void setAddress(String address){selected_profile.setAddress(address);}

    // DOB handling
    protected int getYear(){return selected_profile.getYears();}
    protected int getMonth(){return selected_profile.getMonth();}
    protected int getDay(){return  selected_profile.getDay();}
    protected int getAge(){return selected_profile.getAge();}
    protected void setYear(int year){selected_profile.setYear(year);}
    protected void setMonth(int month){selected_profile.setMonth(month);}
    protected void setDay(int day){selected_profile.setDay(day);}

    // height handling
    protected int getHeight(){return selected_profile.getHeight();}
    protected void setHeight(int height){selected_profile.setHeight(height);}

    // sex handling
    protected char getSex(){return selected_profile.getSex();}
    protected void setSex(char sex){selected_profile.setSex(sex);}

    // weight handling
    protected int getWeight(){return selected_profile.getWeight();}
    protected void setWeight(int weight){selected_profile.setWeight(weight);}

    // profile handling
    protected void add_profile(String name, String address, int height, int weight,
                               int year, int month, int day, char sex){
    
        Profile new_profile = new Profile(name, address, height, weight, year, month, day, sex);
        profiles.add(new_profile);
        selected_profile = new_profile;
        num_profile++;
    }
    protected boolean delete_profile(String profile_name){
        
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
        //TODO FINISHTHIS
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


    
    private class Profile{
        private String name;
        private String address;
        private int height;
        private int month;// DOB
        private int day;
        private int year;
        private int weight;
        private int age;
        private char sex;
        
        Profile(String name, String address, int height, 
                int weight, int year, int month, int day, char sex){
            this.name = name;
            this.address = address;
            this.height = height;
            this.weight = weight;
            this.year = year;
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
        
        // Getting all the fields
        String getName(){return this.name;}
        String getAddress(){return this.address;}
        int getHeight(){return this.height;}
        int getYears(){return this.year;}
        int getMonth(){return this.month;}
        int getDay(){return this.day;}
        char getSex(){return this.sex;}
        int getAge(){return this.age;}
        int getWeight(){return this.weight;}
        // Setting all the fields
        void setName(String name){this.name = name;}
        void setAddress(String address){this.address = address;}
        void setHeight(int height){this.height = height;}
        void setYear(int year){this.year = year;}
        void setMonth(int month){this.month = month;}
        void setDay(int day){this.day = day;}
        void setSex(char sex){this.sex = sex;}
        void setAge(int age){this.age = age;}
        void setWeight(int weight){this.weight = weight;}
    }
}

