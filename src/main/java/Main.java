import java.sql.SQLException;

/**
 * Created by Alexander on 08/04/2017.
 */
public class Main {

    public static void main(String[] args) {
        DAOImp daoImp = new DAOImp();

        try {
            daoImp.delete("developers2");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
