import java.util.Scanner;

/**
 * Class description
 *
 * @author Sarah Guarino
 * @version 1.0
 */
public class Menu {
    static Integer requestTimeFromUser(String prompt) {
        Scanner scnr = new Scanner(System.in);
        String userInputTime;

        System.out.print(prompt);
        userInputTime = scnr.nextLine();

        while(!(Validator.isWholeNumber(userInputTime))
                || !(Validator.isWithinTimeRange(Integer.parseInt(userInputTime)))) {
            System.out.print("Please enter a whole number between 1 and 12 only.\n>: ");
            userInputTime = scnr.nextLine();
        }

        return Integer.parseInt(userInputTime);
    }

    static void incorrectRangeWarning() {
        System.out.println("Warning! Your start time and end time were not in the right order. Please try again.");
    }

    static void printTotalHours(WageCalculator wageCalculator) {
        System.out.printf("You have worked a total of %d hours", wageCalculator.getTotalHours());
    }
}
