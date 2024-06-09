package OOP;

import java.util.List;

public class HalfStudent extends Student {
    private String locationTraining;

    @Override
    public String toString() {
        return "HalfStudent{" +
                super.toString() +
                "locationTraining='" + locationTraining + '\'' +
                '}';
    }

    public HalfStudent() {

    }

    public HalfStudent(int id, String name, String birthday, int year, double score, List<StudyResult> studyResults, String locationTraining) {
        super(id, name, birthday, year, score, studyResults);
        this.locationTraining = locationTraining;
    }

    public String getLocationTraining() {
        return locationTraining;
    }
}
