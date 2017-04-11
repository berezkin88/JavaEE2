import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by Alexander on 08/04/2017.
 */
public interface DAOInterface {

    void createDatabase(String databaseName) throws SQLException;
    void createTableDevelopers2() throws SQLException;
    List<?> read(String tableName);
    void update(String tableName, Map<?,?> params);
    void delete(String tableName, Map<?,?> params);
}
