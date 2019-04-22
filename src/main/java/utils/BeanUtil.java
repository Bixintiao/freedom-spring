package utils;

import com.alibaba.fastjson.JSON;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

/**
 * project freedom-spring
 * @Author hzy
 * @Date 2019/3/11 10:00
 * @Description version 1.0
 */
public class BeanUtil{

    public static final int GET = 0;
    public static final int SET = 1;
    private static Map<Class,Map<String,Method>> classMap = new HashMap<>();
    private static Map<String,Method> methodMap;

    //setField value
    public static void setField(Object obj, String property, Object val)throws NoSuchFieldException, IllegalAccessException{
        Objects.requireNonNull(obj, "obj must be not null.");
        Objects.requireNonNull(property, "property must be not null.");
        Field field = obj.getClass().getDeclaredField(property);
        field.setAccessible(true);
        field.set(obj, val);
    }

    //getField value
    public static Object getField(Object obj, String property) throws NoSuchFieldException, IllegalAccessException {
        Objects.requireNonNull(obj, "obj must be not null.");
        Objects.requireNonNull(property, "property must be not null.");
        Field field = obj.getClass().getDeclaredField(property);
        field.setAccessible(true);
        return field.get(obj);
    }


    //map -> bean (use fastJson)
    public static <T> T transMap2Bean(Map<String, Object> map, Class<T> clazz){
        Objects.requireNonNull(map, "map must not be null");
        Objects.requireNonNull(clazz, "clazz must not be null");
        return JSON.parseObject(JSON.toJSONString(map), clazz);
    }

    //map -> bean (use invoke)
    public static <T> T transMapToBean(Map<String, Object> map, T t) throws Exception{
        return transMapToBean(map, null, t);
    }
    public static <T> T transMapToBean(Map<String, Object> map, Class<T> clazz) throws Exception{
        return transMapToBean(map, clazz, null);
    }
    private static <T> T transMapToBean(Map<String, Object> map, Class<T> clazz, T t) throws Exception {
        Objects.requireNonNull(map, "map must not be null");
        if (clazz == null && t == null)
            throw new Exception("target clazz|t are not defined");
        if (t == null)
            t = clazz.newInstance();
        Set<String> keys = map.keySet();
        for (String key:keys){
            try {
                Field field = clazz.getDeclaredField(key);
                field.setAccessible(true);
                field.set(t, map.get(key));
            } catch (Exception e){}
        }
        return t;
    }


    //bean -> map
    public static Map<String, Object> transBeanToMap(Object obj){
        Map<String, Object> map = new HashMap<>();
        Field[] declaredFields = obj.getClass().getDeclaredFields();
        Arrays.stream(declaredFields).forEach(x->{
            x.setAccessible(true);
            String fieldName = x.getName();
            try {
                map.put(fieldName, x.get(obj));
            } catch (IllegalAccessException e) {}
        });
        return map;
    }



    public static <T> Object invoke(T t, String methodName, Object... args) throws Exception {
        return invoke(t,null, methodName, args);
    }

    public static <T> Object invoke(T t, Method method, Object... args) throws Exception {
        return invoke(t, method,null, args);
    }

    private static <T> Object invoke(T t, Method method, String methodName, Object... args) throws Exception {
        if (null == t){
            throw new Exception("param t is null ");
        }
        if (null == method && null == methodName){
            throw new Exception("param method and methodName is null ");
        }
        if (null == method){
            method = getMethodByName(t.getClass(),methodName);
        }
        return method.invoke(t, args);
    }


    /**
     * @param t
     * @param property
     * @param args
     * @param <T>
     * @return
     * @throws Exception
     */
    public static <T> Object invokeSet(T t, String property, Object... args) throws Exception {
        return invoke(t,field2GetterSetter(property,SET),args);
    }

    /**
     * @param t
     * @param property
     * @param <T>
     * @return
     * @throws Exception
     */
    public static <T> Object invokeGet(T t, String property) throws Exception {
        return invoke(t,field2GetterSetter(property,GET), null);
    }


    public static <T> Method getMethodByName(Class<?> clazz,String methodName) throws Exception {
        if (!classMap.containsKey(clazz))
            getDeclaredMethods(clazz);
        methodMap = classMap.get(clazz);
        if (methodMap.containsKey(methodName))
            return methodMap.get(methodName);
        else
            throw new Exception("no such method found");
    }

    protected static Method getDeclaredMethod(Class clazz,String methodName,Class... paramTypes) throws NoSuchMethodException {
        return clazz.getDeclaredMethod(methodName,paramTypes);
    }

    protected static Method[] getDeclaredMethods(Class clazz){
        Method[] declaredMethods = clazz.getDeclaredMethods();
        if (null == methodMap)
            methodMap = new HashMap<String,Method>();
        if (null != clazz.getSuperclass() &&
                !clazz.getSuperclass().getName().equals("java.lang.Class"))
            getDeclaredMethods(clazz.getSuperclass());
        for (Method m : declaredMethods)
            methodMap.put(m.getName(), m);
        classMap.put(clazz,methodMap);
        return declaredMethods;
    }

    protected static <T> Method[] getDeclaredMethods(T t){
        return getDeclaredMethods(t.getClass());
    }


    /**
     * property to GetterSetter method name
     * @param property
     * @param i
     * @return
     * @throws Exception
     */
    protected static String field2GetterSetter(String property,int i) throws Exception {
        if (property.trim().equals(""))
            throw new Exception("empty name");
        if (i == GET)
            return "get" + property.substring(0, 1).toUpperCase() + property.substring(1, property.length());
        else if (i == SET)
            return "set" + property.substring(0, 1).toUpperCase() + property.substring(1, property.length());
        throw new Exception("no this method defined");
    }




}
