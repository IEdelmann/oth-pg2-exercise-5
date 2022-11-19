import java.util.ArrayList;

public class Student {
    private String firstName;
    private String lastName;
    private String emailAddress;
    private MatriculationNumber matriculation;
    private StudyCurriculum enrolledCurriculum;

    private ArrayList<StudyCourse> enrolledCourses = new ArrayList<>();

    public Student(String firstName, String lastName, MatriculationNumber matriculation, StudyCurriculum enrolledCurriculum) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = generateEmailAddress();
        this.matriculation = matriculation;
        this.enrolledCurriculum = enrolledCurriculum;
        deepCopyStudyCourses(this.getEnrolledCurriculum().getCoveredStudyCourses());
    }

    // Creates deep copies of every StudyCourse objects;
    private void deepCopyStudyCourses(ArrayList<StudyCourse> studyCourses) {
        for (int i = 0; i < studyCourses.size(); i++) {
            this.enrolledCourses.add(new StudyCourse(studyCourses.get(i)));
        }
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

    // Deactivated this setter;
    private void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public MatriculationNumber getMatriculation() {
        return matriculation;
    }

    // Deactivated this setter;
    private void setMatriculation(MatriculationNumber matriculation) {
        this.matriculation = matriculation;
    }

    public StudyCurriculum getEnrolledCurriculum() {
        return enrolledCurriculum;
    }

    // Deactivated this setter;
    private void setEnrolledCurriculum(StudyCurriculum enrolledCurriculum) {
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
        this.setLastName(newLastName);
        this.emailAddress = generateEmailAddress();
    }

    public void changeCurriculum(StudyCurriculum newCurriculum) {
        this.enrolledCurriculum = newCurriculum;

        this.enrolledCourses = null;        // Sets to current object to 'null' to delete it;
        System.gc();        // Garbage collector Galore;

        this.enrolledCourses = new ArrayList<>(this.getEnrolledCurriculum().getCoveredStudyCourses());      // Get the new ArrayList of StudyCourses;
    }
}
