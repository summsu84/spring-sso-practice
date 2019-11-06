package com.teamjw.sso.ssoResource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

@Controller
public class ResourceController {
    private static final String jwtTokenCookieName = "jwt-token";

    @Autowired JwtUtil jwtUtil;

    @RequestMapping("/")
    public String home() {
        return "redirect:/resource";
    }

    @RequestMapping("/resource")
    public String protectedResource() {
        return "resource";
    }

    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }

    @RequestMapping("/logout")
    public String logout(HttpServletResponse httpServletResponse) {
        jwtUtil.getCookieUtil().clear(httpServletResponse, jwtTokenCookieName);
        return "redirect:/";
    }
}
