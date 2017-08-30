import java.util.Scanner;

/**
 * Sarah's daily baby sitting wage calculator.
 *
 * @author Sarah Guarino
 * @version 1.0
 */
class WageCalculator {
    private Integer startTime;
    private Integer endTime;

    WageCalculator() {
        startTime = 0;
        endTime = 0;
    }

    void setStartTime(Integer startTime) {
        this.startTime = startTime;
        System.out.println("TEST: setStartTime WageCalculatorTest.java Line 18\n"
                + "startTime has been set to " + startTime);
    }

    void setEndTime(Integer endTime) {
        this.endTime = endTime;
        System.out.println("TEST: setEndTime WageCalculatorTest.java Line 24\n"
                + "endTime has been set to " + endTime);
    }

    Integer getStartTime() {
        return this.startTime;
    }

    Integer getEndTime() {
        return this.endTime;
    }
}
