package com.teamjw.sso.ssoResource.config;

import com.teamjw.sso.ssoResource.CookieUtil;
import com.teamjw.sso.ssoResource.JwtUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *  Configuration 등록
 */
@Configuration
public class AppConfig {

/*    @Bean
    public Co hello() {
        Hello hello = new Hello();
        hello.setName("wonwoo");
        hello.print(helloPrint()); //DI
        return hello;
    }*/

    @Bean
    public CookieUtil cookieUtil()
    {
        return new CookieUtil();
    }

    @Bean
    public JwtUtil jwtUtil() {

        JwtUtil jwtUtil = new JwtUtil();
        jwtUtil.setCookieUtil(cookieUtil());

        return jwtUtil;
    }

/*    @Bean
    public FreeMarkerConfigurer freeMarkerConfigurer(){
        FreeMarkerConfigurer freeMarkerConfigurer = new FreeMarkerConfigurer();
        freeMarkerConfigurer.setTemplateLoaderPath("classpath:/templates"); //defines the classpath location of the freemarker templates
        freeMarkerConfigurer.setDefaultEncoding("UTF-8"); // Default encoding of the template files
        return freeMarkerConfigurer;
    }*/

}
