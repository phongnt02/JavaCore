package Compare;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee> employeeList = new LinkedList<>();
        employeeList.add(new Employee(1,"a2", 6500));
        employeeList.add(new Employee(2,"a1", 6500));
        employeeList.add(new Employee(3,"c", 5500));
//        Collections.sort(employeeList); // comparable
//        Collections.sort(employeeList, new EmployeeComparator()); // comparator
        Collections.sort(employeeList, EmployeeComparatorInJava8.getComparator()); // comparator java 8
        System.out.println(employeeList.toString());


    }
}
