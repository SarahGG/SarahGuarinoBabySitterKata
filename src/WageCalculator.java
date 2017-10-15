/**
 * Sarah's daily baby sitting wage calculator.
 * Returns numerical values of the hours worked and the pay earned.
 *
 * @author Sarah Guarino
 * @version 1.0
 */
@SuppressWarnings("WeakerAccess")
public class WageCalculator {
    private final Integer STARTTIME;
    private final Integer ENDTIME;
    private final Integer BEDTIME;
    private final Integer PREMIUMTIME;

    WageCalculator(HoursWorked hoursWorked) {
        this.HOURSWORKED = hoursWorked;
        this.STARTTIME = this.HOURSWORKED.getStartTime();
        this.ENDTIME = this.HOURSWORKED.getEndTime();
        this.BEDTIME = this.HOURSWORKED.getBedTime();
        this.PREMIUMTIME = this.HOURSWORKED.getPremiumTime();
    }

    public Integer getTotalHours() {
        return (this.ENDTIME - this.STARTTIME);
    }

    public Double getTotalPay() {
        Double basePay = getBasePay();
        Double discountPay = getDiscountPay();
        Double premiumPay = getPremiumPay();

        return basePay + discountPay + premiumPay;
    }

    public Integer getBaseHours() {
        Integer baseHours;

        if(this.BEDTIME > this.ENDTIME) {
            baseHours = (this.ENDTIME - this.STARTTIME);
        } else if (this.BEDTIME < this.STARTTIME) {
            baseHours = 0;
        } else if(this.BEDTIME > this.PREMIUMTIME) {
            baseHours = (this.PREMIUMTIME - this.STARTTIME);
        } else {
            baseHours = (this.BEDTIME - this.STARTTIME);
        }

        return baseHours;
    }

    public Double getBasePay() {
        return getBaseHours() * HourlyRates.getBaseRate();
    }

    public Integer getDiscountHours() {
        if((this.BEDTIME > this.PREMIUMTIME) || (this.BEDTIME > this.ENDTIME)) {
            return 0;
        } else if(this.STARTTIME > this.BEDTIME){
            if(this.PREMIUMTIME > this.ENDTIME) {
                return (this.STARTTIME - this.ENDTIME);
            } else {
                return (this.PREMIUMTIME - this.STARTTIME);
            }
        } else if(this.ENDTIME < this.PREMIUMTIME){
            return (this.ENDTIME - this.BEDTIME);
        } else {
            return (this.PREMIUMTIME - this.BEDTIME);
        }
    }

    public Double getDiscountPay() {
        return getDiscountHours() * HourlyRates.getDiscountRate();
    }

    public Integer getPremiumHours() {
        return (this.ENDTIME <= this.PREMIUMTIME) ? 0 : (this.ENDTIME - this.PREMIUMTIME);
    }

    public Double getPremiumPay() {
        return getPremiumHours() * HourlyRates.getPremiumRate();
    }
}
