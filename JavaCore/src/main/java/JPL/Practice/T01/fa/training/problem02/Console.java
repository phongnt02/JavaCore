package JPL.Practice.T01.fa.training.problem02;

import JPL.Practice.T01.fa.training.problem02.dao.DepartmentModel;
import JPL.Practice.T01.fa.training.problem02.dao.EmployeeModel;
import JPL.Practice.T01.fa.training.problem02.dao.Working_HistoryModel;
import JPL.Practice.T01.fa.training.problem02.entities.DepartmentManagement;
import JPL.Practice.T01.fa.training.problem02.entities.EmployeeManagement;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Console {
    private Scanner scanner;

    public Console() {
        this.scanner = new Scanner(System.in);
    }

    public void run( EmployeeManagement employeeManagement, DepartmentManagement departmentManagement) throws SQLException {
        boolean exit = false;


        while (!exit) {
            System.out.println("=== MENU ===");
            System.out.println("1. Employee Management");
            System.out.println("2. Department Management");
            System.out.print("Lựa chọn của bạn: ");

            try {
                int choice = scanner.nextInt();

                exit = switch (choice) {
                    case 1 -> {
                        System.out.println("1. Add new Employee");
                        System.out.println("2. find all Employee");
                        System.out.println("3. find Employee by Id");
                        System.out.print("Lựa chọn của bạn: ");
                        int feature = scanner.nextInt();
                        if(feature == 1 ){
                            employeeManagement.save();
                        }
                        else if ( feature == 2 ) {
                            System.out.println("select all:");
                            employeeManagement.findAll();
                        }
                        else if (feature == 3) {
                            System.out.println("enter id: ");
                            String id = scanner.next();
                            employeeManagement.findByEmpNo(id);
                        }
                        yield false;
                    }
                    case 2 -> {

                        System.out.println("1. Add new Department");
                        System.out.print("Lựa chọn của bạn: ");
                        int feature = scanner.nextInt();
                        if(feature == 1 ){
                            System.out.println("select all:");
                            departmentManagement.save();
                        }
                        yield false;
                    }
                    case 3 -> {
                        System.out.println("Thoát chương trình.");
                        yield true;
                    }
                    default -> {
                        System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                        yield false;
                    }
                };
            } catch (InputMismatchException e) {
                System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập số nguyên.");
                scanner.nextLine();
            }
            System.out.println();
        }

        scanner.close();
    }
}
