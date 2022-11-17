import myUtilities.UserInput;
public class Main {

    public static void main(String[] args) {

        UserInput inputMatric = new UserInput();
//        int inputInt = inputMatric.userInputInt("Input: ");
//        int inputTwo = inputMatric.userInputInt("hallo: ");

        UserInput intVariable = new UserInput();
        String regexVariable = intVariable.userInputInt("Mit RegEx: ", "[1-9]", 8);

//        System.out.println("Dein Output: " + inputInt);
//        System.out.println("Hallo: " + inputTwo);
        System.out.println("Mit Regex Output: " + regexVariable);
    }
}