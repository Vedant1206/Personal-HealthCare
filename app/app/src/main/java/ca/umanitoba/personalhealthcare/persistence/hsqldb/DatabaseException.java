package ca.umanitoba.personalhealthcare.persistence.hsqldb;

public class DatabaseException extends Exception {
    public DatabaseException () {
        super("Database Exception");
    }
}
