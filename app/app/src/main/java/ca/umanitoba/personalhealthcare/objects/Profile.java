package ca.umanitoba.personalhealthcare.objects;

import java.time.*;
import java.util.*;

public class Profile{
    private String email;
    private String name;
    private String address;
    private String sex;
    private int weight;
    private int height;
    private int day;
    private int month;
    private int year;
    private int age;

    //TODO: Fix this when we add LoginSession
    public Profile(String email, String name, String address,
            int height, int weight,
            int year, int month, int day,
            String sex){
        this.email = email;
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
    //TODO: Fix this when we add LoginSession
    public Profile(String name, String address,
                   int height, int weight,
                   int year, int month, int day,
                   String sex){
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
        LocalDate birth_date = LocalDate.of(this.year, this.month, this.day);
        LocalDate current_date = LocalDate.now();
        Period peroid = Period.between(birth_date, current_date);
        age = peroid.getYears();
        return age;
    }

    // Getting methods for the fields of this class:
    public String getName(){return this.name;}
    public String getAddress(){return  this.address;}
    public int getHeight(){return this.height;}
    public int getYear(){return this.year;}
    public int getMonth(){return this.month;}
    public int getDay(){return this.day;}
    public int getAge(){return this.age;}
    public int getWeight(){return this.weight;}
    public String getSex(){return this.sex;}
    public String getEmail(){return this.email;}

    // Setting methods for the fields of this class:
    public void setEmail(String email){this.email = email;}
    public void setName(String name){this.name = name;}
    public void setAddress(String address){this.address = address;}
    public void setHeight(int height){this.height = height;}
    public void setYear(int year){this.year = year;}
    public void setMonth(int month){this.month = month;}
    public void setDay(int day){this.day = day;}
    public void setSex(String sex){this.sex = sex;}
    public void setAge(int age){this.age = age;}
    public void setWeight(int weight){this.weight = weight;}
}
