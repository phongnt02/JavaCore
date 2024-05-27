package MyJDBC;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface IBaseModel {
    public void createTable (String tableName, Map<String, String> fields) throws SQLException;
    public void addForeignKeyConstraint(String tableName, String columnName, String foreignTableName, String foreignColumnName) throws SQLException;
    public void insert(Map<String, Object> columnValues) throws SQLException;
    public void update(Map<String, Object> columnValues, String condition) throws SQLException;
    public void delete(String condition) throws SQLException;
    public List<Map<String, Object>> selectAll() throws SQLException;
    public List<Map<String, Object>> DBRaw(String query, Object... params) throws SQLException;
    public void callProcedure(String procedureName, Object... params) throws SQLException;
}
