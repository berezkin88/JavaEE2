package Controllers_and_DAO;

import Essences.Skills;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexander on 15/04/2017.
 */
public class SkillsController extends DAOImp {
    Connection connection = null;
    Statement statement = null;

    public List<Skills> readAll() throws SQLException {
        List<Skills> result = new ArrayList<>();


        try {
            Connection();

            System.out.println("Reading from Skills table");
            statement = connection.createStatement();

            String SQL = "SELECT * FROM skills";

            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()){
                Skills skills = createSkills(resultSet);
                result.add(skills);
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

    public List<Skills> read(String params) throws SQLException{
        List<Skills> result = new ArrayList<>();

        try {
            Connection();

            System.out.println("Reading from Skills table");;
            statement = connection.createStatement();

            String SQL = "SELECT * FROM skills WHERE " + params;

            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()){
                Skills skills = createSkills(resultSet);
                result.add(skills);
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

    private Skills createSkills(ResultSet resultSet) throws SQLException {
        Skills skills = new Skills();
        skills.setSkill_id(resultSet.getInt("skill_id"));
        skills.setArea_of_skill(resultSet.getString("area_of_skill"));
        skills.setDeveloper_id(resultSet.getInt("developer_id"));
        return skills;
    }

    public void Connection() throws ClassNotFoundException, SQLException {
        System.out.println("Registering JDBC driver...");
        Class.forName(JDBC_DRIVER);

        System.out.println("Connecting to DB...");
        connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
    }
}
