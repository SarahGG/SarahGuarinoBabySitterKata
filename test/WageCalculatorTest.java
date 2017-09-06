import org.junit.Before;
import org.junit.Test;

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

    @Before
    public void setUp() {
        hoursWorked = new HoursWorked();
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
        hoursWorked.setStartTime(5);
        hoursWorked.setBedTime(9);
        hoursWorked.setEndTime(4);
        wageCalculator = new WageCalculator(hoursWorked);
        assertEquals("4", wageCalculator.getBaseHours().toString());
    }

    @Test
    public void startTimeAtFiveWithEndTimeAtEightAndBedTimeAtNineReturnsThreeBaseHours() {
        hoursWorked.setStartTime(5);
        hoursWorked.setEndTime(8);
        hoursWorked.setBedTime(9);
        wageCalculator = new WageCalculator(hoursWorked);
        assertEquals("3", wageCalculator.getBaseHours().toString());
    }

    @Test
    public void startTimeAtFiveWithBedTimeAtTwoReturnsSevenBaseHours() {
        hoursWorked.setStartTime(5);
        hoursWorked.setEndTime(4);
        hoursWorked.setBedTime(2);
        wageCalculator = new WageCalculator(hoursWorked);
        assertEquals("7", wageCalculator.getBaseHours().toString());
    }

    @Test
    public void bedTimeAtNineReturnsThreeDisCountHours() {
        hoursWorked.setStartTime(5);
        hoursWorked.setBedTime(9);
        hoursWorked.setEndTime(4);
        wageCalculator = new WageCalculator(hoursWorked);
        assertEquals("3", wageCalculator.getDiscountHours().toString());
    }

    @Test
    public void bedTimeAtOneReturnsZeroDisCountHours() {
        hoursWorked.setStartTime(5);
        hoursWorked.setBedTime(1);
        hoursWorked.setEndTime(4);
        wageCalculator = new WageCalculator(hoursWorked);
        assertEquals("0", wageCalculator.getDiscountHours().toString());
    }

    @Test
    public void bedTimeAtSevenWithStartTimeAtEightReturnsFourDiscountHours() {
        hoursWorked.setStartTime(8);
        hoursWorked.setBedTime(7);
        hoursWorked.setEndTime(12);
        wageCalculator = new WageCalculator(hoursWorked);
        assertEquals("4", wageCalculator.getDiscountHours().toString());
    }

    @Test
    public void bedTimeAtSevenWithEndTimeAtNineReturnsTwoDiscountHours() {
        hoursWorked.setStartTime(5);
        hoursWorked.setBedTime(7);
        hoursWorked.setEndTime(9);
        wageCalculator = new WageCalculator(hoursWorked);
        assertEquals("2", wageCalculator.getDiscountHours().toString());
    }

    @Test
    public void endTimeAtElevenReturnsZeroPremiumHours() {
        hoursWorked.setStartTime(5);
        hoursWorked.setBedTime(9);
        hoursWorked.setEndTime(11);
        wageCalculator = new WageCalculator(hoursWorked);
        assertEquals("0", wageCalculator.getPremiumHours().toString());
    }

    @Test
    public void endTimeAtFourReturnsFourPremiumHours() {
        hoursWorked.setStartTime(5);
        hoursWorked.setBedTime(9);
        hoursWorked.setEndTime(4);
        wageCalculator = new WageCalculator(hoursWorked);
        assertEquals("4", wageCalculator.getPremiumHours().toString());
    }

    @Test
    public void endTimeAtTwoReturnsTwoPremiumHours() {
        hoursWorked.setStartTime(5);
        hoursWorked.setBedTime(9);
        hoursWorked.setEndTime(2);
        wageCalculator = new WageCalculator(hoursWorked);
        assertEquals("2", wageCalculator.getPremiumHours().toString());
    }

    @Test
    public void fourHoursAtBaseRateReturnsFortyEightDollars() {
        hoursWorked.setStartTime(5);
        hoursWorked.setBedTime(9);
        hoursWorked.setEndTime(4);
        wageCalculator = new WageCalculator(hoursWorked);
        assertEquals("48.00", wageCalculator.getBasePay());
    }

    @Test
    public void zeroHoursAtBaseRateReturnsZeroDollars() {
        hoursWorked.setStartTime(9);
        hoursWorked.setBedTime(7);
        hoursWorked.setEndTime(4);
        wageCalculator = new WageCalculator(hoursWorked);
        assertEquals("0.00", wageCalculator.getBasePay());
    }

    @Test
    public void sevenHoursAtBaseRateReturnsEightyFourDollars() {
        hoursWorked.setStartTime(5);
        hoursWorked.setBedTime(1);
        hoursWorked.setEndTime(4);
        wageCalculator = new WageCalculator(hoursWorked);
        assertEquals("84.00", wageCalculator.getBasePay());
    }

    @Test
    public void threeHoursAtDiscountRateReturnsTwentyFourDollars() {
        hoursWorked.setStartTime(5);
        hoursWorked.setBedTime(9);
        hoursWorked.setEndTime(4);
        wageCalculator = new WageCalculator(hoursWorked);
        assertEquals("24.00", wageCalculator.getDiscountPay());
    }

    @Test
    public void sixHoursAtDiscountRateReturnsFortyEightDollars() {
        hoursWorked.setStartTime(6);
        hoursWorked.setBedTime(5);
        hoursWorked.setEndTime(4);
        wageCalculator = new WageCalculator(hoursWorked);
        assertEquals("48.00", wageCalculator.getDiscountPay());
    }

    @Test
    public void zeroHoursAtDiscountRateReturnsZeroDollars() {
        hoursWorked.setStartTime(5);
        hoursWorked.setBedTime(2);
        hoursWorked.setEndTime(4);
        wageCalculator = new WageCalculator(hoursWorked);
        assertEquals("0.00", wageCalculator.getDiscountPay());
    }

    @Test
    public void fourHoursAtPremiumRateReturnsSixtyFourDollars() {
        hoursWorked.setStartTime(5);
        hoursWorked.setBedTime(9);
        hoursWorked.setEndTime(4);
        wageCalculator = new WageCalculator(hoursWorked);
        assertEquals("64.00", wageCalculator.getPremiumPay());
    }

    @Test
    public void twoHoursAtPremiumRateReturnsThirtyTwoDollars() {
        hoursWorked.setStartTime(1);
        hoursWorked.setBedTime(9);
        hoursWorked.setEndTime(2);
        wageCalculator = new WageCalculator(hoursWorked);
        assertEquals("32.00", wageCalculator.getPremiumPay());
    }

    @Test
    public void zeroHoursAtPremiumRateReturnsZeroDollars() {
        hoursWorked.setStartTime(5);
        hoursWorked.setBedTime(9);
        hoursWorked.setEndTime(11);
        wageCalculator = new WageCalculator(hoursWorked);
        assertEquals("0.00", wageCalculator.getPremiumPay());
    }

    @Test
    public void workingFiveToFourWithBedTimeAtNineReturnsOneHundredThirtySix() {
        hoursWorked.setStartTime(5);
        hoursWorked.setBedTime(9);
        hoursWorked.setEndTime(4);
        wageCalculator = new WageCalculator(hoursWorked);
        assertEquals("136.00", wageCalculator.getTotalPay());
    }

    @Test
    public void workingFiveToNineWithBedTimeAtTenReturnsFortyEightDollars() {
        hoursWorked.setStartTime(5);
        hoursWorked.setBedTime(10);
        hoursWorked.setEndTime(9);
        wageCalculator = new WageCalculator(hoursWorked);
        assertEquals("48.00", wageCalculator.getTotalPay());
    }

    @Test
    public void workingMidNightToFourReturnsSixtyFourDollars() {
        hoursWorked.setStartTime(12);
        hoursWorked.setBedTime(1);
        hoursWorked.setEndTime(4);
        wageCalculator = new WageCalculator(hoursWorked);
        assertEquals("64.00", wageCalculator.getTotalPay());
    }
}
