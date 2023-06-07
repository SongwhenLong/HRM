package com.hrm.resolver;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object obj, Exception e) {
        // 创建视图模型对象
        ModelAndView mv = new ModelAndView();
        // 判定异常的种类
        if (e instanceof NullPointerException){
            mv.addObject("msg","空指针异常");
        } else if (e instanceof NumberFormatException){
            mv.addObject("msg","数字转换异常");
        } else if (e instanceof StringIndexOutOfBoundsException){
            mv.addObject("msg","字符索引越界");
        } else if (e instanceof ArithmeticException){
            mv.addObject("msg","算术运算异常");
        } else {
            mv.addObject("msg",e.getClass().getName());
        }
        // 设置错误页面
        mv.setViewName("/error.jsp");
        return mv;
    }
}
