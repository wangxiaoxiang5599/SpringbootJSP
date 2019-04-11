package com.shaw.boot.interceptor;

import com.shaw.boot.po.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception{
        String url = request.getRequestURI();
        if(url.indexOf("/login.action") >= 0){
            return true;
        }
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("USER_SESSION");
        if(user != null){
            return true;
        }
        request.setAttribute("msg", "您还没有登陆，请先登录！");
        request.getRequestDispatcher("/login.action").forward(request, response);
        return false;
    }
}
