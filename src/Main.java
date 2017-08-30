import java.util.Scanner;

/**
 * Main class for Sarah's daily babysitting wage calculator.
 *
 * @author Sarah Guarino
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        String userInputTime;

        System.out.print("What time did you start?\n>: ");
        userInputTime = scnr.nextLine();

        while(!(Validator.isWholeNumber(userInputTime))) {
            System.out.print("Please enter a whole number only.\n>: ");
            userInputTime = scnr.nextLine();
        }
    }
}
