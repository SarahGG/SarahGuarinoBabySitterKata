/**
 * Validates user input for the WageCalculator application
 *
 * @author Sarah Guarino
 * @version 1.0
 */
@SuppressWarnings("WeakerAccess")
public class Validator {
    public static boolean isWholeNumber(String inputToEvaluate) {
        try {
            //noinspection ResultOfMethodCallIgnored
            Integer.parseInt(inputToEvaluate);
            return true;
        } catch (NumberFormatException notAnInteger) {
            return false;
        }
    }

    public static boolean isWithinTimeRange(Integer inputToEvaluate) {
        return((1 <= inputToEvaluate) && (inputToEvaluate <= 12));
    }

    public static boolean rangeIsInOrder(Integer startTime, Integer endTime) {
        return ((endTime - startTime) >= 0);
    }
}
