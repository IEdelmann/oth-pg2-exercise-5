import myUtilities.UserInput;

import java.util.ArrayList;

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
        StudyCourse courseProgrammingTwo = new StudyCourse("Programmieren 2", 8, 1);
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
        curriculumGeneralInformationBachelor.addStudyCourseToCurriculum(courseProgrammingTwo);

        // Test student
        MatriculationNumber firstTestStudentMatricularNumber = new MatriculationNumber();
        firstTestStudentMatricularNumber.setMatriculationNumber("12345679");
        othRegensburg.addStudentToUniversity("Ringo", "Kugelfade",  firstTestStudentMatricularNumber, curriculumEconomicInformationBachelor);
        // Second test student - this time adding the student to the university!
        MatriculationNumber secondTestStudentMatricularNumber = new MatriculationNumber();
        secondTestStudentMatricularNumber.setMatriculationNumber("42042069");
        othRegensburg.addStudentToUniversity("Jack", "Peppermint", secondTestStudentMatricularNumber, curriculumEconomicInformationMaster);
        // Third test student - this time utilizing the automatically generated matriculation number
        MatriculationNumber thirdTestStudentMatriculationNumber = new MatriculationNumber();
        othRegensburg.addStudentToUniversity("Natali", "Dore", thirdTestStudentMatriculationNumber, curriculumGeneralInformationBachelor);

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
            menuOption = menuInput.userInputInt("Choose operation: ", "[1-6]", 1);

            switch (menuOption) {

                case 1:
                    System.out.println();
                    printListOfEnlistedStudents(othRegensburg);
                    break;

                case 2:
                    System.out.println();
                    printSpecificStudentsData(othRegensburg);
                    break;

                case 3:
                    System.out.println();
                    addNewStudent(othRegensburg);
                    break;

                case 4:
                    System.out.println();
                    enterMarkToStudentsCourse(othRegensburg);
                    break;

                case 5:
                    System.out.println();
                    editEnlistedStudentsData(othRegensburg);
                    break;

                case 6:
                    System.out.println();
                    System.out.println("Exit management application NOW!");
                    runTimeLoop = false;
            }
        }
    }

    public static void enterMarkToStudentsCourse(University university) {
        Student tempStudent = chooseStudentIndex(university);
        StudyCourse tempStudyCourse = chooseStudyCourseIndex(tempStudent);

        System.out.println("Current mark in " + tempStudyCourse.getStudyCourseName() + ": " + tempStudyCourse.getCourseMark());

        UserInput userInput = new UserInput();
        String inputRegEx = "[" + 1 + "-" + 6 + "]";
        int inputMaxLength = 1;
        int newStudyCourseMark = userInput.userInputInt("Enter new mark: ", inputRegEx, inputMaxLength);

        tempStudyCourse.setCourseMark(newStudyCourseMark);
        System.out.println("New mark set!\n");
    }

    public static void editEnlistedStudentsData(University university) {
        Student tempStudent = chooseStudentIndex(university);
        UserInput userInput = new UserInput();
        int menuOptionMainLoop;
        boolean runTimeFlag = true;
        String newFirstName;
        String newLastName;
        int menuOptionNewCurriculum;
        String inputRegEx;
        int arrayListLength;
        int inputMaxLength;

        while (runTimeFlag) {
            System.out.println("Change data of: \n");
            System.out.println("1. First name: " + tempStudent.getFirstName());
            System.out.println("2. Last name: " + tempStudent.getLastName());
            System.out.println("3. Current curriculum: " + tempStudent.getEnrolledCurriculum().getCurriculumName());
            System.out.println("4. Exit editing.");
            menuOptionMainLoop = userInput.userInputInt("Choose entry to change: ", "[1-4]", 1) - 1;


            switch (menuOptionMainLoop) {
                case 0 -> {
                    newFirstName = userInput.userInputPureString("Enter new first name: ");
                    tempStudent.changeFirstName(newFirstName);
                    System.out.println("First name changed!\n");
                }

                case 1 -> {
                    newLastName = userInput.userInputPureString("Enter new last name: ");
                    tempStudent.changeLastName(newLastName);
                    System.out.println("Last name changed!\n");
                }

                case 2 -> {
                    arrayListLength = university.getAvailableStudyCurricula().size();
                    for (int i = 0; i < arrayListLength; i++) {
                        System.out.println((i + 1) + ": " + university.getAvailableStudyCurricula().get(i).getCurriculumName());
                    }
                    inputRegEx = "[" + 1 + "-" + arrayListLength + "]";
                    inputMaxLength = String.valueOf(university.getAvailableStudyCurricula().size()).length();
                    menuOptionNewCurriculum = userInput.userInputInt("Enter new curriculum: ", inputRegEx, inputMaxLength) - 1;
                    tempStudent.changeCurriculum(university.getAvailableStudyCurricula().get(menuOptionNewCurriculum));
                    System.out.println("Curriculum changed!\n");
                }

                case 3 -> {
                    System.out.println("Exit editing mode now!");
                    runTimeFlag = false;
                }

                default -> System.out.println("This line of code was not supposed to ever see the light of the day...");
            }
        }

    }

    // Option: 1 = use ArrayList of StudyCurriculum; 2 = user ArrayList of StudyCourse
