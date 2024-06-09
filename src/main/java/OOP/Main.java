package OOP;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Faculty faculty = new Faculty("KTTT");
//        1.
//        Student regularStudent = new RegularStudent();
//        Student halfStudent = new HalfStudent();
//        regularStudent.input();
//        halfStudent.input();
        List<StudyResult> studyResult = new ArrayList<>();
        studyResult.add(new StudyResult("HK1", 8.2));

        faculty.addStudents(new RegularStudent(1, "Phong", "29/01/2002", 2022, 25, studyResult));
        faculty.addStudents(new RegularStudent(3, "Phong", "29/01/2002", 2021, 26, studyResult));
        faculty.addStudents(new HalfStudent(2, "Phong", "29/01/2002", 2020, 24.75, studyResult, "VN"));

        faculty.display();
//      2.
        faculty.displayListRegularStudent();
//      3.
        faculty.countRegularStudent();
//      4.
        faculty.StudentScoreTop1();
//      5.
        faculty.getHalfStudentByLocationTraining();
//      6.
        faculty.getStudentAvgScore(8.0);
//      7.
        faculty.sort();
//      8.
        faculty.countStudentGroupYear();
    }
}
