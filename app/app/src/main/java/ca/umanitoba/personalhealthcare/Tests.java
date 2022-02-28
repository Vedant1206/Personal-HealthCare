package com.example.personal_health_care;

class Test{
    public static void main(String [] args){
        System.out.println("HELLO WORLD");
        String id = "USER1";
        String name = "SANGIL HAN";
        String address = "34 Nighthawk Bay";
        int height = 177;
        int weight = 70;
        int year = 1993;
        int month = 01;
        int day = 14;
        char sex = 'M';
        int age = 29;
        Patient user1 = new Patient(id, name, address, height, weight, year, month, day, sex);
        assert(user1.getID() == id);
        assert(user1.getName() == name);
        assert(user1.getAddress() == address);
        assert(user1.getHeight() == height);
        assert(user1.getWeight() == weight);
        assert(user1.getYear() == year);
        assert(user1.getMonth() == month);
        assert(user1.getDay() == day);
        assert(user1.getAge() == age);
        assert(user1.getSex() == sex);
        assert(user1.getNumProfiles() == 1);
        System.out.println("Checked Finished");
<<<<<<< HEAD
        System.out.println("Checking for the Profile creation and deletion");
        
=======
        System.out.println("Checking for the ")
>>>>>>> origin/main
    }
}

