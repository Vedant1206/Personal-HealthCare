package ca.umanitoba.personalhealthcare.persistence.hsqldb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ca.umanitoba.personalhealthcare.objects.Condition;
import ca.umanitoba.personalhealthcare.objects.Profile;
import ca.umanitoba.personalhealthcare.objects.Symptom;
import ca.umanitoba.personalhealthcare.persistence.DiseasePersistence;

public class DiseasePersistenceHSQLDB implements DiseasePersistence {
    private final String dbPath;
    private final String commonConditionsQuery;
    private final String symptomsByBodypartQuery;
    private final String conditionsBySymptomsQuery;

    public DiseasePersistenceHSQLDB(){
        this.dbPath = "jdbc:hsqldb:file:" + System.getProperty("user.dir") + "/src/main/assets/db/data.db";
        commonConditionsQuery = "SELECT * FROM profiles WHERE email = ?";
        symptomsByBodypartQuery = "SELECT * FROM profiles WHERE email = ?";
        conditionsBySymptomsQuery = "SELECT * FROM profiles WHERE email = ?";
    }

    private Connection connection() throws SQLException{
//        return DriverManager.getConnection(dbPath, "SA", "");
    }


    private  getFromResultSet(final ResultSet rs) throws SQLException{
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

    private Condition getConditionfromResultSet(final ResultSet rs) throws SQLException {
        final String name = rs.getString("name");
        final String sourceName = rs.getString("srcName");
        final String sourceLink = rs.getString("srcLink");

        return new Condition(name, sourceName, sourceLink);
    }

    private Symptom getSymptomfromResultSet(final ResultSet rs) throws SQLException {
        final String sympName = rs.getString("sympName");
        final String bodyPart = rs.getString("bodyPart");

        return new Symptom(sympName, bodyPart);
    }

    @Override
    public ArrayList<Condition> getCommonConditions() {
        final ArrayList<Condition> conditionList = new ArrayList<Condition>();


        //get common conditions for now

        try(final Connection connection = connection();){
            final PreparedStatement preparedStatement = connection.prepareStatement(commonConditionsQuery);
            preparedStatement.setString(1, );
            ResultSet resultSet = preparedStatement.executeQuery(); // executeQuery will close the preparedStatement.
            while(resultSet.next()){
//                final Profile profile = createProfileInstanceFromResultSet(resultSet);
//                profiles.add(profile);
            }
            resultSet.close();

        } catch(SQLException exception){
            System.err.println(exception.getMessage());
        }
        return conditionList;
    }

    @Override
    public ArrayList<Symptom> getSymptomsByBodyPart(String bodyPart) {
        return null;
    }

    @Override
    public ArrayList<Condition> getConditionsBySymptoms(ArrayList<Symptom> symptoms) {
        return null;
    }
}
