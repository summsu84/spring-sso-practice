package com.teamjw.sso.ssoResource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import java.util.Collections;

@SpringBootApplication
public class SsoResourceApplication {

	@Value("${services.auth}")
	private String authService;

	/**
	 *  필터 설정
	 * @return
	 */
/*	@Bean
	public FilterRegistrationBean jwtFilter() {
		final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		registrationBean.setFilter(new JwtFilter());
		registrationBean.setInitParameters(Collections.singletonMap("services.auth", authService));
		registrationBean.addUrlPatterns("/resource");

		return registrationBean;
	}*/

	public static void main(String[] args) {
		SpringApplication.run(SsoResourceApplication.class, args);
	}

}
