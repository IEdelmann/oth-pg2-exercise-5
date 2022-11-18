import java.util.ArrayList;

public class Student {
    private String firstName;
    private String lastName;
    private String emailAddress;
    private MatriculationNumber matriculation;
    private StudyCurriculum enrolledCurriculum;

    private final ArrayList<StudyCourse> enrolledCourses;

    public Student(String firstName, String lastName, MatriculationNumber matriculation, StudyCurriculum enrolledCurriculum) {
        this.firstName = firstName;
        this.lastName = lastName;
//        this.emailAddress = emailAddress;
        this.emailAddress = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@st.oth-regensburg.de";
        this.matriculation = matriculation;
        this.enrolledCurriculum = enrolledCurriculum;
        this.enrolledCourses = new ArrayList<>(this.getEnrolledCurriculum().getCoveredStudyCourses());
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public MatriculationNumber getMatriculation() {
        return matriculation;
    }

    public void setMatriculation(MatriculationNumber matriculation) {
        this.matriculation = matriculation;
    }

    public StudyCurriculum getEnrolledCurriculum() {
        return enrolledCurriculum;
    }

    public void setEnrolledCurriculum(StudyCurriculum enrolledCurriculum) {
        this.enrolledCurriculum = enrolledCurriculum;
    }

    public ArrayList<StudyCourse> getEnrolledCourses() {
        return enrolledCourses;
    }
}
