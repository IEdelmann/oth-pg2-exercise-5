import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class MatriculationNumber {
    private String matriculationNumber;

    public MatriculationNumber() {
        this.matriculationNumber = "NULL";
    }

    public String getMatriculationNumber() {
        return matriculationNumber;
    }

    Matcher inputMatcher;
    boolean matchFound;
    String validMatriculationRegEx = "[0-9]";
    int validMatriculationLength = 8;

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
