/**
 * Sarah's daily baby sitting wage calculator.
 * Returns numerical values of the hours worked and the pay earned.
 *
 * @author Sarah Guarino
 * @version 1.0
 */
class WageCalculator {
    private final HoursWorked hoursWorked;

    WageCalculator(HoursWorked hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    Integer getTotalHours() {
        return (this.hoursWorked.getEndTime() - this.hoursWorked.getStartTime());
    }

    Double getTotalPay() {
        Double basePay = getBasePay();
        Double discountPay = getDiscountPay();
        Double premiumPay = getPremiumPay();

        return basePay + discountPay + premiumPay;
    }

    Integer getBaseHours() {
        if(this.hoursWorked.getBedTime() > this.hoursWorked.getEndTime()) {
            return this.hoursWorked.getEndTime() - this.hoursWorked.getStartTime();
        } else if (this.hoursWorked.getBedTime() < this.hoursWorked.getStartTime()) {
            return 0;
        } else if(this.hoursWorked.getBedTime() > 12) {
            return (12 - this.hoursWorked.getStartTime());
        } else {
            return (this.hoursWorked.getBedTime() - this.hoursWorked.getStartTime());
        }
    }

    Double getBasePay() {
        return getBaseHours() * HourlyRates.getBaseRate();
    }

    Integer getDiscountHours() {
        if((this.hoursWorked.getBedTime() > 12)
                || ((this.hoursWorked.getEndTime() < 12)
                && (this.hoursWorked.getBedTime() > this.hoursWorked.getEndTime()))) {
            return 0;
        } else if(this.hoursWorked.getStartTime() > this.hoursWorked.getBedTime()){
            if(12 > this.hoursWorked.getEndTime()) {
                return (this.hoursWorked.getStartTime() - this.hoursWorked.getEndTime());
            } else {
                return (12 - this.hoursWorked.getStartTime());
            }
        } else if(this.hoursWorked.getEndTime() < 12){
            return (this.hoursWorked.getEndTime() - this.hoursWorked.getBedTime());
        } else {
            return (12 - this.hoursWorked.getBedTime());
        }
    }

    Double getDiscountPay() {
        return getDiscountHours() * HourlyRates.getDiscountRate();
    }

    Integer getPremiumHours() {
        return (this.hoursWorked.getEndTime() <= 12) ? 0 : (this.hoursWorked.getEndTime() - 12);
    }

    Double getPremiumPay() {
        return getPremiumHours() * HourlyRates.getPremiumRate();
    }
}
