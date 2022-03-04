package ca.umanitoba.personalhealthcare;

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

    Profile(String name, String address,
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
    String getName(){return this.name;}
    String getAddress(){return  this.address;}
    int getHeight(){return this.height;}
    int getYear(){return this.year;}
    int getMonth(){return this.month;}
    int getDay(){return this.day;}
    int getAge(){return this.age;}
    int getWeight(){return this.weight;}

    // Setting methods for the fields of this class:
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