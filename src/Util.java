/**
 * Performs rudimentary tasks surrounding the Wage Calculator application
 *
 * @author Sarah Guarino
 * @version 1.0
 */
class Util {
    static Integer fixTimesAfterMidnight(Integer time) {
        // makes anything after midnight it's hour value plus 12.
        // Think military time where noon is 0 instead of 12.
        if((1 <= time) && (time <= 4)) {
            time += 12;
        }

        return time;
    }
}
