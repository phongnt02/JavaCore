package JPL.Practice.T01.fa.training.problem02.entities;

import JPL.Practice.T01.fa.training.problem02.dao.EmployeeModel;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeManagement {
    private EmployeeModel employee;

    public EmployeeManagement(EmployeeModel employee) {
        this.employee = employee;
    }

    public boolean createTable() {
        try {
            this.employee.createEmployeeTable();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


    public void save() throws SQLException {
        this.employee.callProcedure("saveEmployee", null,"test","test2", "1", null);
    }

    public void findALl () throws SQLException {
        this.employee.selectAll();
        List<Map<String, Object>> records = this.employee.selectAll();
        records.forEach(row-> System.out.println(row));
    }

    public boolean update() {
        return true;
    }

    public void findByEmpNo(String id) throws SQLException {
        String query = "SELECT * FROM Employee WHERE emp_no = ?";
        List<Map<String, Object>> recordId = this.employee.DBRaw(query, id);
        if(recordId.isEmpty()) {
            System.out.println("Khong co data");
        }
        recordId.forEach(row -> System.out.println(row));
    }

    public void findAll() {

    }
}
