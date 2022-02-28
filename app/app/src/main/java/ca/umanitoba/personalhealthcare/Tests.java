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
        System.out.println("Checking for the Profile creation and deletion");
        String name1 = "Jame";
        String address1 = "33 Wall St";
        int height1 = 180;
        int weight1 = 70;
        int year1 = 2001;
        int month1 = 11;
        int day1 = 10;
        char sex1 = 'M';
        user1.add_profile(name1, address1, height1, weight1, year1, month1, day1, sex1);
        assert(user1.getNumProfiles() == 2);
        boolean testing = user1.select_profile(name1);
        assert(testing);
        testing = user1.select_profile(name);
        assert(testing);
        String name2 = "Mike";
        testing = user1.select_profile(name2);
        assert(!testing);
        testing = user1.delete_profile(name);
        assert(testing);
        testing = user1.delete_profile(name);
        assert(!testing);
        testing = user1.delete_profile(name1);
        assert(testing);
        assert(user1.getNumProfiles() == 0);
        System.out.println("checking control");
        Control controls = new Control();
        controls.to_String();
        System.out.println("Done");
        
    }
}

