/**
 * Performs rudimentary tasks surrounding the Wage Calculator application
 *
 * @author Sarah Guarino
 * @version 1.0
 */
class TimePeriodOffset {
    static Integer offsetTime(Integer time, Integer offset) {
        if((1 <= time) && (time <= 4)) {
            time += offset;
        }

        return time;
    }
}
