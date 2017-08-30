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
}
