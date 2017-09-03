import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Class description
 *
 * @author Sarah Guarino
 * @version 1.0
 */
class Menu {
    private static DecimalFormat decimalFormat;
    private static String BASERATE;
    private static String DISCOUNTRATE;
    private static String PREMIUMRATE;

    public Menu() {
        decimalFormat = new DecimalFormat("0.00");
        BASERATE = decimalFormat.format(12.00);
        DISCOUNTRATE = decimalFormat.format(8.00);
        PREMIUMRATE = decimalFormat.format(16.00);
    }

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
        System.out.printf("Total hours worked: %d\n", wageCalculator.getTotalHours());
    }

    static void printBaseHours(WageCalculator wageCalculator) {
        System.out.printf("\t%s/hr * %d hours\t= $%s\n",
                BASERATE,
                wageCalculator.getBaseHours(),
                wageCalculator.getBasePay());
    }

    static void printDiscountHours(WageCalculator wageCalculator) {
        System.out.printf("\t%s/hr * %d hours\t= $%s\n",
                DISCOUNTRATE,
                wageCalculator.getDiscountHours(),
                wageCalculator.getDiscountPay());
    }

    static void printPremiumHours(WageCalculator wageCalculator) {
        System.out.printf("\t%s/hr * %d hours\t= $00.000\n", PREMIUMRATE, wageCalculator.getPremiumHours());
    }

    static void printMenuHeader() {
        System.out.println("\n** TODAY'S TIME SHEET *********");
    }
}
