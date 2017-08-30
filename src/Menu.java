import java.util.Scanner;

import static sun.plugin.AppletViewer.setStartTime;

/**
 * Class description
 *
 * @author Sarah Guarino
 * @version 1.0
 */
public class Menu {
    static void requestStartTimeFromUser(WageCalculator wageCalculator) {
        Scanner scnr = new Scanner(System.in);
        String userInputTime;

        System.out.print("What time did you start?\n>: ");
        userInputTime = scnr.nextLine();

        while(!(Validator.isWholeNumber(userInputTime))
                || !(Validator.isWithinTimeRange(Integer.parseInt(userInputTime)))) {
            System.out.print("Please enter a whole number between 1 and 12 only.\n>: ");
            userInputTime = scnr.nextLine();
        }

        wageCalculator.setStartTime(Integer.parseInt(userInputTime));
    }
}
