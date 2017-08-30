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
    private WageCalculatorValidator validator;

    @Before
    public void setUp() {
        wageCalculator = new WageCalculator();
        validator = new WageCalculatorValidator();
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
    public void startTimeIsInitializedToInput() {
        wageCalculator.setStartTime(5);
        assertEquals("5", wageCalculator.getStartTime().toString());
    }

    @Test
    public void endTimeIsInitializedToInput() {
        wageCalculator.setEndTime(5);
        assertEquals("5", wageCalculator.getEndTime().toString());
    }

    @Test
    public void inputIsAWholeNumber() {
        assertEquals(false, validator.isWholeNumber("this"));
        assertEquals(false, validator.isWholeNumber("5.6"));
        assertEquals(true, validator.isWholeNumber("-7"));
        assertEquals(true, validator.isWholeNumber("12"));
    }

    @Test
    public void inputIsWithinTimeRange() {
        assertEquals(false, validator.isWithinTimeRange(-7));
        assertEquals(false, validator.isWithinTimeRange(0));
        assertEquals(true, validator.isWithinTimeRange(6));
    }
}
