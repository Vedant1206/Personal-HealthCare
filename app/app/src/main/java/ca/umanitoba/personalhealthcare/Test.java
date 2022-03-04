

public class Test{
    public static void main(String [] args){
        System.out.println("Hello World");
        test_User_Creation();
    }
    public static void test_User_Creation(){
        // create the user.
        System.out.println("Testing User class:");
        String id = "User1";
        String name = "Name of User1";
        String email = "Email of User1";
        String password = "0000";
        String address = "Address of User1";
        int height = 180;
        int weight = 70;
        int year = 2000;
        int month = 01;
        int day = 01;
        int age = 22;
        char sex = 'M';
        Patient user1 = new Patient(id, password,
                name, address,
                height, weight,
                year, month, day,
                sex);
        // check the fields of user1
        System.out.println("Checking the field of User1");
        assert(user1.getID() == id);
        assert(user1.getName() == name);
        assert(user1.getEmail() == email);
        assert(user1.getPassword() == password);
        assert(user1.getHeight() == height);
        assert(user1.getWeight() == weight);
        assert(user1.getYear() == year);
        assert(user1.getMonth() == month);
        assert(user1.getAge() == age);
        assert(user1.getSex() == sex);
        System.out.println("test_User_Creation is Done");
    }
    public static void test_Profile_creation(){}
    public static void test_Profile_add(){}
    public static void test_Profile_deletion(){}

}