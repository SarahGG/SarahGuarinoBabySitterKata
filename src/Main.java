/**
 * Main class for Sarah's daily babysitting wage calculator.
 *
 * @author Sarah Guarino
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        HoursWorked hoursWorked = new HoursWorked();
        WageCalculator wageCalculator;

        Integer startTime;
        Integer endTime;
        Integer bedTime;

        Menu.printMenuGreeting();

        do {
            startTime = Menu.requestTimeFromUser("What time did you start?\n>: ");
            hoursWorked.setStartTime(startTime);
            endTime = Menu.requestTimeFromUser("What time did you leave?\n>: ");
            hoursWorked.setEndTime(endTime);

            if(!(Validator.rangeIsInOrder(hoursWorked.getStartTime(), hoursWorked.getEndTime()))) {
                Menu.incorrectRangeWarning();
                continue;
            }

            bedTime = Menu.requestTimeFromUser("What is the child's bed time?\n>: ");
            hoursWorked.setBedTime(bedTime);
        }
        while(!(Validator.rangeIsInOrder(hoursWorked.getStartTime(), hoursWorked.getEndTime())));

        wageCalculator = new WageCalculator(hoursWorked);

        Menu.printMenuHeader();
        Menu.printTotalHours(wageCalculator);
        Menu.printBaseHours(wageCalculator);
        Menu.printDiscountHours(wageCalculator);
        Menu.printPremiumHours(wageCalculator);
        Menu.printTotalPay(wageCalculator);
        Menu.printMenuFooter();
    }
}
