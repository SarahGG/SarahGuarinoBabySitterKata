/**
 * Sarah's daily baby sitting wage calculator.
 *
 * @author Sarah Guarino
 * @version 1.0
 */
class WageCalculator {
    private Integer startTime;
    private Integer endTime;
    private Integer bedTime;

    WageCalculator() {
        startTime = 0;
        endTime = 0;
        bedTime = 0;
    }

    void setStartTime(Integer startTime) {
        startTime = Util.fixTimesAfterMidnight(startTime);
        this.startTime = startTime;
//        System.out.println("TEST: setStartTime WageCalculatorTest.java\n"
//                + "startTime has been set to " + this.startTime);
    }

    void setEndTime(Integer endTime) {
        endTime = Util.fixTimesAfterMidnight(endTime);
        this.endTime = endTime;
//        System.out.println("TEST: setEndTime WageCalculatorTest.java\n"
//                + "endTime has been set to " + this.endTime);
    }

    void setBedTime(Integer bedTime) {
        bedTime = Util.fixTimesAfterMidnight(bedTime);
        this.bedTime = bedTime;
//        System.out.println("TEST: setBedTime WageCalculatorTest.java\n"
//                + "bedTime has been set to " + this.bedTime);
    }

    Integer getStartTime() {
        return this.startTime;
    }

    Integer getEndTime() {
        return this.endTime;
    }

    Integer getBedTime() {
        return this.bedTime;
    }

    Integer getTotalHoursWorked() {
        return (this.endTime - this.startTime);
    }

    Integer getBaseHours() {
        if(this.bedTime > this.endTime) {
            return this.endTime - this.startTime;
        } else if(this.bedTime > 12) {
            return (12 - this.startTime);
        } else {
            return (this.bedTime - this.startTime);
        }
    }

    Integer getDiscountedHours() {
        Integer cutOffTime;

        if(this.endTime > 12) {
            cutOffTime = 12;
        } else {
            cutOffTime = this.endTime;
        }

        if(bedTime >= 12) {
            return 0;
        } else if(this.startTime > this.bedTime) {
            return cutOffTime - this.startTime;
        } else {
            return cutOffTime - this.bedTime;
        }
    }
}
