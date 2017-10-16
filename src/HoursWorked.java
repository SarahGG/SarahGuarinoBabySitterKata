/**
 * Object that sets and gets the
 * punch-card like record of times worked.
 *
 * @author Sarah Guarino
 * @version 1.0
 */
@SuppressWarnings("WeakerAccess")
public class HoursWorked {
    private Integer startTime;
    private Integer endTime;
    private Integer bedTime;
    private Integer premiumTime;

    public HoursWorked() {
        startTime = 0;
        endTime = 0;
        bedTime = 0;
        premiumTime = 0;
    }

    public void setTimes(Integer startTime, Integer endTime, Integer bedTime, Integer premiumTime) {
        setStartTime(TimePeriodOffset.offsetTime(startTime, 12));
        setEndTime(TimePeriodOffset.offsetTime(endTime,12));
        setBedTime(TimePeriodOffset.offsetTime(bedTime, 12));
        setPremiumTime(TimePeriodOffset.offsetTime(premiumTime, 12));
    }

    public void setStartTime(Integer startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(Integer endTime) {
        this.endTime = endTime;
    }

    public void setBedTime(Integer bedTime) {
        this.bedTime = bedTime;
    }

    private void setPremiumTime(Integer premiumTime) {
        this.premiumTime = premiumTime;
    }

    public Integer getStartTime() {
        return this.startTime;
    }

    public Integer getEndTime() {
        return this.endTime;
    }

    public Integer getBedTime() {
        return this.bedTime;
    }

    public Integer getPremiumTime() {
        return this.premiumTime;
    }
}
