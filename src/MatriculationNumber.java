import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class MatriculationNumber {
    private static int matriculationNumberCounter = 0;
    private String matriculationNumber;

    public MatriculationNumber() {
        MatriculationNumber.matriculationNumberCounter++;
        this.matriculationNumber = generateMatriculationNumber();
    }

    public String getMatriculationNumber() {
        return matriculationNumber;
    }

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
