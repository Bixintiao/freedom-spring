package justTest;

import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;
import org.junit.Test;
import net.sf.ehcache.CacheManager;

import java.net.URL;

/**
 * @author hzy
 * @version Revision:v1.0,Date:2019年01月12日
 * @project freedom_spring
 * @description
 * @Modification Date:2019年01月12日 {填写修改说明}
 */
public class EhChaheTest {

    private static final String path = "/conf/ehcache-setting.xml";
    private URL url;
    private CacheManager cacheManager;


    /**
     * ehcache 缓存，删除
     */
    @Test
    public void putRemoveCacheTest(){
        url = getClass().getResource(path);
        cacheManager = CacheManager.create(url);
        Cache cache = cacheManager.getCache("cacheTest");

        Element e1 = new Element("key","this is cache value");
        cache.put(e1);  //put in cache

        Element e2 = cache.get("key");
        System.out.println("e2:" + e2);
        System.out.println(e2.getValue());
        cache.remove("key");//remove from cache


        Element e3 = cache.get("key");
        System.out.println("e3:" + e3);
        System.out.println(e3.getValue());
    }


    /**
     * 缓存超时测试
     */
    @Test
    public void cacheTimeOutTest(){
        url = getClass().getResource(path);
        cacheManager = CacheManager.create(url);
        Cache cache = cacheManager.getCache("cacheTest");


        Element e1 = new Element("key","this is cache value");
        cache.put(e1);  //put in cache
        System.out.println("----------------- after put cache.getKey" + cache.get("key"));

        try {
            // 缓存5秒钟  测试超时
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("----------------- after sleep");

        Element e2 = cache.get("key");
        System.out.println("e2:" + e2);
        System.out.println(e2.getValue());
    }



}
