package Controllers_and_DAO;

import Essences.Developers;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexander on 14/04/2017.
 */
public class DevelopersController extends DAOImp{
    Connection connection = null;
    Statement statement = null;

    public List<Developers> readAll() throws SQLException {
        List<Developers> result = new ArrayList<>();


        try {
            Connection();

            System.out.println("Reading from Developers table");
            statement = connection.createStatement();

            String SQL = "SELECT * FROM developers";

            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()){
                Developers developers = createDevelopers(resultSet);
                result.add(developers);
            }


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

    public List<Developers> read(String params) throws SQLException{
        List<Developers> result = new ArrayList<>();

        try {
            Connection();

            System.out.println("Reading from Developers table");;
            statement = connection.createStatement();

            String SQL = "SELECT * FROM developers WHERE " + params;

            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()){
                Developers developers = createDevelopers(resultSet);
                result.add(developers);
            }

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

    private Developers createDevelopers(ResultSet resultSet) throws SQLException {
        Developers developers = new Developers();
        developers.setId(resultSet.getInt("id"));
        developers.setName(resultSet.getString("name"));
        developers.setSurname(resultSet.getString("surname"));
        developers.setAge(resultSet.getInt("age"));
        developers.setSalary(resultSet.getDouble("salary"));
        developers.setProgect(resultSet.getInt("project"));
        return developers;
    }

    public void Connection() throws ClassNotFoundException, SQLException {
        System.out.println("Registering JDBC driver...");
        Class.forName(JDBC_DRIVER);

        System.out.println("Connecting to DB...");
        connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
    }
}
