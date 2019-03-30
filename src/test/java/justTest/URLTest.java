package justTest;

import org.junit.Test;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author hzy
 * @version Revision:v1.0,Date:2019年01月12日
 * @project freedom_spring
 * @description
 * @Modification Date:2019年01月12日 {填写修改说明}
 */
public class URLTest {



    @Test
    public void helloURL(){
        String u = "http://localhost:8088/freedom-spring/getResponse";
        String u1 = "https://www.baidu.com/";
        try {
            URL url = new URL(u1);
            URLConnection urlConn = url.openConnection();
            InputStream is = urlConn.getInputStream();

            int len = 0;
            byte[] buffer = new byte[1024];
            while ((len = is.read(buffer)) != -1 ){
                System.out.println(new String(buffer,0,len));
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
