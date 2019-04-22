package justTest;

import org.junit.Test;
import utils.NumberUtil;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * project freedom-spring
 *
 * @Author hzy
 * @Date 2019/4/18 10:43
 * @Description version 1.0
 */
public class Format {

    @Test
    public void testNumberFormat(){
        java.text.DecimalFormat decimalFormat = new DecimalFormat("#,###.000");
        String format = decimalFormat.format(new BigDecimal(123123123d));
        System.out.println(format);
    }


    @Test
    public void test1(){
        System.out.println(NumberUtil.formatNumber(23123,"#,###.000"));
    }



}
