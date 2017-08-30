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
    public void inputIsValidatedAsAWholeNumber() {
        assertEquals(false, WageCalculatorValidator.isWholeNumber("this"));
        assertEquals(false, WageCalculatorValidator.isWholeNumber("5.6"));
        assertEquals(true, WageCalculatorValidator.isWholeNumber("-7"));
        assertEquals(true, WageCalculatorValidator.isWholeNumber("12"));
    }
}
