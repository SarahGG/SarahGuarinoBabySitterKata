import org.junit.Before;
import org.junit.Test;

import java.text.DecimalFormat;

import static org.junit.Assert.assertEquals;

/**
 * Test Class for Sarah's daily baby sitting wage calculator.
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
    public void workingFiveToMidNightReturnsSeven() {
        hoursWorked.setStartTime(5);
        hoursWorked.setEndTime(12);
        wageCalculator = new WageCalculator(hoursWorked);
        assertEquals("7", wageCalculator.getTotalHours().toString());
    }

    @Test
    public void workingFiveToTwoReturnsNine() {
        hoursWorked.setStartTime(5);
        hoursWorked.setEndTime(2);
        wageCalculator = new WageCalculator(hoursWorked);
        assertEquals("9", wageCalculator.getTotalHours().toString());
    }

    @Test
    public void startTimeAtFiveWithBedTimeAtNineReturnsFourBaseHours() {
        hoursWorked.setTimes(5,4,9, 12);
        wageCalculator = new WageCalculator(hoursWorked);
        assertEquals("4", wageCalculator.getBaseHours().toString());
    }

    @Test
    public void startTimeAtFiveWithEndTimeAtEightAndBedTimeAtNineReturnsThreeBaseHours() {
        hoursWorked.setTimes(5,8,9, 12);
        wageCalculator = new WageCalculator(hoursWorked);
        assertEquals("3", wageCalculator.getBaseHours().toString());
    }

    @Test
    public void startTimeAtFiveWithBedTimeAtTwoReturnsSevenBaseHours() {
        hoursWorked.setTimes(5,4,2, 12);
        wageCalculator = new WageCalculator(hoursWorked);
        assertEquals("7", wageCalculator.getBaseHours().toString());
    }

    @Test
    public void bedTimeAtNineReturnsThreeDisCountHours() {
        hoursWorked.setTimes(5,4,9, 12);
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
    public void bedTimeAtSevenWithStartTimeAtEightReturnsFourDiscountHours() {
        hoursWorked.setTimes(8,12,7, 12);
        wageCalculator = new WageCalculator(hoursWorked);
        assertEquals("4", wageCalculator.getDiscountHours().toString());
    }

    @Test
    public void bedTimeAtSevenWithEndTimeAtNineReturnsTwoDiscountHours() {
        hoursWorked.setTimes(5,9,7, 12);
        wageCalculator = new WageCalculator(hoursWorked);
        assertEquals("2", wageCalculator.getDiscountHours().toString());
    }

    @Test
    public void endTimeAtElevenReturnsZeroPremiumHours() {
        hoursWorked.setTimes(5,11,9, 12);
        wageCalculator = new WageCalculator(hoursWorked);
        assertEquals("0", wageCalculator.getPremiumHours().toString());
    }

    @Test
    public void endTimeAtFourReturnsFourPremiumHours() {
        hoursWorked.setTimes(5,4,9, 12);
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
    public void fourHoursAtBaseRateReturnsFortyEightDollars() {
        hoursWorked.setTimes(5,4,9, 12);
        wageCalculator = new WageCalculator(hoursWorked);
        assertEquals("48.00", format.format(wageCalculator.getBasePay()));
    }

    @Test
    public void zeroHoursAtBaseRateReturnsZeroDollars() {
        hoursWorked.setTimes(9,4,7, 12);
        wageCalculator = new WageCalculator(hoursWorked);
        assertEquals("0.00", format.format(wageCalculator.getBasePay()));
    }

    @Test
    public void sevenHoursAtBaseRateReturnsEightyFourDollars() {
        hoursWorked.setTimes(5,4,1, 12);
        wageCalculator = new WageCalculator(hoursWorked);
        assertEquals("84.00", format.format(wageCalculator.getBasePay()));
    }

    @Test
    public void threeHoursAtDiscountRateReturnsTwentyFourDollars() {
        hoursWorked.setTimes(5,4,9, 12);
        wageCalculator = new WageCalculator(hoursWorked);
        assertEquals("24.00", format.format(wageCalculator.getDiscountPay()));
    }

    @Test
    public void sixHoursAtDiscountRateReturnsFortyEightDollars() {
        hoursWorked.setTimes(6,4,5, 12);
        wageCalculator = new WageCalculator(hoursWorked);
        assertEquals("48.00", format.format(wageCalculator.getDiscountPay()));
    }

    @Test
    public void zeroHoursAtDiscountRateReturnsZeroDollars() {
        hoursWorked.setTimes(5,4,2, 12);
        wageCalculator = new WageCalculator(hoursWorked);
        assertEquals("0.00", format.format(wageCalculator.getDiscountPay()));
    }

    @Test
    public void fourHoursAtPremiumRateReturnsSixtyFourDollars() {
        hoursWorked.setTimes(5,4,9, 12);
        wageCalculator = new WageCalculator(hoursWorked);
        assertEquals("64.00", format.format(wageCalculator.getPremiumPay()));
    }

    @Test
    public void twoHoursAtPremiumRateReturnsThirtyTwoDollars() {
        hoursWorked.setTimes(1,2,9, 12);
        wageCalculator = new WageCalculator(hoursWorked);
        assertEquals("32.00", format.format(wageCalculator.getPremiumPay()));
    }

    @Test
    public void zeroHoursAtPremiumRateReturnsZeroDollars() {
        hoursWorked.setTimes(5,11,9, 12);
        wageCalculator = new WageCalculator(hoursWorked);
        assertEquals("0.00", format.format(wageCalculator.getPremiumPay()));
    }

    @Test
    public void workingFiveToFourWithBedTimeAtNineReturnsOneHundredThirtySix() {
        hoursWorked.setTimes(5,4,9, 12);
        wageCalculator = new WageCalculator(hoursWorked);
        assertEquals("136.00", format.format(wageCalculator.getTotalPay()));
    }

    @Test
    public void workingFiveToNineWithBedTimeAtTenReturnsFortyEightDollars() {
        hoursWorked.setTimes(5,9,10, 12);
        wageCalculator = new WageCalculator(hoursWorked);
        assertEquals("48.00", format.format(wageCalculator.getTotalPay()));
    }

    @Test
    public void workingMidNightToFourReturnsSixtyFourDollars() {
        hoursWorked.setTimes(12,4,1, 12);
        wageCalculator = new WageCalculator(hoursWorked);
        assertEquals("64.00", format.format(wageCalculator.getTotalPay()));
    }

    @Test
        hoursWorked.setTimes(5,4,9, 11);
        wageCalculator = new WageCalculator(hoursWorked);
        assertEquals("144.00", format.format(wageCalculator.getTotalPay()));
    }
}
