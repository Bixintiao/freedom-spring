package utils;

import com.alibaba.fastjson.JSON;
import java.util.HashMap;
import java.util.Map;

/**
 * project freedom-spring
 *
 * @Author hzy
 * @Date 2019/3/11 10:00
 * @Description version 1.0
 */
public class BeanUtil{

    public static <T> T transMapToBean(Map<String, Object> map, Class<T> clazz) throws Exception {
        if (null == map){
            throw new Exception("参数 map 不能为空");
        }
        return JSON.parseObject(JSON.toJSONString(map), clazz);
    }


}
