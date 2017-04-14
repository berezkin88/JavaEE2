package Controllers_and_DAO;

import Essences.Companies;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexander on 14/04/2017.
 */
public class CompaniesController extends DAOImp {

    Connection connection = null;
    Statement statement = null;

    public List<Companies> readAll() throws SQLException {
        List<Companies> result = new ArrayList<>();


        try {
            Connection();

            System.out.println("Reading from Companies table");
            statement = connection.createStatement();

            String SQL = "SELECT * FROM companies";

            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()){
                Companies companies = createCompany(resultSet);
                result.add(companies);
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

    public List<Companies> read(String params) throws SQLException{
        List<Companies> result = new ArrayList<>();

        try {
            Connection();

            System.out.println("Reading from Companies table");;
            statement = connection.createStatement();

            String SQL = "SELECT * FROM companies WHERE " + params;

            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()){
                Companies companies = createCompany(resultSet);
                result.add(companies);
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

    private Companies createCompany(ResultSet resultSet) throws SQLException {
        Companies companies = new Companies();
        companies.setCompany_id(resultSet.getInt("company_id"));
        companies.setCompany_name(resultSet.getString("company_name"));
        companies.setNumber_of_empoyees(resultSet.getInt("number_of_employees"));
        return companies;
    }

    public void Connection() throws ClassNotFoundException, SQLException {
        System.out.println("Registering JDBC driver...");
        Class.forName(JDBC_DRIVER);

        System.out.println("Connecting to DB...");
        connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
    }
}
