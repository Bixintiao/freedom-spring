package utils;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hzy
 * @version Revision:v1.0,Date:2019年01月05日
 * @project ubmp
 * @description
 * @Modification Date:2019年01月05日 {填写修改说明}
 */
public class Entity {


    public static final int GET = 0;
    public static final int SET = 1;
    private static Map<Class,Map<String,Method>> classMap = new HashMap<>();
    private static Map<String,Method> methodMap;


    /**
     * @param t
     * @param methodName
     * @param args
     * @param <T>
     * @return
     * @throws Exception
     */
    public static <T> Object invoke(T t, String methodName, Object... args) throws Exception {
        return invoke(t,null, methodName, args);
    }

    /**
     * @param t
     * @param method
     * @param args
     * @param <T>
     * @return
     * @throws Exception
     */
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
