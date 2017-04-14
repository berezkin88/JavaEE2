package Controllers_and_DAO;

import Essences.Customers;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexander on 14/04/2017.
 */
public class CustomersController extends DAOImp{

    Connection connection = null;
    Statement statement = null;

    public List<Customers> readAll() throws SQLException {
        List<Customers> result = new ArrayList<>();


        try {
            Connection();

            System.out.println("Reading from Customers table");
            statement = connection.createStatement();

            String SQL = "SELECT * FROM customers";

            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()){
                Customers customers = createCustomers(resultSet);
                result.add(customers);
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

    public List<Customers> read(String params) throws SQLException{
        List<Customers> result = new ArrayList<>();

        try {
            Connection();

            System.out.println("Reading from Customers table");;
            statement = connection.createStatement();

            String SQL = "SELECT * FROM customers WHERE " + params;

            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()){
                Customers customers = createCustomers(resultSet);
                result.add(customers);
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

    private Customers createCustomers(ResultSet resultSet) throws SQLException {
        Customers customers = new Customers();
        customers.setCustomer_id(resultSet.getInt("customer_id"));
        customers.setCustomer_name(resultSet.getString("customer_name"));
        return customers;
    }

    public void Connection() throws ClassNotFoundException, SQLException {
        System.out.println("Registering JDBC driver...");
        Class.forName(JDBC_DRIVER);

        System.out.println("Connecting to DB...");
        connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
    }
}
