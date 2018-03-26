
package io.zipcoder.casino;

public class MathUtils {

    public static boolean isInRange(Integer value, Integer minimum, Integer maximum) {
        if (value >= minimum && value <= maximum) {
            return true;
        }
        return false;
    }
}