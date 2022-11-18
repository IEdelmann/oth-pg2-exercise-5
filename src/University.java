import java.util.ArrayList;

public class University {
    private String universityName;
    private final ArrayList<Student> enlistedStudent = new ArrayList<>();
    private final ArrayList<StudyCurriculum> availableStudyCurricula = new ArrayList<>();

    public University(String universityName) {
        this.universityName = universityName;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public ArrayList<Student> getEnlistedStudent() {
        return enlistedStudent;
    }

    public ArrayList<StudyCurriculum> getAvailableStudyCurricula() {
        return availableStudyCurricula;
    }

    public void addCurriculaToUniversity(StudyCurriculum newCurriculum) {
        this.getAvailableStudyCurricula().add(newCurriculum);
    }

    public void addStudentToUniversity(String firstName, String lastName, MatriculationNumber matriculation, StudyCurriculum enrolledCurriculum) {
        enlistedStudent.add(new Student(firstName, lastName, matriculation, enrolledCurriculum));
    }
}
