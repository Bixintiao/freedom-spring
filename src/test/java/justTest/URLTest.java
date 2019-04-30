package justTest;

import org.junit.Test;
import utils.IOUtil;

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
        String u = "http://localhost:8080/Minmetals-logistics-system/getjsonp?UserAcct=dev";
        String u1 = "https://www.baidu.com/";
        try {
            URL url = new URL(u);
            URLConnection urlConn = url.openConnection();
            InputStream is = urlConn.getInputStream();
            System.out.println(IOUtil.inputStreamToString(is, "utf-8"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void baidu() throws Exception {
        URL url = new URL("http://localhost:8080/Minmetals-logistics-system/getjsonp?UserAcct=dev");
        Object content = url.getContent();
        URLConnection urlConnection = url.openConnection();
        InputStream inputStream = urlConnection.getInputStream();
        System.out.println(IOUtil.inputStreamToString(inputStream));
    }


}
