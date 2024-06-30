package OOP;

public class StudyResult {
    private String semesterName;
    private double gpa;

    @Override
    public String toString() {
        return "StudyResult{" +
                "semesterName='" + semesterName + '\'' +
                ", gpa=" + gpa +
                '}';
    }

    public StudyResult(String semesterName, double gpa) {
        this.semesterName = semesterName;
        this.gpa = gpa;
    }

    public String getSemesterName() {
        return this.semesterName;
    }

    public double getGpa() {
        return this.gpa;
    }
}
