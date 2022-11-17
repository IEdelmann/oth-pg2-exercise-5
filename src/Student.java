import java.util.ArrayList;

public class Student {
    private String firstName;
    private String lastName;
    private String emailAddress;
    private MatriculationNumber matriculation;
    private StudyCurriculum enrolledCurriculum;

    private final ArrayList<StudyCourse> enrolledCourses = new ArrayList<>();
}
