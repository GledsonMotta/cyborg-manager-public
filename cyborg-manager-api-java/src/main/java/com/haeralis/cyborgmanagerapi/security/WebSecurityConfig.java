package com.haeralis.cyborgmanagerapi.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
			
	@Autowired
    private AuthEntryPoint authEntryPoint;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
        .authorizeRequests()
        .antMatchers("/").permitAll()
        /*.antMatchers("/attribute-types/**").authenticated()
        .antMatchers("/attribute/**").hasRole("USER")
        .antMatchers("/attribute-types/**").hasRole("ADMIN")
        .antMatchers("/robot/**").hasAnyRole("USER", "ADMIN")*/
        .and()
			.logout()
				.permitAll()
		.and()
		.httpBasic()
		.authenticationEntryPoint(authEntryPoint);
		
		http
		.exceptionHandling()
		.authenticationEntryPoint(authEntryPoint)
		.accessDeniedHandler(authEntryPoint);
				
	}
	
	
	/*
	 * In memory user method 1
	 */
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
          .withUser("admin").password(passwordEncoder().encode("admin")).roles("ADMIN");
    }
	
	/*
	 * In memory user method 2
	 */
	@Bean
	@Override
	public UserDetailsService userDetailsService() {
		UserDetails user =
			User.withUsername("user")
			.password(passwordEncoder().encode("user"))
			.roles("USER")
			.build();

		return new InMemoryUserDetailsManager(user);
	}
	
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}