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

        MatriculationNumber myMatriculNumber = new MatriculationNumber();
        myMatriculNumber.setMatriculationNumber("12345679");
        System.out.println("Input Matricul: " + myMatriculNumber.getMatriculationNumber());
    }
}