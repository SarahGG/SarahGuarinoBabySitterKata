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
        Integer bedTime;

        do {
            startTime = Menu.requestTimeFromUser("What time did you start?\n>: ");
            wageCalculator.setStartTime(startTime);
            endTime = Menu.requestTimeFromUser("What time did you leave?\n>: ");
            wageCalculator.setEndTime(endTime);

            if(!(Validator.rangeIsInOrder(wageCalculator.getStartTime(), wageCalculator.getEndTime()))) {
                Menu.incorrectRangeWarning();
                continue;
            }

            bedTime = Menu.requestTimeFromUser("What is the child's bed time?\n>: ");
            wageCalculator.setBedTime(bedTime);
        }
        while(!(Validator.rangeIsInOrder(wageCalculator.getStartTime(), wageCalculator.getEndTime())));

        Menu.printMenuHeader();
        Menu.printTotalHours(wageCalculator);
        Menu.printBaseHours(wageCalculator);
    }
}
