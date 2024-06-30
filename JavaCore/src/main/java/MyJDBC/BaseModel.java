package MyJDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseModel implements IBaseModel {
    protected Connection connection;
    protected String table;
    public BaseModel () throws SQLException {
        this.connection = MyConnect.getConnection();
    }
    @Override
    public void createTable (String tableName, Map<String, String> fields) throws SQLException{
        StringBuilder query = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
        query.append(tableName).append(" (");

        fields.forEach((key, value) -> {
            query.append(key).append(" ").append(value).append(", ");
        });

        query.delete(query.length() - 2, query.length());
        query.append(")");

        try (Statement statement = this.connection.createStatement()) {
            statement.executeUpdate(query.toString());
        }
        this.table = tableName;
    }
    @Override
    public void addForeignKeyConstraint(String tableName, String columnName, String foreignTableName, String foreignColumnName) throws SQLException {
        StringBuilder query = new StringBuilder("ALTER TABLE ");
        query.append(tableName)
                .append(" ADD FOREIGN KEY (")
                .append(columnName)
                .append(") REFERENCES ")
                .append(foreignTableName)
                .append("(")
                .append(foreignColumnName)
                .append(")");

        try (Statement statement = this.connection.createStatement()) {
            statement.executeUpdate(query.toString());
        }
    }

    @Override
    public void insert(Map<String, Object> columnValues) throws SQLException {
        StringBuilder query = new StringBuilder("INSERT INTO ");
        query.append(this.table).append(" (");

        StringBuilder values = new StringBuilder(" VALUES (");

        columnValues.forEach((key, value) -> {
            query.append(key).append(", ");
            values.append("?, ");
        });

        query.delete(query.length() - 2, query.length());
        values.delete(values.length() - 2, values.length());

        query.append(")").append(values).append(")");

        this.executeUpdate(query.toString(), columnValues.values().toArray());
    }

    @Override
    public void update(Map<String, Object> columnValues, String condition) throws SQLException {
        StringBuilder query = new StringBuilder("UPDATE ");
        query.append(this.table).append(" SET ");

        columnValues.forEach((key, value) -> query.append(key).append("=?, "));
        query.delete(query.length() - 2, query.length());

        if (condition != null && !condition.isEmpty()) {
            query.append(" WHERE ").append(condition);
        }

        this.executeUpdate(query.toString(), columnValues.values().toArray());
    }

    @Override
    public void delete(String condition) throws SQLException {
        StringBuilder query = new StringBuilder("DELETE FROM ");
        query.append(this.table);

        if (condition != null && !condition.isEmpty()) {
            query.append(" WHERE ").append(condition);
        }

        executeUpdate(query.toString());
    }

    private List<Map<String, Object>> executeQuery(String query, Object... params) throws SQLException {
        List<Map<String, Object>> results = new ArrayList<>();
        try (PreparedStatement statement = this.connection.prepareStatement(query)) {
            for (int i = 0; i < params.length; i++) {
                statement.setObject(i + 1, params[i]);
            }
            try (ResultSet resultSet = statement.executeQuery()) {
                ResultSetMetaData metaData = resultSet.getMetaData();
                int columnCount = metaData.getColumnCount();
                while (resultSet.next()) {
                    Map<String, Object> row = new HashMap<>();
                    for (int i = 1; i <= columnCount; i++) {
                        row.put(metaData.getColumnName(i), resultSet.getObject(i));
                    }
                    results.add(row);
                }
            }
        }
        return results;
    }

    private void setStatementParameters(PreparedStatement statement, Object... params) throws SQLException {
        for (int i = 0; i < params.length; i++) {
            statement.setObject(i + 1, params[i]);
        }
    }

    private void executeUpdate(String query, Object... params) throws SQLException {
        try (PreparedStatement statement = this.connection.prepareStatement(query)) {
            this.setStatementParameters(statement, params);
            statement.executeUpdate();
        }
    }

    @Override
    public List<Map<String, Object>> selectAll() throws SQLException {
        String query = "SELECT * FROM " + this.table;
        return this.executeQuery(query);
    }

    @Override
    public List<Map<String, Object>> DBRaw(String query, Object... params) throws SQLException {
        return this.executeQuery(query, params);
    }

    @Override
    public void callProcedure(String procedureName, Object... params) throws SQLException {
        StringBuilder callStmt = new StringBuilder("{call ");
        callStmt.append(procedureName).append("(");
        for (int i = 0; i < params.length; i++) {
            if (i > 0) {
                callStmt.append(",");
            }
            callStmt.append("?");
        }
        callStmt.append(")}");

        try (CallableStatement callableStatement = connection.prepareCall(callStmt.toString())) {
            for (int i = 0; i < params.length; i++) {
                callableStatement.setObject(i + 1, params[i]);
            }
            callableStatement.execute();
        }
    }


}
