import java.util.List;
import java.util.Map;

/**
 * Created by Alexander on 08/04/2017.
 */
public interface DAOInterface {

    void create(String tableName, Map<?,?> param);
    List<?> read(String tableName);
    void update(String tableName, Map<?,?> param);
    void delete(String tableName, Map<?,?> param);
}
