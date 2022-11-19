public class StudyCourse {
    private String studyCourseName;
    private int credits;
    private int multiplication;
    private double courseMark;

    public StudyCourse(String studyCourseName, int credits, int multiplication) {
        this.studyCourseName = studyCourseName;
        this.credits = credits;
        this.multiplication = multiplication;
    }

    // Constructor overload: enables deep copies;
    public StudyCourse(StudyCourse deepCopy) {
        this(deepCopy.getStudyCourseName(), deepCopy.getCredits(), deepCopy.getMultiplication());
    }

    public String getStudyCourseName() {
        return studyCourseName;
    }

    public void setStudyCourseName(String studyCourseName) {
        this.studyCourseName = studyCourseName;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public int getMultiplication() {
        return multiplication;
    }

    public void setMultiplication(int multiplication) {
        this.multiplication = multiplication;
    }

    public double getCourseMark() {
        return courseMark;
    }

    public void setCourseMark(int courseMark) {
        this.courseMark = courseMark;
    }
}
