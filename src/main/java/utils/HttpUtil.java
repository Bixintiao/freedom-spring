package utils;

import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;


/**
 * @author hzy
 * @version Revision:v1.0,Date:2019年01月09日
 * @project freedom_spring
 * @description
 * @Modification Date:2019年01月09日 {填写修改说明}
 */
public class HttpUtil {

    private static RequestConfig requestConfig = null;
    static {
        // 设置请求和传输超时时间  1000 毫秒 = 1 秒
        requestConfig = RequestConfig.custom().setSocketTimeout(180000).setConnectTimeout(180000).build();
    }


    public static String sendHttpPost(String url, String param) throws Exception
    {
        if (null == param){ param = ""; }
        String response = "";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        httpPost.setConfig(requestConfig);

        // 解决中文乱码问题
        StringEntity entity = new StringEntity(param, "utf-8");
        entity.setContentEncoding("UTF-8");
        entity.setContentType("application/json; charset=utf-8");
        httpPost.setEntity(entity);
        CloseableHttpResponse result = httpClient.execute(httpPost);

        // 请求发送成功，并得到响应
        if (result.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            response = EntityUtils.toString(result.getEntity(), "utf-8");
        }
        return response;
    }


    public static String sendHttpGet(String url) throws IOException {
        String response = "";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        httpGet.setConfig(requestConfig);

        CloseableHttpResponse result = httpClient.execute(httpGet);

        if (result.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            response = EntityUtils.toString(result.getEntity(), "utf-8");
        }
        return response;
    }


    public static String URLConnection(String url)throws Exception{
        URL u = new URL(url);
        URLConnection urlConnection = u.openConnection();
        InputStream inputStream = urlConnection.getInputStream();
        return IOUtil.inputStreamToString(inputStream);
    }


}
