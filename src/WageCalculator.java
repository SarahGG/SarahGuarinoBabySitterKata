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
    final private Double BASERATE = 12.00;
    final private Double DISCOUNTRATE = 8.00;
    final private Double PREMIUMRATE = 16.00;

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

    String getBaseRate() {
        return new DecimalFormat("0.00").format(this.BASERATE);
    }

    String getBasePay() {
        return new DecimalFormat("0.00").format(getBaseHours() * BASERATE);
    }

    Integer getDiscountHours() {
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

    String getDiscountRate() {
        return new DecimalFormat("0.00").format(this.DISCOUNTRATE);
    }

    String getDiscountPay() {
        return new DecimalFormat("0.00").format(getDiscountHours() * DISCOUNTRATE);
    }

    Integer getPremiumHours() {
        if(this.endTime <= 12) {
            return 0;
        } else {
            return (this.endTime - 12);
        }
    }

    String getPremiumRate() {
        return new DecimalFormat("0.00").format(this.PREMIUMRATE);
    }

    String getPremiumPay() {
        return new DecimalFormat("0.00").format(getPremiumHours() * PREMIUMRATE);
    }
}
