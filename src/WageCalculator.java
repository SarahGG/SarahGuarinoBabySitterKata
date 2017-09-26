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
    }

    Integer getTotalHours() {
    }

    Double getTotalPay() {
        Double basePay = getBasePay();
        Double discountPay = getDiscountPay();
        Double premiumPay = getPremiumPay();

        return basePay + discountPay + premiumPay;
    }

    Integer getBaseHours() {
        } else if (this.HOURSWORKED.getBedTime() < this.HOURSWORKED.getStartTime()) {
            return 0;
        } else if(this.HOURSWORKED.getBedTime() > 12) {
            return (12 - this.HOURSWORKED.getStartTime());
        } else {
            return (this.HOURSWORKED.getBedTime() - this.HOURSWORKED.getStartTime());
        }
    }

    Double getBasePay() {
        return getBaseHours() * HourlyRates.getBaseRate();
    }

    Integer getDiscountHours() {
        if((this.HOURSWORKED.getBedTime() > 12)
            return 0;
        } else if(this.HOURSWORKED.getStartTime() > this.HOURSWORKED.getBedTime()){
            } else {
                return (12 - this.HOURSWORKED.getStartTime());
            }
        } else {
            return (12 - this.HOURSWORKED.getBedTime());
        }
    }

    Double getDiscountPay() {
        return getDiscountHours() * HourlyRates.getDiscountRate();
    }

    Integer getPremiumHours() {
    }

    Double getPremiumPay() {
        return getPremiumHours() * HourlyRates.getPremiumRate();
    }
}
