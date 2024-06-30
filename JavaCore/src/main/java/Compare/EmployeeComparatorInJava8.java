package Compare;

import java.util.Comparator;

public class EmployeeComparatorInJava8 {
    public static Comparator<Employee> getComparator () {
        return Comparator.comparing(Employee::getName)
                .thenComparing(Employee::getAddress);
    }
}
