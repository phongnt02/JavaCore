package OOP;

import java.util.*;

public class Faculty {
    public String name;
    private List<Student> studentList;

    public Faculty(String name) {
        this.name = name;
        this.studentList = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public List<Student> getStudentList() {
        return this.studentList;
    }

    public void addStudents(Student student) {
        this.studentList.add(student);
    }

    public void display() {
        this.studentList.forEach(student -> {
            System.out.println("Danh sach sinh vien");
            System.out.println(student);
            System.out.println("-----");
        });
    }

    public void displayListRegularStudent() {
        System.out.println("--Danh sach sinh vien chinh quy");
        this.studentList.forEach(student -> {
            if (student.isRegularStudent()) {
                System.out.println(student);
            }
        });
    }

    public void countRegularStudent() {
        long count = this.studentList.stream()
                .filter(student -> student.isRegularStudent())
                .count();
        System.out.println("--So sinh vien chinh quy:" + count);
    }

    public double findScoreMaxInAllStudent() {
        return this.studentList.stream()
                .mapToDouble(student -> student.score)
                .max()
                .orElse(0);
    }

    public void StudentScoreTop1() {
        double scoreMax = this.findScoreMaxInAllStudent();
        this.studentList.stream()
                .filter(student -> student.score == scoreMax)
                .forEach(student -> System.out.println("ID sinh vien diem cao nhat: " + student.id));
    }

    public void getHalfStudentByLocationTraining() {
        this.studentList.stream()
                .filter(student -> (student instanceof HalfStudent) && ((HalfStudent) student).getLocationTraining() == "VN")
                .forEach(student -> {
                    System.out.println("ID sinh vien theo vi tri training: " + student.id);
                });
    }

    public void getStudentAvgScore(double scoreCondi) {
        this.studentList.forEach(student -> {
            if (student.studyResults.getLast().getGpa() > scoreCondi) {
                System.out.println("ID sinh vien diem lon hon " + scoreCondi + ": " + student.id);
            }
        });
    }

    public void sort() {
        Collections.sort(studentList, new StudentComparator());
        System.out.println(studentList);
    }

    public void countStudentGroupYear() {
        Map<Integer, Integer> yearCount = new HashMap<>();
        this.studentList.forEach(student -> {
            int year = student.getYear();
            yearCount.put(year, yearCount.getOrDefault(year, 0) + 1);
        });

        System.out.println(yearCount);
    }
}
