package OOP;

import java.util.Comparator;

public class StudentComparator implements Comparator<Student> {
    @Override
    public int compare (Student student1, Student student2) {
        int compareGpa = Double.compare(student1.getAvgStudyResults(), student2.getAvgStudyResults());
        if (compareGpa != 0) {
            return compareGpa;
        }
        return Integer.compare(student2.getYear(),student1.getYear());
    }
}
