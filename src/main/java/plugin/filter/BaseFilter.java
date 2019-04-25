package plugin.filter;

import javax.servlet.*;
import java.io.IOException;
import java.util.Enumeration;

/**
 * project freedom-spring
 *
 * @Author hzy
 * @Date 2019/4/23 11:30
 * @Description version 1.0
 */
public class BaseFilter implements Filter {

    org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger(getClass());

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.debug("filter init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        log.debug("filter execute");
        print(request);
        filterChain.doFilter(request, response);  //传递给下一个Filter进行处理
    }

    @Override
    public void destroy() {
        log.debug("filter destroy");
    }


    void print(ServletRequest request){
        System.out.println("ContentType:"+request.getContentType());
        System.out.println("LocalName:"+request.getLocalName());
        System.out.println("LocalAddr:"+request.getLocalAddr());
        System.out.println("Scheme:"+request.getScheme());
        System.out.println("ServerName:"+request.getServerName());
        System.out.println("ServerPort:"+request.getServerPort());
        System.out.println("RealPath:"+request.getRealPath("/"));
        System.out.println("ServletContext:"+request.getServletContext());


        StringBuilder allAttr = new StringBuilder("{");
        Enumeration<String> attributeNames = request.getAttributeNames();
        while (attributeNames.hasMoreElements()){
            String s = attributeNames.nextElement();
            Object attribute = request.getAttribute(s);
            if (allAttr.length() != 1)
                allAttr.append(",");
            allAttr.append(s+":"+attribute);
        }
        allAttr.append("}");
        log.debug("attribute:"+allAttr);

        StringBuilder allParam = new StringBuilder("{");
        Enumeration<String> parameterNames = request.getParameterNames();
        while(parameterNames.hasMoreElements()){
            String s = parameterNames.nextElement();
            String parameter = request.getParameter(s);
            if (allParam.length() != 1)
                allParam.append(",");
            allParam.append(s+":"+parameter);
        }
        allParam.append("}");
        log.debug("parameter:"+allParam);
    }

}
