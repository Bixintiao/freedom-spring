package utils.DBUtil;


import java.util.HashMap;
import java.util.Map;

/**
 * @author zhengyu han
 * @version Revision:v1.0,Date:2019年01月08日
 * @project freedom_spring
 * @description
 * @Modification Date:2019年01月08日 {填写修改说明}
 */
public class DBType {

    protected static Map<String, String> typeMap;
    protected static Map<String, String> classMap;

    static {
        typeMap = new HashMap<String, String>();
        typeMap.put("char","Character");
        typeMap.put("varchar","String");
        typeMap.put("varchar2","String");
        typeMap.put("longvarchar","String");
        typeMap.put("timestamp","Date");
        typeMap.put("date","Date");
        typeMap.put("uniqueidentifier", "String");
        typeMap.put("bigint", "Long");
        typeMap.put("tinyint", "Boolean");
    }

    static {
        classMap = new HashMap<String, String>();
        classMap.put("BigDecimal","java.math.BigDecimal");
        classMap.put("Date","java.util.Date");
    }


    /**
     * db type to java type
     * @param typeName
     * @param precision
     * @param scale
     * @return
     * @throws Exception
     */
    public static String getPojoType(String typeName, Integer precision,Integer scale) throws Exception {
        String dbType = typeName.toLowerCase();
        if (dbType.equals("number")) {
            if (null != scale || scale != 0) {
                if (precision <= 7)
                    return "Double";
                else
                    return "BigDecimal";
            }
            else {
                if (precision == 1)
                    return "Boolean";
                else if (precision == 2)
                    return "Byte";
               else if (precision <= 4)
                    return "Short";
                else if (precision <= 9)
                    return "Integer";
                else if (precision <= 18)
                    return "Long";
                else
                    return "BigDecimal";
            }
        }
        if (typeMap.containsKey(dbType)){
            return typeMap.get(dbType);
        }
        throw new Exception("type " + typeName + " is not defined");
    }

    /**
     * @param type
     * @return
     * @throws Exception
     */
    public static String getPojoClass(String type) throws Exception {
        if (classMap.containsKey(type))
            return  classMap.get(type);
        return null;
    }

}
