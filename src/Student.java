import java.util.ArrayList;

public class Student {
    private String firstName;
    private String lastName;
    private String emailAddress;
    private MatriculationNumber matriculation;
    private StudyCurriculum enrolledCurriculum;

    private ArrayList<StudyCourse> enrolledCourses;

    public Student(String firstName, String lastName, MatriculationNumber matriculation, StudyCurriculum enrolledCurriculum) {
        this.firstName = firstName;
        this.lastName = lastName;
//        this.emailAddress = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@st.oth-regensburg.de";
        this.emailAddress = generateEmailAddress();
        this.matriculation = matriculation;
        this.enrolledCurriculum = enrolledCurriculum;
        this.enrolledCourses = new ArrayList<>(this.getEnrolledCurriculum().getCoveredStudyCourses());
    }

    private String generateEmailAddress() {
        return this.getFirstName().toLowerCase() + "." + this.getLastName().toLowerCase() + "@st.oth-regensburg.de";
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

    public void changeFirstName(String newFirstName) {
        this.setFirstName(newFirstName);
        this.emailAddress = generateEmailAddress();
    }

    public void changeLastName(String newLastName) {
        this.setFirstName(newLastName);
        this.emailAddress = generateEmailAddress();
    }

    public void changeCurriculum(StudyCurriculum newCurriculum) {
        this.enrolledCurriculum = newCurriculum;

        this.enrolledCourses = null;
        System.gc();

        this.enrolledCourses = new ArrayList<>(this.getEnrolledCurriculum().getCoveredStudyCourses());
    }
}
