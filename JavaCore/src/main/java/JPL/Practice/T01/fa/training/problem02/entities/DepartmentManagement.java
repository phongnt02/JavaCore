package JPL.Practice.T01.fa.training.problem02.entities;

import JPL.Practice.T01.fa.training.problem02.dao.DepartmentModel;

import java.sql.SQLException;

public class DepartmentManagement {
    private DepartmentModel department;

    public DepartmentManagement(DepartmentModel department) {
        this.department = department;
    }

    public boolean createTable() {
        try {
            this.department.createDepartmentTable();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public void save() throws SQLException {
        this.department.callProcedure("saveDepartment");
    }
}
