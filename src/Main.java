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
        Integer usersTimeInput;

        usersTimeInput = Menu.requestTimeFromUser("What time did you start?\n>: ");
        wageCalculator.setStartTime(usersTimeInput);
        usersTimeInput = Menu.requestTimeFromUser("What time did you leave?\n>: ");
        wageCalculator.setEndTime(usersTimeInput);
    }
}