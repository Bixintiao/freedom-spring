package justTest;

import org.junit.Test;
import utils.IOUtil;
import utils.base.Base;

import java.io.IOException;
import java.util.logging.Level;

/**
 * @author hzy
 * @version Revision:v1.0,Date:2019年01月12日
 * @project freedom_spring
 * @description
 * @Modification Date:2019年01月12日 {填写修改说明}
 */
public class LoggerTest extends Base {


    @Test
    public void commonsLoggingTest(){
        org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(getClass());
        log.info("commonsLogging - >< - info");
    }


    @Test
    public void slf4jLoggerTest(){
        // slf4j
        org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(getClass());
        logger.info("info message 【{}】-【{}】",99,1001);
        logger.info("info message");
        logger.debug("debug message ");
    }



    @Test
    public void log4j2Test() throws Exception {
        org.apache.logging.log4j.Logger logger = org.apache.logging.log4j.LogManager.getLogger(getClass());
        logger.trace("trace level message");
        logger.info( "info  level message 【{}】-【{}】",99,1001);
        logger.debug("debug level message");
        logger.error("error level message");
        logger.fatal("fatal level message");
        try {
            throw new Exception("exception");
        } catch (Exception e){
            logger.error(e);
            e.printStackTrace();
        }
    }


    @Test
    public void testRolling() throws IOException {
        org.apache.logging.log4j.Logger logger = org.apache.logging.log4j.LogManager.getLogger(getClass());
        String log = IOUtil.fisReadFile("C:\\Users\\韩正禹\\Desktop\\debug.1.log", "utf-8");
        System.out.println(log);
    }


    @Test
    public void javaLogging(){
        java.util.logging.Logger logger = java.util.logging.Logger.getLogger("2234");
        logger.info("info message");
        logger.log(Level.WARNING,"warning ");
        logger.log(Level.SEVERE," . . . ");
    }




}
