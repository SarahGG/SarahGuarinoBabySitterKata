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
        // makes anything after midnight it's hour value plus 12.
        // Think military time where noon is 0 instead of 12.
        if((1 <= startTime) && (startTime <= 4)) {
            startTime += 12;
        }

        this.startTime = startTime;
//        System.out.println("TEST: setStartTime WageCalculatorTest.java Line 18\n"
//                + "startTime has been set to " + startTime);
    }

    void setEndTime(Integer endTime) {
        if((1 <= startTime) && (startTime <= 4)) {
            startTime += 12;
        }

        this.endTime = endTime;
//        System.out.println("TEST: setEndTime WageCalculatorTest.java Line 24\n"
//                + "endTime has been set to " + endTime);
    }

    Integer getStartTime() {
        return this.startTime;
    }

    Integer getEndTime() {
        return this.endTime;
    }

    Integer getTotalHoursWorked() {
        return (this.endTime - this.startTime);
    }
}
