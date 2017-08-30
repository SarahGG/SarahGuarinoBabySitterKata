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
    WageCalculator wageCalculator;
    @Before
    public void setUp() {
        wageCalculator = new WageCalculator();
    }

    @Test
    public void startTimeIsInitializedToZero() {
        WageCalculator wageCalculator = new WageCalculator();
        assertEquals("0", wageCalculator.getStartTime());
    }
}
