package Compare;

public class Employee implements Comparable<Employee> {
    private int Id;
    private String name;
    private double salary;
    private String address;
    public int getId() {
        return Id;
    }
    public String getName() {
        return name;
    }
    public double getSalary() {
        return salary;
    }
    public String getAddress(){
        return address;
    }

    public Employee (int Id, String name, double salary){
        this.Id = Id;
        this.name = name;
        this.salary =salary;
    }

    @Override
    public String toString () {
        return "Employee [id=" + this.Id + ", name=" + this.name + ", salary=" + this.salary + "]";
    }
    @Override
    public int compareTo(Employee employee) {
        return this.name.compareTo(employee.getName());
    }
}
