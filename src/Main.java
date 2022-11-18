import myUtilities.UserInput;
public class Main {

    public static void main(String[] args) {

        University othRegensburg = new University("OTH Regensburg");

        StudyCurriculum curriculumEconomicInformationBachelor = new StudyCurriculum("Wirtschaftsinformatik (Bachelor)");
        StudyCurriculum curriculumEconomicInformationMaster = new StudyCurriculum("Wirtschaftsinformatik (Master)");
        StudyCurriculum curriculumGeneralInformationBachelor = new StudyCurriculum("Allgemeine Informatik (Bachelor)");

        othRegensburg.addCurriculaToUniversity(curriculumEconomicInformationBachelor);
        othRegensburg.addCurriculaToUniversity(curriculumEconomicInformationMaster);
        othRegensburg.addCurriculaToUniversity(curriculumGeneralInformationBachelor);

        StudyCourse courseProgrammingOne = new StudyCourse("Programmieren 1", 8, 1);
        StudyCourse courseProgrammingTwo = new StudyCourse("Prgrammieren 2", 8, 1);
        StudyCourse courseEconomicsOne = new StudyCourse("BWL 1", 7, 1);
        StudyCourse courseEconomicsTwo = new StudyCourse("BWL 2", 8, 1);
        StudyCourse courseModDataStructure = new StudyCourse("Moderne Datenbankkonzepte", 7, 1);
        StudyCourse courseBusinessConsulting = new StudyCourse("Business Consulting" , 7, 1);

        curriculumEconomicInformationBachelor.addStudyCourseToCurriculum(courseProgrammingOne);
        curriculumEconomicInformationBachelor.addStudyCourseToCurriculum(courseProgrammingTwo);
        curriculumEconomicInformationBachelor.addStudyCourseToCurriculum(courseEconomicsOne);
        curriculumEconomicInformationBachelor.addStudyCourseToCurriculum(courseEconomicsTwo);

        curriculumEconomicInformationMaster.addStudyCourseToCurriculum(courseModDataStructure);
        curriculumEconomicInformationMaster.addStudyCourseToCurriculum(courseBusinessConsulting);

        curriculumGeneralInformationBachelor.addStudyCourseToCurriculum(courseProgrammingOne);
        curriculumEconomicInformationBachelor.addStudyCourseToCurriculum(courseProgrammingTwo);

        // Test student
        MatriculationNumber firstTestStudentMatricularNumber = new MatriculationNumber();
        firstTestStudentMatricularNumber.setMatriculationNumber("12345679");
        othRegensburg.addStudentToUniversity("Ringo", "Kugelfade",  firstTestStudentMatricularNumber, curriculumEconomicInformationBachelor);
        // Second test student - this time adding the student to the university!
        MatriculationNumber secondTestStudentMatricularNumber = new MatriculationNumber();
        secondTestStudentMatricularNumber.setMatriculationNumber("42042069");
        othRegensburg.addStudentToUniversity("Jack", "Peppermint", secondTestStudentMatricularNumber, curriculumEconomicInformationMaster);

        // Print the test students data
//        for (int i = 0; i < othRegensburg.getEnlistedStudent().size(); i++) {
//            Student tempStudent = othRegensburg.getEnlistedStudent().get(i);
//
//            System.out.println(i + ". students data: ");
//            System.out.println("Name: " + tempStudent.getFirstName() + " " + tempStudent.getLastName());
//            System.out.println("Email: " + tempStudent.getEmailAddress());
//            System.out.println("Matricular number: " + tempStudent.getMatriculation().getMatriculationNumber());
//            System.out.println("Enrolled in: " + tempStudent.getEnrolledCurriculum().getCurriculumName());
//            System.out.println("Courses: ");
//
//            for (int j = 0; j < tempStudent.getEnrolledCourses().size(); j++) {
//                System.out.println(tempStudent.getEnrolledCourses().get(j).getStudyCourseName());
//            }
//
//            System.out.println();
//        }

        // Actual 'Student Management Application'
        boolean runTimeLoop = true;
        int menuOption;
        UserInput menuInput = new UserInput();

        while (runTimeLoop) {
            menuChoices();
            menuOption = menuInput.userInputInt("Choose operation: ", "[1-5]", 1);

            switch (menuOption) {

                case 1:
                    System.out.println();
                    printListOfEnlistedStudents(othRegensburg);
                    break;

                case 2:
                    System.out.println();
                    printSpecificStudentsData(othRegensburg);
                    break;

                case 5:
                    System.out.println();
                    System.out.println("Exit management application NOW!");
                    runTimeLoop = false;
            }
        }
    }

    public static void printSpecificStudentsData(University university) {
        printListOfEnlistedStudents(university);

        UserInput userInput = new UserInput();
        String indexRegEx = "[" + 0 + "-" + university.getEnlistedStudent().size() + "]";
        int maximalLength = String.valueOf(university.getEnlistedStudent().size()).length();
        int indexStudent = userInput.userInputInt("Enter index: ", indexRegEx, maximalLength) - 1;

        Student tempStudent = university.getEnlistedStudent().get(indexStudent);

        System.out.println("");
        System.out.println("Name: " + tempStudent.getFirstName() + " " + tempStudent.getLastName());
        System.out.println("Email: " + tempStudent.getEmailAddress());
        System.out.println("Matricular number: " + tempStudent.getMatriculation().getMatriculationNumber());
        System.out.println("Enrolled in: " + tempStudent.getEnrolledCurriculum().getCurriculumName());
        System.out.println("Courses: ");

        for (int j = 0; j < tempStudent.getEnrolledCourses().size(); j++) {
            System.out.println("- " + tempStudent.getEnrolledCourses().get(j).getStudyCourseName());
        }

        System.out.println();
    }

    public static void printListOfEnlistedStudents(University university) {
        Student tempStudent;

        for (int i = 0; i < university.getEnlistedStudent().size(); i++) {
            tempStudent = university.getEnlistedStudent().get(i);

            System.out.println((i + 1) + ". " + tempStudent.getMatriculation().getMatriculationNumber() + " " + tempStudent.getLastName());
        }
    }

    public static void menuChoices() {
        System.out.println();
        System.out.println("1: Print summary of all enlisted students.");
        System.out.println("2: Print data of a specific student.");
        System.out.println("1: Print summary of all enlisted students.");
        System.out.println("1: Print summary of all enlisted students.");
        System.out.println("5: Exit student management application");

    }
}