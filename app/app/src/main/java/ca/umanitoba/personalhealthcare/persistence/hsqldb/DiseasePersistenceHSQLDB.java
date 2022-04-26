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
    private final String conditionBySymptoms;
    private final String conditionByName;

    public DiseasePersistenceHSQLDB(){
        this.dbPath = "jdbc:hsqldb:file:" + System.getProperty("user.dir") + "/src/main/assets/db/data.db";
        commonConditionsQuery = "SELECT * FROM CONDITION WHERE commonness > 0";
        symptomsByBodypartQuery = "SELECT * FROM SYMPTOM WHERE bodyPart = ?";
        conditionBySymptoms = "SELECT * FROM CONDITION_SYMPTOMS WHERE sympName = ?";
        conditionByName = "SELECT * FROM CONDITION WHERE name = ?";
    }

    /**
     * Setting up the connection
     */
    private Connection connection() throws SQLException{
        return DriverManager.getConnection(dbPath, "SA", "");
    }


    /**
     * Gets every CommonCondition from the DB. Commonness is already entered into the db so
     * this method requires no complex code. It just searches for the values
     */
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

    /**
     * Gets all Symptoms from the DB based on the given bodyPart
     * @param bodyPart String
     * @return Arraylist of Symptoms
     */
    @Override
    public ArrayList<Symptom> getSymptomsByBodyPart(String bodyPart) {
        final ArrayList<Symptom> symptomList = new ArrayList<Symptom>();

        try(final Connection c = connection();){
            final PreparedStatement preparedStatement = c.prepareStatement(symptomsByBodypartQuery);
            preparedStatement.setString(1, bodyPart);
            ResultSet resultSet = preparedStatement.executeQuery(); // executeQuery will close the preparedStatement.

            //getting all the Symptoms from the SQL query result
            while(resultSet.next()){
                symptomList.add(getSymptomFromResultSet(resultSet));
            }
            resultSet.close();

        } catch(SQLException exception){
            System.err.println(exception.getMessage());
        }
        return symptomList;
    }

    /**
     * This method gets a list of Conditions by the input list of symptoms.
     *
     * It works by looping through the Symptom list first. For each Symptom
     * it runs a query on CONDITION_SYMPTOMS database relationship, that query
     * results in a bunch of Condition names returned as sql data rows, from there,
     * we store those names in a list.
     * At the end we use the getConditionByName() method to return actual condition
     * objects.
     *
     * @param symptoms list that the user inputs
     * @return Arraylist of Condition objects which have at least 1 symptom matching with the user input list
     */
    @Override
    public ArrayList<Condition> getConditionBySymptoms(ArrayList<Symptom> symptoms) {
        ArrayList<Condition> conditions = new ArrayList<>();
        ArrayList<String> conditionNames = new ArrayList<>();

        try(final Connection c = connection();){

            final PreparedStatement preparedStatement = c.prepareStatement(conditionBySymptoms);
            ResultSet resultSet = null;

            //for each symptom we will get the condition names to add to a list
            for(Symptom s : symptoms) {

                //executing the query with one Symptom name at a time
                preparedStatement.setString(1, s.getSymptomName());
                resultSet = preparedStatement.executeQuery();

                //from the sql result, we loop to get all the rows/different-condNames. And we then add them to our conditionNames list
                while(resultSet.next()){

                    //getting all the condition names database gives based on the symptom query search
                    //also ensuring repeating condition names are not added
                    String temp = resultSet.getString("condName");

                    if(!conditionNames.contains(temp)){
                        conditionNames.add(temp);
                    }

                }
            }
            resultSet.close();

        } catch(SQLException exception){
            System.err.println(exception.getMessage());
        }

        //reusing another one of our methods to get Condition objects using the list of their names
        for(String name : conditionNames){
            conditions.add(getConditionByName(name));
        }

        return conditions;
    }

    /**
     *
     * @param condName String from the caller
     * @return Condition object with that name from the DB
     * @throws IllegalArgumentException if the Condition string is incorrect, which means Condition can't be found in DB
     */
    @Override
    public Condition getConditionByName(String condName) throws IllegalArgumentException{
        Condition cond = null;

        try(final Connection c = connection();){

            final PreparedStatement preparedStatement = c.prepareStatement(conditionByName);
            preparedStatement.setString(1, condName);
            ResultSet resultSet = preparedStatement.executeQuery(); // executeQuery will close the preparedStatement.

            cond = getConditionFromResultSet(resultSet);

            resultSet.close();

        } catch(SQLException exception){
            System.err.println(exception.getMessage());
        }

        if(cond == null){
            throw new IllegalArgumentException();
        }

        return cond;
    }

    /**
     * Helper method to make objects from the result set. It keeps the code DRY and clutter to a minimum
     */
    private Condition getConditionFromResultSet(final ResultSet rs) throws SQLException {
        final String name = rs.getString("name");
        final String sourceName = rs.getString("srcName");
        final String sourceLink = rs.getString("srcLink");
        final String description = rs.getString("description");

        return new Condition(name, sourceName, sourceLink, description);
    }

    /**
     * Helper method to make objects from the result set. It keeps the code DRY and clutter to a minimum
     */
    private Symptom getSymptomFromResultSet(final ResultSet rs) throws SQLException {
        final String sympName = rs.getString("sympName");
        final String bodyPart = rs.getString("bodyPart");

        return new Symptom(sympName, bodyPart);
    }

}
