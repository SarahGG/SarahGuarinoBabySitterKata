import java.text.DecimalFormat;

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

    Integer getTotalHours() {
        return (this.endTime - this.startTime);
    }

    String getTotalPay() {
        Double basePay = Double.parseDouble(getBasePay());
        Double discountPay = Double.parseDouble(getDiscountPay());
        Double premiumPay = Double.parseDouble(getPremiumPay());

        return new DecimalFormat("0.00").format(basePay + discountPay + premiumPay);
    }

    Integer getBaseHours() {
        if(this.bedTime > this.endTime) {
            return this.endTime - this.startTime;
        } else if (this.bedTime < this.startTime) {
            return 0;
        } else if(this.bedTime > 12) {
            return (12 - this.startTime);
        } else {
            return (this.bedTime - this.startTime);
        }
    }

    String getBasePay() {
        return new DecimalFormat("0.00").format(getBaseHours() * HourlyRates.getBaseRate());
    }

    Integer getDiscountHours() {
        if((this.bedTime > 12) || ((this.endTime < 12) && (this.bedTime > this.endTime))) {
            return 0;
        } else if(this.startTime > this.bedTime){
            if(12 > this.endTime) {
                return (this.startTime - this.endTime);
            } else {
                return (12 - this.startTime);
            }
        } else if(this.endTime < 12){
            return (this.endTime - this.bedTime);
        } else {
            return (12 - this.bedTime);
        }
    }

    String getDiscountPay() {
        return new DecimalFormat("0.00").format(getDiscountHours() * HourlyRates.getDiscountRate());
    }

    Integer getPremiumHours() {
        if(this.endTime <= 12) {
            return 0;
        } else {
            return (this.endTime - 12);
        }
    }

    String getPremiumPay() {
        return new DecimalFormat("0.00").format(getPremiumHours() * HourlyRates.getPremiumRate());
    }
}
