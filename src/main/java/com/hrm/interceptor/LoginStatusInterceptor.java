package com.hrm.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录状态判定
 */
public class LoginStatusInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("前处理...");
        Object isLogin = request.getSession().getAttribute("isLogin");
        if (isLogin == null || !(isLogin instanceof String) || !((String)isLogin).equals("OK") ){
            // 重定向到login.jsp
            response.sendRedirect("http://localhost:8080/Day59/login.jsp");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("后处理...");
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("就绪之后处理");
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
