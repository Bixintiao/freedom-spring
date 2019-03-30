package justTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.Set;

/**
 * @author hzy
 * @version Revision:v1.0,Date:2019年01月22日
 * @project freedom_spring
 * @description
 * @Modification Date:2019年01月22日 {填写修改说明}
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-context.xml")
public class JedisPoolTest {

    @Autowired
    JedisPool jedisPool;

    @Test
    public void jedisSrart(){
        Jedis jedis = new Jedis("127.0.0.1",6379);
        jedis.auth("6379");
        jedis.set("key","val");
        System.out.println("jedis.get:"+jedis.get("key"));
    }


    @Test
    public void jedisPoolStart(){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(30);//最大连接数
        jedisPoolConfig.setMaxIdle(30); //最大空余数
        jedisPoolConfig.setMinIdle(5);  //最小空余数
        JedisPool pool = new JedisPool(jedisPoolConfig,"127.0.0.1",6379);
        Jedis jedis = pool.getResource();
        jedis.auth("6379");
        jedis.set("abb","bcc");
        System.out.println("+++++++++++++++++++++"+jedis.get("abb"));
    }



    @Test
    public void springJedisStart(){
        Jedis resource = jedisPool.getResource();
        resource.sadd("skey","v1","v2","v3","v4","v5");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        Set<String> skey = resource.smembers("skey");
        skey.forEach(System.out::println);
    }






}
