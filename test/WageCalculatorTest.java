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

    @Before
    public void setUp() {
        wageCalculator = new WageCalculator();
    }

    @Test
    public void startTimeIsInitializedToZero() {
        assertEquals("0", wageCalculator.getStartTime().toString());
    }

    @Test
    public void endTimeIsInitializedToZero() {
        assertEquals("0", wageCalculator.getEndTime().toString());
    }

    @Test
    public void bedTimeIsInitializedToZero() {
        assertEquals("0", wageCalculator.getBedTime().toString());
    }

    @Test
    public void startTimeIsInitializedToFive() {
        wageCalculator.setStartTime(5);
        assertEquals("5", wageCalculator.getStartTime().toString());
    }

    @Test
    public void endTimeIsInitializedToFive() {
        wageCalculator.setEndTime(5);
        assertEquals("5", wageCalculator.getEndTime().toString());
    }

    @Test
    public void bedTimeIsInitializedToFive() {
        wageCalculator.setBedTime(5);
        assertEquals("5", wageCalculator.getBedTime().toString());
    }

    @Test
    public void workingFiveToMidNightReturnsSeven() {
        wageCalculator.setStartTime(5);
        wageCalculator.setEndTime(12);
        assertEquals("7", wageCalculator.getTotalHoursWorked().toString());
    }

    @Test
    public void workingFiveToTwoReturnsNine() {
        wageCalculator.setStartTime(5);
        wageCalculator.setEndTime(2);
        assertEquals("9", wageCalculator.getTotalHoursWorked().toString());
    }

    @Test
    public void startTimeAtFivewithBedTimeAtNineReturnsFourBaseHours() {
        wageCalculator.setStartTime(5);
        wageCalculator.setBedTime(9);
        assertEquals("4", wageCalculator.getBaseHours().toString());
    }

    @Test
    public void startTimeAtFivewithBedTimeAtTwoReturnsSevenBaseHours() {
        wageCalculator.setStartTime(5);
        wageCalculator.setBedTime(2);
        assertEquals("7", wageCalculator.getBaseHours().toString());
    }

    @Test
    public void bedTimeAtNineReturnsThreeDisCountHours() {
        wageCalculator.setBedTime(9);
        assertEquals("3", wageCalculator.getDiscountHours().toString());
    }

    @Test
    public void bedTimeAtOneReturnsZeroDisCountHours() {
        wageCalculator.setBedTime(1);
        assertEquals("0", wageCalculator.getDiscountHours().toString());
    }
}
