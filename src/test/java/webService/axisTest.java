package webService;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.junit.Test;
import javax.xml.namespace.QName;
import javax.xml.rpc.ServiceException;
import java.net.MalformedURLException;
import java.rmi.RemoteException;

/**
 * project freedom-spring
 *
 * @Author hzy
 * @Date 2019/3/6 18:50
 * @Description version 1.0
 */
public class axisTest {

    /**
     * 本项目 greeting
     * @throws ServiceException
     * @throws RemoteException
     * @throws MalformedURLException
     */
    @Test
    public void greetingTest() throws ServiceException, RemoteException, MalformedURLException {
        String endPoint = "http://localhost:9099/services/GreetingService";
        String namespace = "http://service.cxfWebService.modules.hzy.com";
        Service service = new Service();
        Call call = (Call) service.createCall();
        call.setTargetEndpointAddress(new java.net.URL(endPoint));
        call.setOperationName(new QName(namespace, "greeting"));
        call.addParameter("username", org.apache.axis.encoding.XMLType.XSD_STRING, javax.xml.rpc.ParameterMode.IN);
        call.setReturnType(org.apache.axis.encoding.XMLType.XSD_STRING);// 设置返回类型
        call.setUseSOAPAction(true);


        // 给方法传递参数，并且调用方法
        String temp = "you are good";
        Object[] obj = new Object[]{ temp };
        Object o = call.invoke(obj);
        System.out.println(" --------------------- ");
        System.out.println(o);
    }


    @Test
    public void helloServiceTest() throws ServiceException, MalformedURLException, RemoteException {
        String endPoint = "http://localhost:9099/services/HelloService";
        String namespace = "http://service.cxfWebService.modules.hzy.com";
        Service service = new Service();
        Call call = (Call) service.createCall();
        call.setTargetEndpointAddress(new java.net.URL(endPoint));
        call.setOperationName(new QName(namespace, "sayHello"));
        call.addParameter("userName", org.apache.axis.encoding.XMLType.XSD_STRING, javax.xml.rpc.ParameterMode.IN);
        call.setReturnType(org.apache.axis.encoding.XMLType.XSD_STRING);// 设置返回类型
        call.setUseSOAPAction(true);

        Object o = call.invoke(new Object[]{ "this is great" });
        System.out.println(" --------------------- ");
        System.out.println(o);
    }


    @Test
    public void minmetalsHelloTest() throws MalformedURLException, ServiceException, RemoteException {
        String endPoint = "http://localhost:8088/services/TestService";
        Service service = new Service();
        Call call = (Call) service.createCall();
        call.setTargetEndpointAddress(new java.net.URL(endPoint));
        call.setOperationName(new QName("http://service.jk.minmetals.baosight.com", "sayHello"));
        call.addParameter("userName", org.apache.axis.encoding.XMLType.XSD_STRING, javax.xml.rpc.ParameterMode.IN);
        call.setReturnType(org.apache.axis.encoding.XMLType.XSD_STRING);// 设置返回类型
        call.setUseSOAPAction(true);


        Object[] obj = new Object[]{ "say hi hi hi " };
        Object o = call.invoke(obj);
        System.out.println(" --------------------- ");
        System.out.println(o);
    }



}
