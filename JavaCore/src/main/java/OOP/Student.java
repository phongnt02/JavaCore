package OOP;

import java.util.List;
import java.util.Scanner;

public abstract class Student {
    protected int id;
    protected  String name;
    protected String birthday;
    protected int year;
    protected double score;
    protected List<StudyResult> studyResults;

    public Student() {

    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthday='" + birthday + '\'' +
                ", year=" + year +
                ", score=" + score +
                ", studyResults=" + studyResults +
                '}';
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getBirthday() {
        return this.birthday;
    }

    public int getYear() {
        return this.year;
    }

    public double getScore() {
        return this.score;
    }

    public List<StudyResult> getStudyResults() {
        return this.studyResults;
    }

    public Student(int id, String name, String birthday, int year, double score, List<StudyResult> studyResults) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.year = year;
        this.score = score;
        this.studyResults = studyResults;
    }
    public void input () {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter student ID: ");
        this.id = scanner.nextInt();
        System.out.println("Enter name: ");
        this.name = scanner.next();
        System.out.println("Enter birth date (dd/mm/yyyy): ");
        this.birthday = scanner.next();
        System.out.println("Enter year of admission: ");
        this.year = scanner.nextInt();
        System.out.println("Enter entry score: ");
        this.score = scanner.nextDouble();
    }
    public boolean isRegularStudent() {
        return this instanceof RegularStudent;
    }

    public double getAvgStudyResults () {
        double sumScore = 0;
        int quantity = 0;
        for (StudyResult result : this.studyResults) {
            quantity++;
            sumScore = result.getGpa();
        }
        return sumScore/quantity;
    }
}
