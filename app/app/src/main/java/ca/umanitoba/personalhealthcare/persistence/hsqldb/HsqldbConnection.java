package ca.umanitoba.personalhealthcare.persistence.hsqldb;

import org.hsqldb.cmdline.SqlFile;
import org.hsqldb.cmdline.SqlToolError;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class HsqldbConnection {
    private static SqlFile sqlFile = null;

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
        String scriptPath = System.getProperty("user.dir") + "/src/main/assets/db/script.sql";

        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            connection = DriverManager.getConnection(dbPath, "SA", "");

            if (sqlFile == null) {
                sqlFile = new SqlFile(new File(scriptPath));
                sqlFile.setConnection(connection);
                sqlFile.execute();
                connection.commit();
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SqlToolError sqlToolError) {
            sqlToolError.printStackTrace();
        }
    }
}
