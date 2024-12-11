//package com.fundoouserservice.security;
//
//import java.io.IOException;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.web.authentication.WebAuthenticationDetails;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import com.fundoouserservice.jwtservices.JWTService;
//import com.fundoouserservice.util.FilterExceptionHandler;
//import com.netflix.discovery.converters.Auto;
//
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.Cookie;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import lombok.AllArgsConstructor;
//
//@Component
//@AllArgsConstructor
//public class JwtAuthFilter extends OncePerRequestFilter {
//
////	@Autowired
//	private final JWTService jwtService;
//	
////	@Autowired
//	private final MyUserDetailsService myUserDetailsService;
//	
////	private UserDetails userDetails;// need to work in it
//	
//	@Override
//	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//		
//		System.out.println("from JWTAUTH FILTER CLASS");
//		
//		Cookie[] cookies = request.getCookies();
//		String accessToken =null;
////		String token = null;
//		String userName = null;
//		String email=null;
//		if(cookies != null)
//		{
//			for(Cookie cookie:cookies)
//			{
//				if(cookie.getName().equals("at"))
//				{
//					accessToken = cookie.getValue();
//					userName= jwtService.extractUserName(accessToken);
//					email = jwtService.extractEmail(accessToken);
//					break;
//				}
//			}
//			
//		}
//		
//		
//		
//
//		
//		if(email != null && SecurityContextHolder.getContext().getAuthentication() == null)
//		{
//			UserDetails userDetails;
//			userDetails= myUserDetailsService.loadUserByUsername(email);
//			System.out.println("---------------------");
//			boolean isValid = jwtService.validateToken(accessToken,userDetails);
//			if(isValid)
//			{
//				UsernamePasswordAuthenticationToken upat = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
//				upat.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//				SecurityContextHolder.getContext().setAuthentication(upat);
//			}
//			else
//			{
//				FilterExceptionHandler.handleJwtExpire(response, HttpStatus.UNAUTHORIZED.value(), "please provide a valid token", "please login and logout again");
//				return;
//			}
//		}
//		filterChain.doFilter(request, response);
//		
//		
//		
//		
//	}
//
//}
