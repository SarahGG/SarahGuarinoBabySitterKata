import org.junit.Before;
import org.junit.Test;

import java.text.DecimalFormat;

import static org.junit.Assert.assertEquals;

/**
 * Test Class for Sarah's daily baby sitting wage calculator.
 * Default values are as such:
 * Start Time: 5:00 PM
 * End Time: 4:00 AM
 * Bed Time: 9:00 PM
 * Premium Time: 12:00 AM
 *
 * All values can be assumed to be their default, with any
 * differences being stated explicitly in the title of the
 * test.
 *
 * @author Sarah Guarino
 * @version 1.0
 */
public class WageCalculatorTest {
    private WageCalculator wageCalculator;
    private HoursWorked hoursWorked;
    private DecimalFormat format;

    @Before
    public void setUp() {
        hoursWorked = new HoursWorked();
        format = new DecimalFormat("0.00");
    }

    @Test
    public void endingAtTwelveReturnsSevenTotalHours() {
        hoursWorked.setTimes(5,12,9, 12);
        wageCalculator = new WageCalculator(hoursWorked);
        assertEquals("7", wageCalculator.getTotalHours().toString());
    }

    @Test
    public void endingAtTwoReturnsNineTotalHours() {
        hoursWorked.setTimes(5,2,9, 12);
        wageCalculator = new WageCalculator(hoursWorked);
        assertEquals("9", wageCalculator.getTotalHours().toString());
    }

    @Test
    public void defaultDayReturnsFourBaseHours() {
        hoursWorked.setTimes(5,4,9,12);
        wageCalculator = new WageCalculator(hoursWorked);
        assertEquals("4", wageCalculator.getBaseHours().toString());
    }

    @Test
    public void endingAtEightReturnsThreeBaseHours() {
        hoursWorked.setTimes(5,8,9, 12);
        wageCalculator = new WageCalculator(hoursWorked);
        assertEquals("3", wageCalculator.getBaseHours().toString());
    }

    @Test
    public void bedTimeAtTwoReturnsSevenBaseHours() {
        hoursWorked.setTimes(5,4,2, 12);
        wageCalculator = new WageCalculator(hoursWorked);
        assertEquals("7", wageCalculator.getBaseHours().toString());
    }

    @Test
    public void defaultDayReturnsThreeDisCountHours() {
        hoursWorked.setTimes(5,4,9,12);
        wageCalculator = new WageCalculator(hoursWorked);
        assertEquals("3", wageCalculator.getDiscountHours().toString());
    }

    @Test
    public void bedTimeAtOneReturnsZeroDisCountHours() {
        hoursWorked.setTimes(5,4,1, 12);
        wageCalculator = new WageCalculator(hoursWorked);
        assertEquals("0", wageCalculator.getDiscountHours().toString());
    }

    @Test
    public void startingAtTenReturnsTwoDiscountHours() {
        hoursWorked.setTimes(10,4,9, 12);
        wageCalculator = new WageCalculator(hoursWorked);
        assertEquals("2", wageCalculator.getDiscountHours().toString());
    }

    @Test
    public void endingAtElevenReturnsTwoDiscountHours() {
        hoursWorked.setTimes(5,11,9, 12);
        wageCalculator = new WageCalculator(hoursWorked);
        assertEquals("2", wageCalculator.getDiscountHours().toString());
    }

    @Test
    public void endingAtElevenReturnsZeroPremiumHours() {
        hoursWorked.setTimes(5,11,9, 12);
        wageCalculator = new WageCalculator(hoursWorked);
        assertEquals("0", wageCalculator.getPremiumHours().toString());
    }

    @Test
    public void defaultDayReturnsFourPremiumHours() {
        hoursWorked.setTimes(5,4,9,12);
        wageCalculator = new WageCalculator(hoursWorked);
        assertEquals("4", wageCalculator.getPremiumHours().toString());
    }

