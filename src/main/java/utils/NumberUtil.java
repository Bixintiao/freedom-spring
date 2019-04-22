package utils;

import java.text.DecimalFormat;
import java.util.Objects;

/**
 * project freedom-spring
 *
 * @Author hzy
 * @Date 2019/4/18 10:46
 * @Description version 1.0
 */
public class NumberUtil {

    public static String formatNumber(Object o, String fmt){
        Objects.requireNonNull(o, "number must not be null .");
        Objects.requireNonNull(fmt, "fmt must not be null .");
        java.text.DecimalFormat decimalFormat = new DecimalFormat(fmt);
        return decimalFormat.format(o);
    }

}
