/**
 * Carries the different hourly rates
 *
 * @author Sarah Guarino
 * @version 1.0
 */
class HourlyRates {
    final private static Double BASERATE = 12.00;
    final private static Double DISCOUNTRATE = 8.00;
    final private static Double PREMIUMRATE = 16.00;

    static Double getBaseRate() {
        return BASERATE;
    }

    static Double getDiscountRate() {
        return DISCOUNTRATE;
    }

    static Double getPremiumRate() {
        return PREMIUMRATE;
    }


}
