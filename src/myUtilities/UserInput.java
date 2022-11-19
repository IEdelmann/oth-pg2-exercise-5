package myUtilities;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

// Prototype of my now enhanced 'userInput' function! Now utilizing the power of actual regex;
public class UserInput {
    static Scanner myScanner = new Scanner(System.in);

    // Return an Integer;
    public int userInputInt(String prompt, String regEx, int inputLength) {
        System.out.println(prompt);
        Pattern inputPatter = Pattern.compile(regEx);
        return Integer.parseInt(userInputString(inputPatter, inputLength));
    }

    // Return an Integer as a String;
    public String userInputString(String prompt, String regEx, int inputLength) {
        System.out.println(prompt);
        Pattern inputPatter = Pattern.compile(regEx);
        return userInputString(inputPatter, inputLength);
    }

    // Return just a String without any funky regex business;
    public String userInputPureString(String prompt) {
        System.out.println(prompt);
        return myScanner.nextLine();
    }

    // This function actually is only used as part of the other ones, hence it's private;
    private String userInputString(Pattern inputPatter, int inputLength) {
        String userInput;
        Matcher inputMatcher;
        boolean matchFound;

        // As long as the match is not found OR the input length isn't right, it will keep asking for input;
        do {
            userInput = myScanner.nextLine();
            inputMatcher = inputPatter.matcher(userInput);
            matchFound = inputMatcher.find();
        } while (!(matchFound) || !(userInput.length() == inputLength));

        return userInput;
    }
}
