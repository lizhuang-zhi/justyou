package com.cloud.justyou.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHandlerInterceptor implements HandlerInterceptor {
    //目标方法执行之前(拦截器设置），再去注册
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //登录成功后，应该有用户的session
        Object user = request.getSession().getAttribute("loginUser");
        if(user == null){
            //未登陆，返回登陆页面
            request.setAttribute("msg","没有权限请先登陆");

            //转发这个request和response，返回到index.html
            request.getRequestDispatcher("/index.html").forward(request,response);

            //不放行
            return false;
        }else{
            //已登陆，放行请求
            return true;
        }

    }


}
