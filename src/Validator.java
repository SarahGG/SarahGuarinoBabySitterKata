/**
 * Validates user input for the WageCalculator application
 *
 * @author Sarah Guarino
 * @version 1.0
 */
class Validator {
    static boolean isWholeNumber(String inputToEvaluate) {
        try {
            //noinspection ResultOfMethodCallIgnored
            Integer.parseInt(inputToEvaluate);
            return true;
        } catch (NumberFormatException notAnInteger) {
            return false;
        }
    }

    static boolean isWithinTimeRange(Integer inputToEvaluate) {
        return((1 <= inputToEvaluate) && (inputToEvaluate <= 12));
    }

    static boolean rangeIsInOrder(Integer startTime, Integer endTime) {
        Integer totalHoursWorked = endTime - startTime;
        return (totalHoursWorked >= 0);
    }
}
