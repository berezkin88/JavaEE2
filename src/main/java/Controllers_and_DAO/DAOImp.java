package Controllers_and_DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexander on 08/04/2017.
 */
public class DAOImp implements DAOInterface {
    static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/JavaEE1";
    static final String JDBC_DRIVER = "org.postgresql.Driver";

    static final String USER = "root";
    static final String PASSWORD = "root";

    Connection connection = null;
    Statement statement = null;

    @Override
    public void createDatabase(String databaseName) throws SQLException {
        try {
            Connection();

            System.out.println("Creating database...");
            statement = connection.createStatement();

            String SQL = "CREATE DATABASE " + databaseName;


            statement.executeUpdate(SQL);
            System.out.println("Database successfully created...");

        } catch (Exception e) {
            System.out.println("Operation is failed");
            throw new RuntimeException(e);
        }

        try {
            statement.close();
            connection.close();
        } finally {
            if(statement !=null){
                statement.close();
            }
            if(connection!=null){
                connection.close();
            }
        }

    }

    @Override
    public void createTable(String tableName, String params) throws SQLException
    {
        try {
            Connection();

            System.out.println("Creating table in selected database...");
            statement = connection.createStatement();

            String SQL = "CREATE TABLE " + tableName + "(" + params + ")";

            statement.executeUpdate(SQL);

            System.out.println("Table successfully created...");

        } catch (Exception e) {
            System.out.println("Operation failed");
            throw new RuntimeException(e);
        } finally {
            if (statement!=null){
                statement.close();
            }
            if (connection!=null){
                connection.close();
            }
        }

    }


    @Override
    public List<?> readAll(String tableName) throws SQLException {
        List<?> result = new ArrayList<>();

        try {
            Connection();

            System.out.println("Reading from " + tableName + " table");
            statement = connection.createStatement();

            String SQL = "SELECT * FROM " + tableName;

            ResultSet resultSet = statement.executeQuery(SQL);


        } catch (ClassNotFoundException e) {
            System.out.println("Operation failed");
            e.printStackTrace();
        } finally {
            if (statement!=null){
                statement.close();
            }
            if (connection!=null){
                connection.close();
            }
        }
        return result;
    }

    public List<?> read(String tableName, String params) throws SQLException{
        List<?> result = new ArrayList<>();

        try {
            Connection();

            System.out.println("Reading from " + tableName + " table");;
            statement = connection.createStatement();

            String SQL = "SELECT * FROM " + tableName + " WHERE " + params;

            ResultSet resultSet = statement.executeQuery(SQL);

        } catch (Exception e) {
            System.out.println("Operation failed");
            throw new RuntimeException(e);
        } finally {
            if (statement!=null){
                statement.close();
            }
            if (connection!=null){
                connection.close();
            }
        }
        return result;
    }

    @Override
    public void update(String tableName, String set, String where) throws SQLException {
        try {
            Connection();

            System.out.println("Updating information in " + tableName + " table");
            statement = connection.createStatement();

            String SQL = "UPDATE " + tableName + " SET " + set + " WHERE " + where;

            statement.executeUpdate(SQL);

            System.out.println("Information updated successfully");

        } catch (Exception e) {
            System.out.println("Operation failed");
            throw new RuntimeException(e);
        } finally {
            if (statement!=null){
                statement.close();
            }
            if (connection!=null){
                connection.close();
            }
        }
    }

    @Override
    public void delete(String tableName) throws SQLException{
        try {
            Connection();

            System.out.println("Deleting " + tableName + " table");
            statement = connection.createStatement();

            String SQL = "DROP TABLE " + tableName;

            statement.executeUpdate(SQL);

            System.out.println("Table successfully deleted...");

        } catch (Exception e) {
            System.out.println("Operation failed");
            e.printStackTrace();
        } finally {
            if (statement!=null){
                statement.close();
            }
            if (connection!=null){
                connection.close();
            }
        }
    }

    public void Connection() throws ClassNotFoundException, SQLException {
        System.out.println("Registering JDBC driver...");
        Class.forName(JDBC_DRIVER);

        System.out.println("Connecting to DB...");
        connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
    }
}
