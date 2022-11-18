import java.util.ArrayList;

public class StudyCurriculum {
    private String curriculumName;
    private final ArrayList<StudyCourse> coveredStudyCourses = new ArrayList<>();

    public StudyCurriculum(String curriculumName) {
        this.curriculumName = curriculumName;
    }

    public String getCurriculumName() {
        return curriculumName;
    }

    public void setCurriculumName(String curriculumName) {
        this.curriculumName = curriculumName;
    }

    public ArrayList<StudyCourse> getCoveredStudyCourses() {
        return coveredStudyCourses;
    }

    public void addStudyCourseToCurriculum(StudyCourse newCourse) {
        this.getCoveredStudyCourses().add(newCourse);
    }
}