    @Test
    public void endTimeAtTwoReturnsTwoPremiumHours() {
        hoursWorked.setTimes(5,2,9, 12);
        wageCalculator = new WageCalculator(hoursWorked);
        assertEquals("2", wageCalculator.getPremiumHours().toString());
    }

    @Test
    public void defaultDayBasePayReturnsFortyEightDollars() {
        hoursWorked.setTimes(5,4,9,12);
        wageCalculator = new WageCalculator(hoursWorked);
        assertEquals("48.00", format.format(wageCalculator.getBasePay()));
    }

    @Test
    public void zeroBaseHoursReturnsZeroDollars() {
        hoursWorked.setTimes(5,4,5, 12);
        wageCalculator = new WageCalculator(hoursWorked);
        assertEquals("0.00", format.format(wageCalculator.getBasePay()));
    }

    @Test
    public void sevenBaseHoursReturnsEightyFourDollars() {
        hoursWorked.setTimes(5,4,12, 12);
        wageCalculator = new WageCalculator(hoursWorked);
        assertEquals("84.00", format.format(wageCalculator.getBasePay()));
    }

    @Test
    public void defaultDayDiscountPayReturnsTwentyFourDollars() {
        hoursWorked.setTimes(5,4,9,12);
        wageCalculator = new WageCalculator(hoursWorked);
        assertEquals("24.00", format.format(wageCalculator.getDiscountPay()));
    }

    @Test
    public void sixDiscountHoursReturnsFortyEightDollars() {
        hoursWorked.setTimes(5,4,6, 12);
        wageCalculator = new WageCalculator(hoursWorked);
        assertEquals("48.00", format.format(wageCalculator.getDiscountPay()));
    }

    @Test
    public void zeroDiscountHoursReturnsZeroDollars() {
        hoursWorked.setTimes(5,4,12,12);
        wageCalculator = new WageCalculator(hoursWorked);
        assertEquals("0.00", format.format(wageCalculator.getDiscountPay()));
    }

    @Test
    public void defaultDayPremiumHoursReturnsSixtyFourDollars() {
        hoursWorked.setTimes(5,4,9,12);
        wageCalculator = new WageCalculator(hoursWorked);
        assertEquals("64.00", format.format(wageCalculator.getPremiumPay()));
    }

    @Test
    public void twoPremiumHoursReturnsThirtyTwoDollars() {
        hoursWorked.setTimes(1,2,9, 12);
        wageCalculator = new WageCalculator(hoursWorked);
        assertEquals("32.00", format.format(wageCalculator.getPremiumPay()));
    }

    @Test
    public void zeroPremiumHoursReturnsZeroDollars() {
        hoursWorked.setTimes(5,12,9, 12);
        wageCalculator = new WageCalculator(hoursWorked);
        assertEquals("0.00", format.format(wageCalculator.getPremiumPay()));
    }

    @Test
    public void defaultDayReturnsOneHundredThirtySixDollarsTotal() {
        hoursWorked.setTimes(5,4,9,12);
        wageCalculator = new WageCalculator(hoursWorked);
        assertEquals("136.00", format.format(wageCalculator.getTotalPay()));
    }

    @Test
    public void endTimeAtNineReturnsFortyEightDollarsTotal() {
        hoursWorked.setTimes(5,9,9, 12);
        wageCalculator = new WageCalculator(hoursWorked);
        assertEquals("48.00", format.format(wageCalculator.getTotalPay()));
    }

    @Test
    public void startTimeAtTwelveReturnsSixtyFourDollarsTotal() {
        hoursWorked.setTimes(12,4,9, 12);
        wageCalculator = new WageCalculator(hoursWorked);
        assertEquals("64.00", format.format(wageCalculator.getTotalPay()));
    }

    @Test
    public void premiumTimeAtElevenReturnsOneHundredFortyFourDollars() {
        hoursWorked.setTimes(5,4,9, 11);
        wageCalculator = new WageCalculator(hoursWorked);
        assertEquals("144.00", format.format(wageCalculator.getTotalPay()));
    }
}
