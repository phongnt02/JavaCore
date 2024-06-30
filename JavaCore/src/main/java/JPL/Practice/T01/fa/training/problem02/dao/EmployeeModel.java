package JPL.Practice.T01.fa.training.problem02.dao;

import MyJDBC.BaseModel;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class EmployeeModel extends BaseModel {
    public EmployeeModel() throws SQLException {
        super();
    }

    public void createEmployeeTable() throws SQLException {
        Map<String, String> columnDefinitions = new HashMap<>();
        columnDefinitions.put("emp_no", "INT AUTO_INCREMENT PRIMARY KEY");
        columnDefinitions.put("birth_date", "DATE");
        columnDefinitions.put("first_name", "VARCHAR(50)");
        columnDefinitions.put("last_name", "VARCHAR(50)");
        columnDefinitions.put("gender", "CHARACTER(1)");
        columnDefinitions.put("hire_date", "DATE");
        this.createTable("Employee", columnDefinitions);

    }
}
