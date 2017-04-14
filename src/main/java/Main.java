import Controllers_and_DAO.DAOImp;
import Controllers_and_DAO.SkillsController;

import java.sql.SQLException;

/**
 * Created by Alexander on 08/04/2017.
 */
public class Main {

    public static void main(String[] args) {
        DAOImp daoImp = new DAOImp();
        SkillsController skillsController = new SkillsController();

        try {
            skillsController.readAll().forEach(System.out::println);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
