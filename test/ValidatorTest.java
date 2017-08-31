import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Class description
 *
 * @author Sarah Guarino
 * @version 1.0
 */
public class ValidatorTest {
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
    public void workingNineToFiveReturnsFalse() {
        assertEquals(false, Validator.rangeIsInOrder(9, 5));
    }

    @Test
    public void workingFiveToNineReturnsTrue() {
        assertEquals(true, Validator.rangeIsInOrder(5, 9));
    }
}
