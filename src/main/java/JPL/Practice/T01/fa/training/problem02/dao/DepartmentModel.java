package JPL.Practice.T01.fa.training.problem02.dao;

import MyJDBC.BaseModel;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class DepartmentModel extends BaseModel {
    public DepartmentModel() throws SQLException {
        super();
    }

    public void createDepartmentTable() throws SQLException {
        Map<String, String> columnDefinitions = new HashMap<>();
        columnDefinitions.put("dept_no", "INT AUTO_INCREMENT PRIMARY KEY");
        columnDefinitions.put("dept_name", "VARCHAR(50)");
        columnDefinitions.put("description", "VARCHAR(100)");
        this.createTable("Department", columnDefinitions);
    }
}
