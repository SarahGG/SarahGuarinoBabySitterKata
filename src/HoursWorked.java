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

    HoursWorked() {
        startTime = 0;
        endTime = 0;
        bedTime = 0;
    }

    void setTimes(Integer startTime, Integer endTime, Integer bedTime) {
        setStartTime(startTime);
        setEndTime(endTime);
        setBedTime(bedTime);
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

    Integer getStartTime() {
        return this.startTime;
    }

    Integer getEndTime() {
        return this.endTime;
    }

    Integer getBedTime() {
        return this.bedTime;
    }
}
