package ca.umanitoba.personalhealthcare.persistence.hsqldb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ca.umanitoba.personalhealthcare.objects.Condition;
import ca.umanitoba.personalhealthcare.objects.Symptom;
import ca.umanitoba.personalhealthcare.persistence.DiseasePersistence;

public class DiseasePersistenceHSQLDB implements DiseasePersistence {
    private final String dbPath;
    private final String commonConditionsQuery;
    private final String symptomsByBodypartQuery;

    public DiseasePersistenceHSQLDB(){
        this.dbPath = "jdbc:hsqldb:file:" + System.getProperty("user.dir") + "/src/main/assets/db/data.db";
        commonConditionsQuery = "SELECT * FROM CONDITION WHERE commonness > 0";
        symptomsByBodypartQuery = "SELECT * FROM SYMPTOM WHERE bodyPart = ?";
    }

    private Connection connection() throws SQLException{
        return DriverManager.getConnection(dbPath, "SA", "");
    }


    @Override
    public ArrayList<Condition> getCommonConditions() {
        final ArrayList<Condition> conditionList = new ArrayList<Condition>();

        try(final Connection c = connection();){
            ResultSet resultSet = c.prepareStatement(commonConditionsQuery).executeQuery(); // executeQuery will close the preparedStatement.

            while(resultSet.next()){
                conditionList.add(getConditionFromResultSet(resultSet));
            }
            resultSet.close();

        } catch(SQLException exception){
            System.err.println(exception.getMessage());
        }
        return conditionList;
    }

    @Override
    public ArrayList<Symptom> getSymptomsByBodyPart(String bodyPart) {
        final ArrayList<Symptom> symptomList = new ArrayList<Symptom>();

        try(final Connection c = connection();){
            final PreparedStatement preparedStatement = c.prepareStatement(symptomsByBodypartQuery);
            preparedStatement.setString(1, bodyPart);
            ResultSet resultSet = preparedStatement.executeQuery(); // executeQuery will close the preparedStatement.

            while(resultSet.next()){
                symptomList.add(getSymptomFromResultSet(resultSet));
            }
            resultSet.close();

        } catch(SQLException exception){
            System.err.println(exception.getMessage());
        }
        return symptomList;
    }

    @Override
    public ArrayList<Condition> getConditionBySymptoms(ArrayList<Symptom> symptoms) {
        return null;
    }

    @Override
    public Condition getConditionByName(String condName) {
        return null;
    }

    private Condition getConditionFromResultSet(final ResultSet rs) throws SQLException {
        final String name = rs.getString("name");
        final String sourceName = rs.getString("srcName");
        final String sourceLink = rs.getString("srcLink");
        final String description = rs.getString("description");

        return new Condition(name, sourceName, sourceLink, description);
    }

    private Symptom getSymptomFromResultSet(final ResultSet rs) throws SQLException {
        final String sympName = rs.getString("sympName");
        final String bodyPart = rs.getString("bodyPart");

        return new Symptom(sympName, bodyPart);
    }

}
