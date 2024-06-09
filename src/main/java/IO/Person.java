package IO;

import java.io.Serializable;

// implements Serializable để đánh dấu rằng đối tượng của lớp này có thể được tuần tự hóa và ghi xuống tệp tin.
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}