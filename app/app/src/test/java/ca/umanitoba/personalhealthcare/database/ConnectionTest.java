package ca.umanitoba.personalhealthcare.database;

import org.junit.Test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ca.umanitoba.personalhealthcare.persistence.hsqldb.HsqldbConnection;

public class ConnectionTest {
    @Test
    public void testConnection () {
        HsqldbConnection hsqldb = HsqldbConnection.getInstance();
        Connection connection = hsqldb.getConnection();

        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery("VALUES (current_timestamp)");

            assertNotNull(result);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
