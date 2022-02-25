package com.example.personal_health_care;

import java.util.ArrayList;
import java.time.*;
import java.util.*;


public class Patient extends Member{
    long num_profile = 0;
    ArrayList<Profile> profiles;
    Profile selected_profile;
    public Patient(String ID, String name, String address, int height,
                   int year, int month, int day,
                   char sex){
        super(ID);
        Profile new_profile = new Profile(name, address, height, year, month, day, sex)
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


    // PROFILE HANDLING
    protected void add_profile(String name, String address, int height,
                               int year, int month, int day, char sex){
        //TODO: FINISH add profile
        Profile new_profile = new Profile(name, address, height, year, month, day, sex);
        profiles.add(new_profile);
        selected_profile = new_profile;
    }
    protected void delete_profile(Profile delete){
        //TODO: FINISH delete profile
        profiles.remove(delete);
    }
    protected void select_profile(long profile_num){

        boolean found = false;
        //TODO FINISHTHIS
        for(Profile checking : profiles || !found){
            if(checking.isIT(profile_num)){
                found = true;
                selected_profile = checking;
            }

        }
    }




    private class Profile{
        private long profile_num;
        private String name;
        private String address;
        private int height;
        private int month;// DOB
        private int day;
        private int year;
        private int weight;
        private int age;
        private char sex;
        Profile(String name, String address, int height, int weight,
                int year, int month, int day, char sex){
            this.name = name;
            this.address = address;
            this.height = height;
            this.weight = weight;
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
        boolean isIT(long profile_num){
            // function to check the profile number
            if(this.profile_num == profile_num) return true;
            return false;
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

