/**
 * Class description
 *
 * @author Sarah Guarino
 * @version 1.0
 */
public class WageCalculatorValidator {
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
        if((1 <= inputToEvaluate) && (inputToEvaluate <= 12)) {
            return true;
        } else {
            return false;
        }
    }
}
