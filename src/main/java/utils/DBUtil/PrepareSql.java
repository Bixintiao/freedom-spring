package utils.DBUtil;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author hzy
 * @Date 2019/5/8 19:40
 * @Description
 */
public class PrepareSql {

    final static String paramRex = "[:]+\\S+";

    public static PreparedStatement preparedStatement(java.sql.Connection conn, String sql, String[] keys, Object[] params) throws SQLException {
        int idx = 1;
        Map<String, Integer> keyMap = new HashMap<>();
        Matcher matcher = Pattern.compile(paramRex).matcher(sql);
        while (matcher.find())
            for (int i=0; i<=matcher.groupCount(); i++){
                keyMap.put(matcher.group(i).replace(":", ""), idx);
                idx++;
            }

        sql = keyMap == null ? sql : sql.replaceAll(paramRex, "?");
        PreparedStatement ps = conn.prepareStatement(sql);
        for (int i=0; i<keys.length; i++){
            preparedStatement(ps, keyMap.get(keys[i]), params[i]);
        }
        return ps;
    }

    public static PreparedStatement preparedStatement(PreparedStatement ps, Object... params) throws SQLException {
        if (null != params && params.length > 0)
            for (int i = 0; i <= params.length ;i++)
                preparedStatement(ps, i+1, params[i]);
        return ps;
    }


    private static PreparedStatement preparedStatement(PreparedStatement ps, int i, Object param) throws SQLException {
        if (param instanceof java.lang.String)
            ps.setString(i, (java.lang.String) param);
        else if (param instanceof java.lang.Integer || param.getClass() == int.class)
            ps.setInt(i, (int) param);
        else if (param instanceof java.lang.Byte || param.getClass() == byte.class)
            ps.setByte(i, (byte) param);
        else if (param instanceof java.lang.Short || param.getClass() == short.class)
            ps.setShort(i, (short) param);
        else if (param instanceof java.lang.Long || param.getClass() == long.class)
            ps.setLong(i, (long) param);
        else if (param instanceof java.lang.Float || param.getClass() == float.class)
            ps.setFloat(i, (float) param);
        else if (param instanceof java.lang.Double || param.getClass() == double.class)
            ps.setDouble(i, (double) param);
        else if (param instanceof java.util.Date)
            ps.setDate(i, new java.sql.Date( ((java.util.Date) param).getTime() ));
        else if (param instanceof java.lang.Object)
            ps.setBlob(i, (java.sql.Blob) param);
        else if (param instanceof java.sql.Date)
            ps.setDate(i,(java.sql.Date) param);
        else if (param instanceof java.sql.Array)
            ps.setArray(i, (java.sql.Array) param);
        else if (param instanceof java.math.BigDecimal)
            ps.setBigDecimal(i, (java.math.BigDecimal) param);
        else if (param instanceof java.sql.Blob)
            ps.setBlob(i, (java.sql.Blob) param);
        return ps;
    }

}
