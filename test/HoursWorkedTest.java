import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test class for HoursWorked.java
 *
 * @author Sarah Guarino
 * @version 1.0
 */
public class HoursWorkedTest {
    private HoursWorked hoursWorked;

    @Before
    public void setUp() {
    hoursWorked = new HoursWorked();
    }

    @Test
    public void startTimeIsInitializedToZero() {
        assertEquals("0", hoursWorked.getStartTime().toString());
    }

    @Test
    public void endTimeIsInitializedToZero() {
        assertEquals("0", hoursWorked.getEndTime().toString());
    }

    @Test
    public void bedTimeIsInitializedToZero() {
        assertEquals("0", hoursWorked.getBedTime().toString());
    }

    @Test
    public void startTimeIsInitializedToFive() {
        hoursWorked.setStartTime(5);
        assertEquals("5", hoursWorked.getStartTime().toString());
    }

    @Test
    public void endTimeIsInitializedToFive() {
        hoursWorked.setEndTime(5);
        assertEquals("5", hoursWorked.getEndTime().toString());
    }

    @Test
    public void bedTimeIsInitializedToFive() {
        hoursWorked.setBedTime(5);
        assertEquals("5", hoursWorked.getBedTime().toString());
    }
}
