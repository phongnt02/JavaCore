package JPL.Practice.T01.fa.training.problem02.dao;

import MyJDBC.BaseModel;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class Working_HistoryModel extends BaseModel {
    public Working_HistoryModel() throws SQLException {
        super();
    }

    public void createWorking_HistoryTable() throws SQLException {
        Map<String, String> columnDefinitions = new HashMap<>();
        columnDefinitions.put("dept_no", "INT");
        columnDefinitions.put("emp_no", "INT");
        columnDefinitions.put("from_date", "DATE");
        columnDefinitions.put("to_date", "DATE");
        this.createTable("Working_History", columnDefinitions);

        String addPrimaryKey = "ALTER TABLE Working_History ADD CONSTRAINT pk_employee_id_name PRIMARY KEY (dept_no, emp_no);";
        try (Statement statement = this.connection.createStatement()) {
            statement.executeUpdate(addPrimaryKey);
        }

        addForeignKeyConstraint("Working_History", "dept_no", "Department", "dept_no");
        addForeignKeyConstraint("Working_History", "emp_no", "Employee", "emp_no");
    }
}
