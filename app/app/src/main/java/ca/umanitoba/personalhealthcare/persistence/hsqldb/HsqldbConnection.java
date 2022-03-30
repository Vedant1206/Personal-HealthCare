package ca.umanitoba.personalhealthcare.persistence.hsqldb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class HsqldbConnection {
    private Connection connection;

    private HsqldbConnection () {
        openConnection();
    }



    private static HsqldbConnection instance;

    public static HsqldbConnection getInstance () {
        if (instance == null) {
            instance = new HsqldbConnection();
        }
        return instance;
    }

    public Connection getConnection () {
        return this.connection;
    }

    private void openConnection () {
        String dbPath = "jdbc:hsqldb:file:" + System.getProperty("user.dir") + "/src/main/assets/db/data.db";
        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            connection = DriverManager.getConnection(dbPath, "SA", "");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
