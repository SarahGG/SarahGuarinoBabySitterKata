import java.util.Scanner;

/**
 * Main class for Sarah's daily babysitting wage calculator.
 *
 * @author Sarah Guarino
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        WageCalculator wageCalculator = new WageCalculator();
        Integer startTime;
        Integer endTime;

        do {
            startTime = Menu.requestTimeFromUser("What time did you start?\n>: ");
            wageCalculator.setStartTime(startTime);
            endTime = Menu.requestTimeFromUser("What time did you leave?\n>: ");
            wageCalculator.setEndTime(endTime);

            if(!(Validator.rangeIsInOrder(startTime, endTime))) {
                Menu.incorrectRangeWarning();
            }
        }
        while(!(Validator.rangeIsInOrder(startTime, endTime)));
    }
}
