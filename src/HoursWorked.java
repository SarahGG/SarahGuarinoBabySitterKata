/**
 * Object that sets and gets the
 * punch-card like record of times worked.
 *
 * @author Sarah Guarino
 * @version 1.0
 */
class HoursWorked {
    private Integer startTime;
    private Integer endTime;
    private Integer bedTime;
    private Integer premiumTime;

    HoursWorked() {
        startTime = 0;
        endTime = 0;
        bedTime = 0;
        premiumTime = 0;
    }

    void setTimes(Integer startTime, Integer endTime, Integer bedTime, Integer premiumTime) {
        setStartTime(startTime);
        setEndTime(endTime);
        setBedTime(bedTime);
        setPremiumTime(premiumTime);
    }

    void setStartTime(Integer startTime) {
        startTime = TimePeriodOffset.offsetTime(startTime, 12);
        this.startTime = startTime;
    }

    void setEndTime(Integer endTime) {
        endTime = TimePeriodOffset.offsetTime(endTime,12);
        this.endTime = endTime;
    }

    void setBedTime(Integer bedTime) {
        bedTime = TimePeriodOffset.offsetTime(bedTime, 12);
        this.bedTime = bedTime;
    }

    void setPremiumTime(Integer premiumTime) {
        premiumTime = TimePeriodOffset.offsetTime(premiumTime, 12);
        this.premiumTime = premiumTime;
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

    Integer getPremiumTime() {
        return this.premiumTime;
    }
}
