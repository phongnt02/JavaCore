package JPL.Practice.T01.fa.training.problem02;

import JPL.Practice.T01.fa.training.problem02.dao.DepartmentModel;
import JPL.Practice.T01.fa.training.problem02.dao.EmployeeModel;
import JPL.Practice.T01.fa.training.problem02.dao.Working_HistoryModel;
import JPL.Practice.T01.fa.training.problem02.entities.DepartmentManagement;
import JPL.Practice.T01.fa.training.problem02.entities.EmployeeManagement;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        EmployeeManagement employeeManagement = new EmployeeManagement(new EmployeeModel());
        employeeManagement.createTable();

        DepartmentManagement departmentManagement = new DepartmentManagement(new DepartmentModel());
        departmentManagement.createTable();
        Working_HistoryModel workingHistoryModel = new Working_HistoryModel();
        workingHistoryModel.createWorking_HistoryTable();

        Console ui = new Console();
        ui.run(employeeManagement, departmentManagement);
    }
}
