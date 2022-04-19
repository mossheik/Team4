package com.cg.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class ProjectSecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().ignoringAntMatchers("/api/**")
		.and().authorizeRequests()
		.antMatchers("api/customer").permitAll()
		.antMatchers("/api/admin/**").hasRole("ADMIN")
		.antMatchers("/api/security/**").hasRole("SECURITY")
		.and().formLogin().and().httpBasic();
	}
}
