package justTest;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author hzy
 * @version Revision:v1.0,Date:2019年01月12日
 * @project freedom_spring
 * @description
 * @Modification Date:2019年01月12日 {填写修改说明}
 */
public class LoggerTest {


    // slf4j
    Logger logger = LoggerFactory.getLogger(this.getClass());


    @Test
    public void loggerTest(){
        logger.warn("this is warn level message ->->->->");
        logger.info("this is org.slf4j.Logger & org.slf4j.LoggerFactory {}-{}-{}",1,2,3);
        logger.debug("this is debug level message ->->->->");
        logger.error("this is error level message ->->->->");
        logger.trace("logger.trace");
    }


}
