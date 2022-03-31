//package ca.umanitoba.personalhealthcare.persistence.hsqldb;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.sql.PreparedStatement;
//
//
//public class Profile {
//
////    private HsqldbConnection hsqldbConnection;
////    private Connection connection;
//    private final String createProfileTable = "CREATE TABLE PROFILE( \r\n" +
//            "email VARCHAR(25) NOT NULL, \r\n" +
//            "name VARCHAR(25) NOT NULL,\r\n" +
//            "address VARCHAR(50) NOT NULL,\r\n" +
//            "sex VARCHAR(1) NOT NULL,\r\n" +
//            "height TINYINT NOT NULL,\r\n" +
//            "weight TINYINT NOT NULL,\r\n" +
//            "year SMALLINT NOT  NULL,\r\n" +
//            "month SMALLINT NOT NULL,\r\n" +
//            "day SMALLINT NOT NULL,\r\n" +
//            "PRIMARY KEY(email, name))";
//
//    private final String insertProfile = "INSERT INTO PROFILE" +
//            "(email, name, address, sex, height, weight, year, month, day)" +
//            "(?,?,?,?,?,?,?,?,?)";
//
//    String dbPath = "jdbc:hsqldb:file:" + System.getProperty("user.dir") + "/src/main/assets/db/data.db";
//
//    public static void main(String [] argv) throws SQLException{
//        Profile profiles = new Profile();
//        profiles.createTable();
//        profiles.insertProfile("email1@test.com", "name1", "Address1", "M", 200, 200, 2000,1,1);
//        profiles.insertProfile("email2@test.com", "name2", "Address2", "M", 190, 190, 2001,2,3);
//        profiles.insertProfile("email3@test.com", "name3", "Address3", "M", 180, 180, 2002,3,4);
//        profiles.insertProfile("email4@test.com", "name4", "Address4", "M", 170, 170, 2003,4,5);
//        profiles.insertProfile("email5@test.com", "name5", "Address5", "M", 160, 160, 2004,5,6);
//        profiles.insertProfile("email6@test.com", "name6", "Address6", "M", 150, 150, 2005,6,7);
//        profiles.insertProfile("email7@test.com", "name7", "Address7", "M", 140, 140, 2006,7,8);
//        profiles.insertProfile("email8@test.com", "name8", "Address8", "M", 130, 130, 2007,8,9);
//    }
//
//    public void createTable() throws  SQLException{
//        System.out.println("Creating Teable");
//        try
//        {
//            Class.forName("org.hsqldb.jdbc.JDBCDriver");
//            Connection connection = DriverManager.getConnection(dbPath, "SA", "");
//            Statement statement = connection.createStatement();
//            statement.execute(createProfileTable);
//
//        }catch (ClassNotFoundException exception){
//            exception.printStackTrace();
//        } catch (SQLException exception) {
//            exception.printStackTrace();
//        }
//        System.out.println("Table Created");
//    }
//
//    public void insertProfile(String email, String name, String address,
//                              String sex, int height, int weight,
//                              int year, int month, int day) throws SQLException {
//        System.out.println("INSERT_PROFILE_SQL");
//        try{
//            Class.forName("org.hsqldb.jdbc.JDBCDriver");
//            Connection connection = DriverManager.getConnection(dbPath, "SA", "");
//            PreparedStatement preparedStatment = connection.prepareStatement(insertProfile);
//            preparedStatment.setString(1, email);
//            preparedStatment.setString(2, name);
//            preparedStatment.setString(3, address);
//            preparedStatment.setString(4, sex);
//            preparedStatment.setInt(5, height);
//            preparedStatment.setInt(6, weight);
//            preparedStatment.setInt(7, year);
//            preparedStatment.setInt(8, month);
//            preparedStatment.setInt(9, day);
//
//            System.out.println(preparedStatment);
//            preparedStatment.executeUpdate();
//
//        }catch (ClassNotFoundException exception){
//            exception.printStackTrace();
//        } catch (SQLException exception){
//            exception.printStackTrace();
//        }
//        System.out.println("COMPLETE_INSERT_PROFILE_SQL");
//
//    }
//
////    public void updateProfile(){}
////    public void deleteRecord(){}
//
//
////    public static void printStackTrace(SQLException ex){
////        for (Throwable e:ex){
////            if(e instanceof SQLException){
////                e.printStackTrace(System.err);
////                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
////                System.err.println("Error Code: " + ((SQLException)e).getErrorCode());
////                System.err.println("Message: " + e.getMessage());
////                Throwable target = ex.getCause();
////                while(target != null){
////                    System.out.println("Cause: " + target);
////                    target = target.getCause();
////                }
////            }
////        }
////    }
//
//}
////
////(Connection connection = HsqldbConnection.getInstance().getConnection();
////        Statement statement = connection.createStatement();)
////(Connection connection = HsqldbConnection.getInstance().getConnection();
////        PreparedStatement preparedStatment = connection.prepareStatement(insertProfile);)

