import java.text.DecimalFormat;

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

    String getTotalPay() {
        Double basePay = Double.parseDouble(getBasePay());
        Double discountPay = Double.parseDouble(getDiscountPay());
        Double premiumPay = Double.parseDouble(getPremiumPay());

        return new DecimalFormat("0.00").format(basePay + discountPay + premiumPay);
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

    String getBasePay() {
        return new DecimalFormat("0.00").format(getBaseHours() * HourlyRates.getBaseRate());
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

    String getDiscountPay() {
        return new DecimalFormat("0.00").format(getDiscountHours() * HourlyRates.getDiscountRate());
    }

    Integer getPremiumHours() {
        if(this.hoursWorked.getEndTime() <= 12) {
            return 0;
        } else {
            return (this.hoursWorked.getEndTime() - 12);
        }
    }

    String getPremiumPay() {
        return new DecimalFormat("0.00").format(getPremiumHours() * HourlyRates.getPremiumRate());
    }
}
