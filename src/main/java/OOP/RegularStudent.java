package OOP;

import java.util.List;

public class RegularStudent extends Student {
    public RegularStudent() {

    }

    @Override
    public String toString() {
        return "RegularStudent{" +
                super.toString() +
                "}";
    }

    public RegularStudent(int id, String name, String birthday, int year, double score, List<StudyResult> studyResults) {
        super(id, name, birthday, year, score, studyResults);
    }


}
