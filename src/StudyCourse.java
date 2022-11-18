public class StudyCourse {
    private static String studyCourseName;
    private static int credits;
    private static int multiplication;

    private int courseMark;

    public StudyCourse(String studyCourseName, int credits, int multiplication) {
        StudyCourse.studyCourseName = studyCourseName;
        StudyCourse.credits = credits;
        StudyCourse.multiplication = multiplication;
    }

    public static String getStudyCourseName() {
        return studyCourseName;
    }

    public static void setStudyCourseName(String studyCourseName) {
        StudyCourse.studyCourseName = studyCourseName;
    }

    public static int getCredits() {
        return credits;
    }

    public static void setCredits(int credits) {
        StudyCourse.credits = credits;
    }

    public static int getMultiplication() {
        return multiplication;
    }

    public static void setMultiplication(int multiplication) {
        StudyCourse.multiplication = multiplication;
    }

    public int getCourseMark() {
        return courseMark;
    }

    public void setCourseMark(int courseMark) {
        this.courseMark = courseMark;
    }
}
