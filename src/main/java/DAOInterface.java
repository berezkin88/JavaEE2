import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by Alexander on 08/04/2017.
 */
public interface DAOInterface {

    void createDatabase(String databaseName) throws SQLException;
    void createTableDevelopers2() throws SQLException;
    List<?> readAll(String tableName) throws SQLException;
    void update(String tableName, String set, String where) throws SQLException;
    void delete(String tableName) throws SQLException;
}
