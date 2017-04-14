package Controllers_and_DAO;

import Essences.Projects;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexander on 14/04/2017.
 */
public class ProjectsController extends DAOImp{
    Connection connection = null;
    Statement statement = null;

    public List<Projects> readAll() throws SQLException {
        List<Projects> result = new ArrayList<>();


        try {
            Connection();

            System.out.println("Reading from Projects table");
            statement = connection.createStatement();

            String SQL = "SELECT * FROM projects";

            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()){
                Projects projects = createProjects(resultSet);
                result.add(projects);
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

    public List<Projects> read(String params) throws SQLException{
        List<Projects> result = new ArrayList<>();

        try {
            Connection();

            System.out.println("Reading from Projects table");;
            statement = connection.createStatement();

            String SQL = "SELECT * FROM projects WHERE " + params;

            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()){
                Projects projects = createProjects(resultSet);
                result.add(projects);
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

    private Projects createProjects(ResultSet resultSet) throws SQLException {
        Projects projects = new Projects();
        projects.setProject_id(resultSet.getInt("project_id"));
        projects.setProject_title(resultSet.getString("project_title"));
        projects.setCompany_id(resultSet.getInt("company_id"));
        projects.setCustomer_id(resultSet.getInt("customer_id"));
        projects.setCost(resultSet.getInt("cost"));
        return projects;
    }

    public void Connection() throws ClassNotFoundException, SQLException {
        System.out.println("Registering JDBC driver...");
        Class.forName(JDBC_DRIVER);

        System.out.println("Connecting to DB...");
        connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
    }
}
