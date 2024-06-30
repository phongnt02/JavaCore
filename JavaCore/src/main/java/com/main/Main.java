class Animal {
    void eat() {
        System.out.println("Animal is eating...");
    }
}

class Dog extends Animal {
    void eat() {
        System.out.println("Dog is eating...");
    }

    void bark() {
        System.out.println("Dog is barking...");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal animal = new Dog(); // Upcasting
        animal.eat(); // Sẽ gọi phương thức eat() của lớp con (Dog)
        // animal.bark(); // Lỗi biên dịch, vì biến tham chiếu của lớp cha không thể truy cập phương thức của lớp con
    }
}
