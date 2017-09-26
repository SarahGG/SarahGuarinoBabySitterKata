/**
 * Sarah's daily baby sitting wage calculator.
 * Returns numerical values of the hours worked and the pay earned.
 *
 * @author Sarah Guarino
 * @version 1.0
 */
class WageCalculator {
    private final HoursWorked HOURSWORKED;
    private final Integer STARTTIME;
    private final Integer ENDTIME;
    private final Integer BEDTIME;

    WageCalculator(HoursWorked hoursWorked) {
        this.HOURSWORKED = hoursWorked;
        this.STARTTIME = this.HOURSWORKED.getStartTime();
        this.ENDTIME = this.HOURSWORKED.getEndTime();
        this.BEDTIME = this.HOURSWORKED.getBedTime();
    }

    Integer getTotalHours() {
        return (this.ENDTIME - this.STARTTIME);
    }

    Double getTotalPay() {
        Double basePay = getBasePay();
        Double discountPay = getDiscountPay();
        Double premiumPay = getPremiumPay();

        return basePay + discountPay + premiumPay;
    }

    Integer getBaseHours() {
        if(this.BEDTIME > this.ENDTIME) {
            return this.ENDTIME - this.STARTTIME;
        } else if (this.BEDTIME < this.STARTTIME) {
            return 0;
        } else if(this.BEDTIME > 12) {
            return (12 - this.STARTTIME);
        } else {
            return (this.BEDTIME - this.STARTTIME);
        }
    }

    Double getBasePay() {
        return getBaseHours() * HourlyRates.getBaseRate();
    }

    Integer getDiscountHours() {
        if((this.BEDTIME > 12)
                || ((this.ENDTIME < 12)
                && (this.BEDTIME > this.ENDTIME))) {
            return 0;
        } else if(this.STARTTIME > this.BEDTIME){
            if(12 > this.ENDTIME) {
                return (this.STARTTIME - this.ENDTIME);
            } else {
                return (12 - this.STARTTIME);
            }
        } else if(this.ENDTIME < 12){
            return (this.ENDTIME - this.BEDTIME);
        } else {
            return (12 - this.BEDTIME);
        }
    }

    Double getDiscountPay() {
        return getDiscountHours() * HourlyRates.getDiscountRate();
    }

    Integer getPremiumHours() {
        return (this.ENDTIME <= 12) ? 0 : (this.ENDTIME - 12);
    }

    Double getPremiumPay() {
        return getPremiumHours() * HourlyRates.getPremiumRate();
    }
}
