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

    /*
    * mvn install:install-file -Dfile=E:\ojdbc14.jar -DgroupId=com.hzy -DartifactId=oracle.jdbc -Dversion=ojdbc14 -Dpackaging=jar
    *
    * */


    static Connection conn = null;

    @Test
    public void ConnectOracleTest(){
        conn = getConnection();
        try {
            String sql = "select 1 from dual";
            String sql1 = "select 1 from persons";
            Statement statement = conn.createStatement();
            boolean execute = statement.execute(sql1);
            System.out.println("  执行sql:"+execute);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /**
     * 获取数据库连接
     * @return
     */
    public static Connection getConnection(){
        Connection conn = null;
        String className = "oracle.jdbc.driver.OracleDriver";
        String url = "jdbc:oracle:thin:@localhost:1521:orcl";
        String name = "oracle2018";
        String pwd = "orcl2018";
        try {
            Class.forName(className);
            conn = DriverManager.getConnection(url,name,pwd);
            System.out.println("  获取连接  :"+conn);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

}
