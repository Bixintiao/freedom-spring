package utils;

import java.util.UUID;

/**
 * project freedom-spring
 * @Author hzy
 * @Date 2019/4/22 10:03
 * @Description version 1.0
 */
public class IDUtil {

    public static String getUUid(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }

    public static String getCurrentTimeMillis(){
        return String.valueOf(System.currentTimeMillis());
    }


}
