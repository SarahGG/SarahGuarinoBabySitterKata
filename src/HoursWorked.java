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

    private HoursWorked() {
        startTime = 0;
        endTime = 0;
        bedTime = 0;
        premiumTime = 0;
    }

    public void setTimes(Integer startTime, Integer endTime, Integer bedTime, Integer premiumTime) {
        setStartTime(startTime);
        setEndTime(endTime);
        setBedTime(bedTime);
        setPremiumTime(premiumTime);
    }

    public void setStartTime(Integer startTime) {
        startTime = TimePeriodOffset.offsetTime(startTime, 12);
        this.startTime = startTime;
    }

    public void setEndTime(Integer endTime) {
        endTime = TimePeriodOffset.offsetTime(endTime,12);
        this.endTime = endTime;
    }

    public void setBedTime(Integer bedTime) {
        bedTime = TimePeriodOffset.offsetTime(bedTime, 12);
        this.bedTime = bedTime;
    }

    private void setPremiumTime(Integer premiumTime) {
        premiumTime = TimePeriodOffset.offsetTime(premiumTime, 12);
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
