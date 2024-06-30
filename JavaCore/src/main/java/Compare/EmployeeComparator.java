package Compare;

import java.util.Comparator;

public class EmployeeComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee e1, Employee e2){
        int compareName = e1.getName().compareTo(e2.getName());
        if (compareName != 0) {
            return compareName;
        }

        return e1.getAddress().compareTo(e2.getAddress());
//        return e2.getAddress().compareTo(e1.getAddress()); thứ tự giảm dần
    }
}
