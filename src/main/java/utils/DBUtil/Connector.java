package utils.DBUtil;

import org.junit.Test;

import java.sql.*;

/**
 * @author hzy
 * @version Revision:v1.0,Date:2018年11月24日
 * @project freedom_spring
 * @description
 * @Modification Date:2018年11月24日 {填写修改说明}
 */


public class Connector {

    static Connection conn = null;
    static String className = "oracle.jdbc.driver.OracleDriver";
    static String url = "jdbc:oracle:thin:@10.50.161.222:1521:DEV";
    static String name = "steeltrade";
    static String pwd = "zaq1xsw2cde3";

    @Test
    public void ConnectOracleTest() throws SQLException, ClassNotFoundException {
        getConnection();
        try {
            String sql = "select 1 from dual";
            java.sql.Statement statement = conn.createStatement();
            boolean execute = statement.execute(sql);
            System.out.println("execute sql:"+execute);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }


    /**
     * 获取数据库连接
     * @return
     */
    public static Connection getConnection() throws ClassNotFoundException, SQLException{
        if (null != conn) return conn;
        Class.forName(className);
        conn = DriverManager.getConnection(url, name, pwd);
        System.out.println("get jdbc connection:"+ conn);
        return conn;
    }

    public static void close(){
        try {
            if (null != conn) conn.close();
        } catch (SQLException e) {
            System.out.println("close connection failed ...");
            e.printStackTrace();
        }
        System.out.println("connection closed");
    }


    public static void close(Connection connection){
        try {
            connection.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }


}
