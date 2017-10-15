/**
 * Carries the different hourly rates
 *
 * @author Sarah Guarino
 * @version 1.0
 */
@SuppressWarnings({"WeakerAccess", "SameReturnValue"})
public class HourlyRates {
    @SuppressWarnings("WeakerAccess")
    final public static Double BASERATE = 12.00;
    @SuppressWarnings("WeakerAccess")
    final public static Double DISCOUNTRATE = 8.00;
    @SuppressWarnings("WeakerAccess")
    final public static Double PREMIUMRATE = 16.00;

    public static Double getBaseRate() {
        return BASERATE;
    }

    public static Double getDiscountRate() {
        return DISCOUNTRATE;
    }

    public static Double getPremiumRate() {
        return PREMIUMRATE;
    }
}
