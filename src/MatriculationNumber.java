import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatriculationNumber {
    private static int matriculationNumberCounter = 0;      // This variable is important to generate matriculation numbers;
    private String matriculationNumber;

    // Just the creation of a new MatriculationNumber objects sets the number by generating one;
    public MatriculationNumber() {
        MatriculationNumber.matriculationNumberCounter++;
        this.matriculationNumber = generateMatriculationNumber();
    }

    public String getMatriculationNumber() {
        return matriculationNumber;
    }

    // Those variables are needed for the setter - only a valid number will be set;
    Matcher inputMatcher;
    boolean matchFound;
    String validMatriculationRegEx = "[0-9]";
    int validMatriculationLength = 8;

    private String generateMatriculationNumber() {
        int matriculationNumberFillUp = validMatriculationLength - String.valueOf(MatriculationNumber.matriculationNumberCounter).length();
        String newMatriculationNumber = "";

        for (int i = 0; i < matriculationNumberFillUp; i++) {
            newMatriculationNumber += "0";
        }
        newMatriculationNumber += Integer.toString(MatriculationNumber.matriculationNumberCounter);

        return newMatriculationNumber;
    }

    public void setMatriculationNumber(String input) {
        Pattern inputPattern = Pattern.compile(validMatriculationRegEx);
        inputMatcher = inputPattern.matcher(input);
        matchFound = inputMatcher.find();

        if (matchFound && input.length() == validMatriculationLength) {
            this.matriculationNumber = input;
        } else {
            System.out.println("Ungueltige Matrielnummer! Wert nicht gesetzt!");
        }
    }
}
