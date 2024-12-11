package com.fundoouserservice.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fundoouserservice.jwtservices.JWTService;
import com.netflix.discovery.converters.Auto;

import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
@EnableWebSecurity
public class SecurityConfig {

//	private LoginFilter loginFilter;
	
	
//	private final MyUserDetailsService myUserDetailsService;
	
//	private final JwtAuthFilter authFilter;
	
//	private final JWTService jwtService;
	
	
	
	
	
//	@Bean
//	@Order(1)
//	SecurityFilterChain securityFilterChainCheckLogin(HttpSecurity security) throws Exception
//	{
//		System.out.println("this is a filter chain for login ");
//		return security.csrf(customizer -> customizer.disable())
//						.securityMatchers(match -> match.requestMatchers("/api/v1/user/login","/api/v1/user/adduser"))
//						.authorizeHttpRequests(authorize -> authorize.anyRequest().permitAll())
//						.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
////						.httpBasic(Customizer.withDefaults())
//						.addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class)
////						.authorizeHttpRequests(authorize -> authorize.requestMatchers("/api/v1/user/login","/api/v1/user/adduser") .permitAll())
////						.authenticationProvider(authenticationProvider())
//						.build();
//	}
	
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception
	{
		return security.csrf(csrf -> csrf.disable())
						.authorizeHttpRequests(auth -> auth.requestMatchers("/api/v1/user/**","/actuator/**").permitAll().anyRequest().authenticated())
						.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
						.httpBasic(Customizer.withDefaults())
//						.addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class)
//						.authenticationProvider(authenticationProvider())
						.build();
				
	}





	
//	@Bean
//	public AuthenticationProvider authenticationProvider()
//	{
//		DaoAuthenticationProvider provider =new DaoAuthenticationProvider();
//		provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
//		provider.setUserDetailsService(myUserDetailsService);
//		return provider;
//	}
//	
//	@Bean
//	AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception
//	{
//		return authenticationConfiguration.getAuthenticationManager(); 
//	}
	
}
