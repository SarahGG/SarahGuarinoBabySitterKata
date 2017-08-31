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
    public void inputIsAWholeNumber() {
        assertEquals(false, Validator.isWholeNumber("this"));
        assertEquals(false, Validator.isWholeNumber("5.6"));
        assertEquals(true, Validator.isWholeNumber("-7"));
        assertEquals(true, Validator.isWholeNumber("12"));
    }

    @Test
    public void inputIsWithinOneToTwelveTimeRange() {
        assertEquals(false, Validator.isWithinTimeRange(-7));
        assertEquals(false, Validator.isWithinTimeRange(0));
        assertEquals(true, Validator.isWithinTimeRange(6));
    }

    @Test
    public void ThreeAMReturnsFifteen() {
        wageCalculator.setStartTime(3);
        assertEquals("15", wageCalculator.getStartTime().toString());
    }

    @Test
    public void workingFiveToMidNightReturnsSeven() {
        wageCalculator.setStartTime(5);
        wageCalculator.setEndTime(12);
        assertEquals("7", wageCalculator.getTotalHoursWorked().toString());
    }

    @Test
    public void workingNineToFiveReturnsFalse() {
        assertEquals(false, Validator.rangeIsInOrder(9, 5));
    }

    @Test
    public void workingFiveToNineReturnsTrue() {
        assertEquals(true, Validator.rangeIsInOrder(5, 9));
    }
}