//    public static int getIndexOfArrayList(University university, int option) {
//        UserInput userInput = new UserInput();
//
//        if (option == 1) {
//
//        }
//
//        ArrayList<StudyCourse> = university.getAvailableStudyCurricula()
//
//        for (int i = 0; i < university.getAvailableStudyCurricula().size(); i++) {
//            System.out.println((i + 1) + ". " + university.getAvailableStudyCurricula().get(i).getCurriculumName());
//        }
//        System.out.println();
//        String indexRegEx = "[" + 1 + "-" + university.getAvailableStudyCurricula().size() + "]";
//        int maximalLength = String.valueOf(university.getAvailableStudyCurricula().size()).length();
//
//        return userInput.userInputInt("Enter option: ", indexRegEx, maximalLength) - 1;
//    }

    public static void addNewStudent(University university) {
        UserInput userInput = new UserInput();
        String firstName = userInput.userInputPureString("Enter first name: ");
        String lastName = userInput.userInputPureString("Enter last name: ");

        for (int i = 0; i < university.getAvailableStudyCurricula().size(); i++) {
            System.out.println((i + 1) + ". " + university.getAvailableStudyCurricula().get(i).getCurriculumName());
        }
        System.out.println();
        String indexRegEx = "[" + 1 + "-" + university.getAvailableStudyCurricula().size() + "]";
        int inputMaxLength = String.valueOf(university.getAvailableStudyCurricula().size()).length();

        int chooseCurriculum = userInput.userInputInt("Choose curriculum: ", indexRegEx, inputMaxLength) - 1;
        university.addStudentToUniversity(firstName, lastName, new MatriculationNumber(), university.getAvailableStudyCurricula().get(chooseCurriculum));

        System.out.println("New student added :)\n");
    }

    public static StudyCourse chooseStudyCourseIndex(Student student) {

        for (int i = 0; i < student.getEnrolledCourses().size(); i++) {
            System.out.println((i + 1) + ": " + student.getEnrolledCourses().get(i).getStudyCourseName());
        }

        UserInput userInput = new UserInput();
        String indexRegEx = "[" + 1 + "-" + student.getEnrolledCourses().size() + "]";
        int inputMaxLength = String.valueOf(student.getEnrolledCourses().size()).length();
        int indexCourse = userInput.userInputInt("Enter index: ", indexRegEx, inputMaxLength) - 1;

        return student.getEnrolledCourses().get(indexCourse);
    }

    public static Student chooseStudentIndex(University university) {

        printListOfEnlistedStudents(university);

        UserInput userInput = new UserInput();
        String indexRegEx = "[" + 1 + "-" + university.getEnlistedStudent().size() + "]";
        int inputMaxLength = String.valueOf(university.getEnlistedStudent().size()).length();
        int indexStudent = userInput.userInputInt("Enter index: ", indexRegEx, inputMaxLength) - 1;

        return university.getEnlistedStudent().get(indexStudent);
    }

    public static void printSpecificStudentsData(University university) {
//        printListOfEnlistedStudents(university);
//
//        UserInput userInput = new UserInput();
//        String indexRegEx = "[" + 0 + "-" + university.getEnlistedStudent().size() + "]";
//        int maximalLength = String.valueOf(university.getEnlistedStudent().size()).length();
//        int indexStudent = userInput.userInputInt("Enter index: ", indexRegEx, maximalLength) - 1;
//
//        Student tempStudent = university.getEnlistedStudent().get(indexStudent);

        Student tempStudent = chooseStudentIndex(university);

        System.out.println("");
        System.out.println("Name: " + tempStudent.getFirstName() + " " + tempStudent.getLastName());
        System.out.println("Email: " + tempStudent.getEmailAddress());
        System.out.println("Matriculation number: " + tempStudent.getMatriculation().getMatriculationNumber());
        System.out.println("Enrolled in: " + tempStudent.getEnrolledCurriculum().getCurriculumName());
        System.out.println("Courses: ");

        ArrayList<StudyCourse> tempArray = tempStudent.getEnrolledCourses();
        for (int j = 0; j < tempStudent.getEnrolledCourses().size(); j++) {
            System.out.println("- " + tempArray.get(j).getStudyCourseName() + " - mark: " + tempArray.get(j).getCourseMark());
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
        System.out.println("3: Add new student.");
        System.out.println("4: Add a mark to a course.");
        System.out.println("5: Edit student data.");
        System.out.println("6: Exit student management application");

    }
}