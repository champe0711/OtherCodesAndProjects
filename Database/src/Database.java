
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Name: Christian Paul Domingo Date: 30 September 2011 Description: Computing
 * Laboratory lab 1 Java Database Connectivity
 *
 * @author eeuc1c
 */
public class Database {

    class NotConnectedException extends Exception {

        public NotConnectedException() {

            System.out.println("Could not connect to the database. Please check that the connection details are correct and try again.");

        }
    }

    private Connection connection;
    Statement state = null;

    public Database(String username, String password, String fileName) throws SQLException, ClassNotFoundException {
        Class.forName("org.hsqldb.jdbcDriver");
        connection = DriverManager.getConnection("jdbc:hsqldb:file:" + fileName, username, password);

    }

    public int update(String sqlStatement) throws SQLException, NotConnectedException {
        state = connection.createStatement();

        if (connection == null) {
            throw new NotConnectedException();
        }

        return state.executeUpdate(sqlStatement);

    }

    public ResultSet query(String sqlStatement) throws SQLException, NotConnectedException {
        state = connection.createStatement();

        if (connection == null) {
            throw new NotConnectedException();
        }

        return state.executeQuery(sqlStatement);

    }

    public void close() throws SQLException, NotConnectedException {
        state.executeUpdate("SHUTDOWN");

        if (connection == null) {
            throw new NotConnectedException();
        }

        connection.close();
    }

    public void deleteDatabases() throws SQLException, NotConnectedException {
        state.execute("DROP SCHEMA PUBLIC CASCADE");

        if (connection == null) {
            throw new NotConnectedException();
        }
        connection.close();
    }

}
