package myUtilities;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

public class UserInput {
    static Scanner myScanner = new Scanner(System.in);

    public String userInputInt(String prompt, String regEx, int inputLength) {
        System.out.println(prompt);
        Pattern inputPatter = Pattern.compile(regEx);
        return userInputString(inputPatter, inputLength);
    }

    private String userInputString(Pattern inputPatter, int inputLength) {
        String userInput;
        Matcher inputMatcher;
        boolean matchFound;

        do {
            userInput = myScanner.nextLine();
            inputMatcher = inputPatter.matcher(userInput);
            matchFound = inputMatcher.find();
        } while (!(matchFound) || !(userInput.length() == inputLength));

        return userInput;
    }
}
