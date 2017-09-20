import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Class description
 *
 * @author Sarah Guarino
 * @version 1.0
 */
public class UtilTest {
    @Test
    public void ThreeAMReturnsFifteen() {
        assertEquals("15", TimePeriodOffset.offsetTime(3, 12).toString());
    }

    @Test
    public void NinePMReturnsNine() {
        assertEquals("9", TimePeriodOffset.offsetTime(9, 12).toString());
    }
}
