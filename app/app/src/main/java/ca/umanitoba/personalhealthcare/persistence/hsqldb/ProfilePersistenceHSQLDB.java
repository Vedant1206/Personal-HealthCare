package ca.umanitoba.personalhealthcare.persistence.hsqldb;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ca.umanitoba.personalhealthcare.objects.NameExistsException;
import ca.umanitoba.personalhealthcare.persistence.ProfilePersistence;
import ca.umanitoba.personalhealthcare.objects.Profile;
import ca.umanitoba.personalhealthcare.persistence.hsqldb.HsqldbConnection;

public class ProfilePersistenceHSQLDB implements ProfilePersistence{
    //private final String dbPath;
    private final String insert;
    private final String update;
    private final String delete;
    private final String get;
    private final String check;
    private final HsqldbConnection setConnection;
    /**
     * The constructor of the ProfilePersistenceHSQLDB
     */
    public ProfilePersistenceHSQLDB(){
        setConnection = HsqldbConnection.getInstance();
        insert = "INSERT INTO profiles VALUES(?,?,?,?,?,?,?,?,?)"; // SQL queerry for inserting values
        update = "UPDATE profiles SET address = ?, height = ?, weight = ?, year = ?, month = ?, day = ?, sex = ? WHERE email = ? AND name = ?"; // SQL queerry for updating values
        delete = "DELETE FROM profiles WHERE email = ? AND name = ?"; // SQL queerry for deleting values
        get = "SELECT * FROM profiles WHERE email = ?"; // SQL queerry for getting values
        check = "SELECT * FROM profiles WHERE email = ? AND name = ?"; // SQL queerry for selecting values
    }

    /**
     * method to build the connection with HSQLDB
     * @return Connection connection with the dbscript from the given database path.
     * @throws SQLException

    private Connection connection() throws SQLException{
        return DriverManager.getConnection(dbPath, "SA", "");
    }*/

    /**
     * Method to create the profile instance with given result set.
     * @param rs
     * @return Profile single profile instance with given information fromo result set.
     * @throws SQLException
     */
    private Profile createProfileInstanceFromResultSet(final ResultSet rs) throws SQLException{
        final String email =  rs.getString("email");
        final String name = rs.getString("name");
        final String address = rs.getString("address");
        final int height = rs.getInt("height");
        final int weight = rs.getInt("weight");
        final int year = rs.getInt("year");
        final int month = rs.getInt("month");
        final int day = rs.getInt("day");
        final String sex = rs.getString("sex");

        return new Profile(email, name, address, height, weight, year, month, day, sex);
    }


    @Override
    public Profile insertProfile(Profile currentProfile) throws NameExistsException {
        try{
            final Connection connection = setConnection.getConnection();
            final PreparedStatement checkStatement = connection.prepareStatement(check);
            checkStatement.setString(1, currentProfile.getEmail());
            checkStatement.setString(2, currentProfile.getName());
            ResultSet resultSet = checkStatement.executeQuery(); // executeQuery will close the preparedStatement.
            if(!resultSet.first()){ // check same profile name is existing under a email. one email multiple name(profile) but no duplicate name
                throw new NameExistsException();
            }
            final PreparedStatement preparedStatement = connection.prepareStatement(insert);
            preparedStatement.setString(1,currentProfile.getEmail());
            preparedStatement.setString(2,currentProfile.getName());
            preparedStatement.setString(3,currentProfile.getAddress());
            preparedStatement.setInt(4,currentProfile.getHeight());
            preparedStatement.setInt(5,currentProfile.getWeight());
            preparedStatement.setInt(6,currentProfile.getYear());
            preparedStatement.setInt(7,currentProfile.getMonth());
            preparedStatement.setInt(8,currentProfile.getDay());
            preparedStatement.setString(9, currentProfile.getSex());

            preparedStatement.executeUpdate(); // executeQuery will close the preparedStatement.
            return currentProfile;

        } catch(final SQLException exception){
            System.err.println(exception.getMessage());
        }
        return currentProfile;
    }

    @Override
    public Profile updateProfile(Profile currentProfile){
        try{
            final Connection connection = setConnection.getConnection();
            final PreparedStatement preparedStatement = connection.prepareStatement(update);
            preparedStatement.setString(1, currentProfile.getAddress());
            preparedStatement.setInt(2, currentProfile.getHeight());
            preparedStatement.setInt(3, currentProfile.getWeight());
            preparedStatement.setInt(4, currentProfile.getYear());
            preparedStatement.setInt(5, currentProfile.getMonth());
            preparedStatement.setInt(6, currentProfile.getDay());
            preparedStatement.setString(7, currentProfile.getSex());
            preparedStatement.setString(8, currentProfile.getEmail());
            preparedStatement.setString(9, currentProfile.getName());

            preparedStatement.executeUpdate(); // executeQuery will close the preparedStatement.
            return currentProfile;
        } catch (SQLException exception){
            System.err.println(exception.getMessage());
        }
        return currentProfile;
    }

    @Override
    public void deleteProfile(Profile currentProfile){
        try{
            final Connection connection = setConnection.getConnection();
            final PreparedStatement preparedStatement = connection.prepareStatement(delete);
            preparedStatement.setString(1, currentProfile.getEmail());
            preparedStatement.setString(2, currentProfile.getName());
            preparedStatement.executeUpdate(); // executeQuery will close the preparedStatement.
        } catch (SQLException exception){
            System.err.println(exception.getMessage());
        }

    }

    @Override
    public List<Profile> getProfile(String email){
        final List<Profile> profiles = new ArrayList<Profile>();
        try{
            final Connection connection = setConnection.getConnection();
            final PreparedStatement preparedStatement = connection.prepareStatement(get);
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery(); // executeQuery will close the preparedStatement.
            while(resultSet.next()){
                final Profile profile = createProfileInstanceFromResultSet(resultSet);
                profiles.add(profile);
            }
            resultSet.close();

        } catch(SQLException exception){
            System.err.println(exception.getMessage());
        }
        return profiles;
    }
}
