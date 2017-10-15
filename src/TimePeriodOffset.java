/**
 * Performs rudimentary tasks surrounding the Wage Calculator application
 *
 * @author Sarah Guarino
 * @version 1.0
 */
@SuppressWarnings("WeakerAccess")
public class TimePeriodOffset {
    public static Integer offsetTime(Integer time, Integer offset) {
        if((1 <= time) && (time <= 4)) {
            time += offset;
        }

        return time;
    }
}
