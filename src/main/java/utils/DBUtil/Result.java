package utils.DBUtil;

import utils.BeanUtil;

import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.*;

/**
 * @Author hzy
 * @Date 2019/5/9 20:28
 * @Description
 */
public class Result {


    public static List<Column> getColumns(ResultSetMetaData metaData) throws SQLException {
        Objects.requireNonNull(metaData, "param metaData must not null");
        List<Column> columns = new ArrayList<>();
        for (int i=1; (i-1)<metaData.getColumnCount(); i++){
            Column c = new Column(i, metaData.getColumnName(i), metaData.getColumnType(i), metaData.getColumnTypeName(i),
                    metaData.getScale(i), metaData.getPrecision(i), metaData.getColumnClassName(i), metaData.getColumnLabel(i),
                    metaData.getColumnDisplaySize(i));
            columns.add(c);
        }
        return columns;
    }

    public static Map<String, Object> toMap(ResultSet resultSet) throws Exception {
        return toMap(resultSet, null);
    }

    static Map<String, Object> toMap(ResultSet resultSet, Map<String, Object> map) throws Exception {
        Map<String, Object> _m = new HashMap<>();
        List<Column> columns = getColumns(resultSet.getMetaData());
        while(resultSet.next()){
            for(Column c : columns){
                Object o = null;
                switch (c.getClassName()){
                    case "java.sql.Timestamp":
                        o = resultSet.getTimestamp(c.getIndex());
                        break;
                    case "java.lang.String":
                        o = resultSet.getString(c.getIndex());
                        break;
                    case "java.math.BigDecimal":
                        o = resultSet.getBigDecimal(c.getIndex());
                        break;
                }
                _m.put(c.getName(), o);
            }
        }
        return _m;
    }


}
