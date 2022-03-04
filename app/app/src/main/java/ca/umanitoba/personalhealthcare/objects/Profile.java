package ca.umanitoba.personalhealthcare.objects;

import java.time.*;
import java.util.*;

public class Profile{
    private String name;
    private String address;
    private char sex;
    private int weight;
    private int height;
    private int day;
    private int month;
    private int year;
    private int age;

    protected Profile(String name, String address,
            int height, int weight,
            int year, int month, int day,
            char sex){
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
    protected String getName(){return this.name;}
    protected String getAddress(){return  this.address;}
    protected int getHeight(){return this.height;}
    protected int getYear(){return this.year;}
    protected int getMonth(){return this.month;}
    protected int getDay(){return this.day;}
    protected int getAge(){return this.age;}
    protected int getWeight(){return this.weight;}

    // Setting methods for the fields of this class:
    protected void setName(String name){this.name = name;}
    protected void setAddress(String address){this.address = address;}
    protected void setHeight(int height){this.height = height;}
    protected void setYear(int year){this.year = year;}
    protected void setMonth(int month){this.month = month;}
    protected void setDay(int day){this.day = day;}
    protected void setSex(char sex){this.sex = sex;}
    protected void setAge(int age){this.age = age;}
    protected void setWeight(int weight){this.weight = weight;}
}
