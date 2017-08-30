/**
 * Sarah's daily baby sitting wage calculator.
 *
 * @author Sarah Guarino
 * @version 1.0
 */
public class WageCalculator {
    private Integer startTime;
    private Integer endTime;

    public WageCalculator() {
        startTime = 0;
        endTime = 0;
    }

    public String getStartTime() {
        return this.startTime.toString();
    }

    public String getEndTime() {
        return this.endTime.toString();
    }
}
