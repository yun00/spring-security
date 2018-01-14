package com.yun.web.interceptor;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class TimeInterceptor implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	    //System.out.println("afterCompletion");
        Long start = (Long)request.getAttribute("startTime");
        //System.out.println("time incceptor 耗时："+(new Date().getTime()-start));
    	//System.out.println("ex:"+ex);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndViw)
			throws Exception {
        //System.out.println("postHandle");
        Long start = (Long)request.getAttribute("startTime");
        //System.out.println("time incceptor 耗时："+(new Date().getTime()-start));
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
	    //System.out.println("preHandler");
	    //System.out.println(((HandlerMethod)handler).getBean().getClass().getName());
	    //System.out.println(((HandlerMethod)handler).getMethod().getName());
	    request.setAttribute("startTime",new Date().getTime());
	    return true;
	}

}
