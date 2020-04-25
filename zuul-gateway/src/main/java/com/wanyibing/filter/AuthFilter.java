package com.wanyibing.filter;


import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

@Component
public class AuthFilter extends ZuulFilter {


    /**
     * 过滤的类型：路由 之前/之时/之后
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 在zuul网关里 是可以有多个 过滤器 可以设置过滤顺序
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 添加 是否 过滤 的条件
     * @return
     */
    @Override
    public boolean shouldFilter() {
        //业务逻辑判断  获取 request 对象
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        //获取请求的URL
        String requestURI = request.getRequestURI();
        StringBuffer requestURL = request.getRequestURL();
        System.out.println("<<<<requestURI:   "+requestURI);
        System.out.println("<<<<requestURL:   "+requestURL);
        //是否 授权
        String token = request.getParameter("token");
        if(StringUtils.isEmpty(token)){
            //设置为false，就不会路由到后端的服务
            requestContext.setSendZuulResponse(false);
            //设置http相应的状态码  :  401  表示未授权
            requestContext.setResponseStatusCode(401);
            //返回响应信息
            HttpServletResponse response = requestContext.getResponse();
            response.setContentType("application/json;charset=utf-8");
            try {
                response.getWriter().write("{\"code:\":401,\"message\":\"未授权\"}");
            }catch (IOException e){
                e.printStackTrace();
            }
        }

        if(requestURI.startsWith("/user")){
            return false;
        }
        return true;
    }

    /**
     * 执行过滤逻辑
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {


        return null;
    }
}
