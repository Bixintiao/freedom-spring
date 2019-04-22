package justTest;

import org.junit.Test;
import utils.base.Base;

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


}
