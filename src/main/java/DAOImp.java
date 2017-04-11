import java.sql.*;
import java.util.List;
import java.util.Map;

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
    PreparedStatement preparedStatement = null;

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
    public void createTableDevelopers2() throws SQLException {
        try {
            Connection();

            System.out.println("Creating table in selected database...");
            statement = connection.createStatement();

            String SQL = "CREATE TABLE developers2 " +
                    "(id INT PRIMARY KEY not NULL, " +
                    " name VARCHAR(50), " +
                    " specialty VARCHAR (50), " +
                    " salary INT not NULL)";

            statement.executeUpdate(SQL);

            System.out.println("Table successfully created...");

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

    }

    @Override
    public List<?> read(String tableName) {
        return null;
    }

    public List<?> read(String tableName, Map<?,?> params) {
        return null;
    }

    @Override
    public void update(String tableName, Map<?,?> params) {

    }

    @Override
    public void delete(String tableName, Map<?,?> params) {

    }

    private void Connection() throws ClassNotFoundException, SQLException {
        System.out.println("Registering JDBC driver...");
        Class.forName(JDBC_DRIVER);

        System.out.println("Connecting to DB...");
        connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);

    }
}
