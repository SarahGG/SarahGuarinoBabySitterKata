import org.junit.Before;
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
        assertEquals("15", Util.fixTimesAfterMidnight(3).toString());
    }

    @Test
    public void NinePMReturnsNine() {
        assertEquals("9", Util.fixTimesAfterMidnight(9).toString());
    }
}
