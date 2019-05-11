package utils.DBUtil;

import org.junit.Test;
import utils.StringUtil;
import java.sql.*;
import java.util.*;

/**
 * @author hzy
 * @version Revision:v1.0,Date:2019年01月04日
 * @project freedom_spring
 * @description
 * @Modification Date:2019年01月04日 {填写修改说明}
 */
public class DBTool {


    private static String LINE = "\n";
    private static String TAB = "\t";
    protected static final String IMPORT = "import";

    public static Map<String,String> classMap = new HashMap<>();


    @Test
    public void executeSqlTest() throws SQLException, ClassNotFoundException {
        String sql = "select * from SYS_USER where create_time>? ";
        Connection conn = Connector.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    /**
     *
     */
    @Test
    public void getTableClass(){
        try {
            String tableName = "SYS_USER";
            ResultSetMetaData resultSetMetaData = getResultSetMetaData(tableName);
            printMetaData(resultSetMetaData);
            /*String s = tableToClass(tableName);
            String filePath = "E:\\Temp\\outfile\\"+StringUtil.toCamel(tableName)+".java";
            System.out.println(s);
            IOUtil.writeToFile(s,filePath);*/
        } catch (Exception e){
            e.printStackTrace();
        }
    }


    /**
     * @param tableName
     * @return
     * @throws SQLException
     */
    public static String tableToClass(String tableName) throws Exception
    {
        ResultSetMetaData metaData = getResultSetMetaData(tableName);
        int columnCount = metaData.getColumnCount();
        StringBuilder sb = new StringBuilder();
        StringBuilder importClass = new StringBuilder();
        StringBuilder property = new StringBuilder();
        StringBuilder getterSetter = new StringBuilder();

        // append property
        for (int i = 1; i <=columnCount; i++){
            String columnName = StringUtil.toCamel(metaData.getColumnName(i),false);
            String columnType = DBType.getPojoType(metaData.getColumnTypeName(i),metaData.getPrecision(i),metaData.getScale(i));
            String className = DBType.getPojoClass(columnType);
            //class
            if (null != className){
                if (!classMap.containsKey(columnType))
                    classMap.put(columnType,IMPORT+TAB+className+";");
            }
            //property
            property.append(TAB + "private " + columnType +TAB + columnName + ";" + LINE);
            //getter setter
            getterSetter.append(toGetMethod(columnType,columnName)+LINE);
            getterSetter.append(toSetMethod(columnType,columnName)+LINE);
        }

        classMap.values().forEach(x-> sb.append(x+LINE));
        sb.append(LINE);
        sb.append("public class " + StringUtil.toCamel(tableName) + "{");
        sb.append(LINE+LINE);
        sb.append(property.toString());
        sb.append(LINE+LINE);
        sb.append(getterSetter.toString());
        sb.append("}");
        return sb.toString();
    }

    public static ResultSetMetaData getResultSetMetaData(String tableName) throws Exception {
        String sql = "select * from "+tableName+" where 1<>1";
        ResultSet rs = executeQuery(sql);
        return rs.getMetaData();
    }




    /**
     * @param sql
     * @return
     * @throws SQLException
     */
    public static ResultSet executeQuery(String sql) throws Exception{
        return executeQuery(sql,null);
    }


    /**
     * PreparedStatement index 1...n
     * Array index 0...n
     * @param sql
     * @param params
     * @return
     * @throws SQLException
     */
    public static ResultSet executeQuery(String sql,Object[] params) throws Exception {
        Connection conn = Connector.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        if (sql.contains("?")){
            ps = preparedStatement1(ps,params);
        } else {

        }
        return ps.executeQuery();
    }


    public static boolean execute(PreparedStatement ps,String sql) throws SQLException {
        return ps.execute(sql);
    }


    /**
     * @param ps
     * @param params
     * @return
     * @throws SQLException
     */
    public static PreparedStatement preparedStatement1(PreparedStatement ps, Object[] params) throws SQLException {
        if (null != params){
            for (int i = 1; i <= params.length ;i++){
                Object param = params[i-1];
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
                else if (param instanceof java.util.Date){
                    java.util.Date d = (java.util.Date)param;
                    ps.setDate(i, new java.sql.Date(d.getTime()));
                }
            }
        }
        return ps;
    }


    public static PreparedStatement preparedStatement2(PreparedStatement ps, String[] names, Object[] params) throws SQLException {
        if (null != names && null != params){
            String name = null;
            Object param = null;
            for (int i = 0; i<names.length; i++){
                name = names[i];
                param = params[i];
                prepared(ps,name,param);
            }
        }
        return ps;
    }


    protected static void prepared(PreparedStatement ps, Integer index, Object param){
        prepared(ps,index,null,param);
    }

    protected static void prepared(PreparedStatement ps, String name, Object param){
        prepared(ps,null,name,param);
    }

    private static void prepared(PreparedStatement ps, Integer index, String name, Object param){

    }



    public Set<String> getAllTableNames(String dbType) throws Exception {
        Set<String> tableNames = new HashSet<>();
        String type = dbType.toLowerCase();
        ResultSet resultSet = null ;

        String mysql = "select table_name from information_schema.tables  where table_schema = 'ubmpdb' and table_type = 'BASE TABLE' ";
        String oracle = "select table_name from user_tables";
        String sqlserver = "select name from sys.tables go";


        if (type.equals("mysql"))
            resultSet = executeQuery(mysql);
        else if (type.equals("oracle"))
            resultSet = executeQuery(mysql);
        else if (type.equals("sqlserver"))
            resultSet = executeQuery(sqlserver);



        return tableNames;
    }



    /**
     * toGetMethod
     * @param type
     * @param property
     * @return
     */
    protected static String toGetMethod(String type, String property) throws Exception {
        return TAB+"public "+type+" get" + StringUtil.firstCharBigger(property) +"(){" +LINE + TAB+TAB+"return this."+property+";"+LINE+TAB+ "}";
    }

    /**
     * toSetMethod
     * @param type
     * @param property
     * @return
     * @throws Exception
     */
    protected static String toSetMethod(String type, String property) throws Exception {
        return TAB+"public void set" + StringUtil.firstCharBigger(property) +"("+type+" " + property+"){" +LINE + TAB+TAB+"this."+property +"="+ property+";"+LINE+TAB+ "}";
    }



    public void printResultSet(ResultSet resultSet) throws SQLException {
        Map<String,Class> map = new HashMap<>();
        ResultSetMetaData metaData = resultSet.getMetaData();
    }


    /**
     * print ResultSetMetaData
     * @param metaData
     * @throws SQLException
     */
    public void printMetaData(ResultSetMetaData metaData) throws SQLException {
        int columnCount = metaData.getColumnCount();
        for (int i = 1; i<=columnCount; i++){
            System.out.println("***************  column:"+metaData.getColumnName(i) + "   ***************");
            System.out.println("catalogName:"+metaData.getCatalogName(i));
            System.out.println("columnClassName:"+metaData.getColumnClassName(i));
            System.out.println("columnLabel:"+metaData.getColumnLabel(i));
            System.out.println("columnTypeName:"+metaData.getColumnTypeName(i));
            System.out.println("schemaName:"+metaData.getSchemaName(i));
            System.out.println("tableName:"+metaData.getTableName(i));
            System.out.println("columnDisplaySize:"+metaData.getColumnDisplaySize(i));
            System.out.println("precision:"+metaData.getPrecision(i));
            System.out.println("scale:"+metaData.getScale(i));
            System.out.println("columnType:"+metaData.getColumnType(i));
        }
    }


}
