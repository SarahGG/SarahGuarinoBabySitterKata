import java.util.Scanner;

/**
 * Interacts with the user, displaying input depending on user response.
 *
 * @author Sarah Guarino
 * @version 1.0
 */
class Menu {
    static HoursWorked getPunchCardTimes() {
        HoursWorked hoursWorked = new HoursWorked();

        Menu.printMenuGreeting();

        do {
            hoursWorked.setTimes(
                    requestTimeFromUser("What time did you start?\n>: "),
                    requestTimeFromUser("What time did you leave?\n>: "),
                    requestTimeFromUser("What is the child's bed time?\n>: ")
            );

            if(Validator.rangeIsInOrder(hoursWorked.getStartTime(), hoursWorked.getEndTime())) {
                break;
            }

            incorrectRangeWarning();
        } while(true);

        return hoursWorked;
    }

    private static Integer requestTimeFromUser(String prompt) {
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

    private static void incorrectRangeWarning() {
        System.out.println("Warning! Your start time and end time were not in the right order. Please try again.");
    }

    static void printPayResults(WageCalculator wageCalculator) {
        printMenuHeader();
        printTotalHours(wageCalculator);
        printBaseHours(wageCalculator);
        printDiscountHours(wageCalculator);
        printPremiumHours(wageCalculator);
        printTotalPay(wageCalculator);
        printMenuFooter();
    }

    private static void printTotalHours(WageCalculator wageCalculator) {
        System.out.printf("Total hours worked = %d\n", wageCalculator.getTotalHours());
    }

    private static void printTotalPay(WageCalculator wageCalculator) {
        System.out.printf("Total Earned \t\t\t= $%s\n", wageCalculator.getTotalPay());
    }

    private static void printBaseHours(WageCalculator wageCalculator) {
        System.out.printf("\t%s/hr * %d hours\t= $%s\n",
                HourlyRates.getBaseRate().toString(),
                wageCalculator.getBaseHours(),
                wageCalculator.getBasePay());
    }

    private static void printDiscountHours(WageCalculator wageCalculator) {
        System.out.printf("\t%s/hr * %d hours\t= $%s\n",
                HourlyRates.getDiscountRate().toString(),
                wageCalculator.getDiscountHours(),
                wageCalculator.getDiscountPay());
    }

    private static void printPremiumHours(WageCalculator wageCalculator) {
        System.out.printf("\t%s/hr * %d hours\t= $%s\n",
                HourlyRates.getPremiumRate().toString(),
                wageCalculator.getPremiumHours(),
                wageCalculator.getPremiumPay());
    }

    private static void printMenuGreeting() {
        System.out.println("** DAILY WAGE CALCULATOR ******");
    }

    private static void printMenuHeader() {
        System.out.println("\n** TODAY'S TIME SHEET *********");
    }

    private static void printMenuFooter() {
        System.out.println("\n** THANK YOU ******************");
    }
}
