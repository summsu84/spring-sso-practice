package com.teamjw.sso.ssoResource.interceptor;

import com.teamjw.sso.ssoResource.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Logger;

public class ResourceInterceptor extends HandlerInterceptorAdapter {

    private static Logger log = Logger.getLogger(ResourceInterceptor.class.getName());
    private static final String jwtTokenCookieName = "jwt-token";
    private static final String signingKey = "signingKey";
    // Autowiring
    @Autowired
    JwtUtil jwtUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("Interceptor > preHandle");

        boolean retVal = true;

        String username = jwtUtil.getSubject(request, jwtTokenCookieName, signingKey);
        if(username == null){
            String authService = "http://localhost:8081/login";
            response.sendRedirect(authService + "?redirect=" + request.getRequestURL());
            retVal = false;
        } else{
            request.setAttribute("username", username);

            retVal = true;
        }

        return retVal;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("Interceptor > postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object, Exception arg3) throws Exception {
        log.info("Interceptor > afterCompletion" );
    }

}
