//package com.fundoouserservice.security;
//
//import java.io.IOException;
//import java.util.Iterator;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Service;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import com.fundoouserservice.util.FilterExceptionHandler;
//
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.Cookie;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//
//@Service
//public class LoginFilter extends OncePerRequestFilter{
//
//	@Override
//	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)throws ServletException, IOException {
//		
//		System.out.println("LOGIN FILTER CALSS");
//		
//		Cookie[] cookies= request.getCookies();
//		boolean isAlreadyloggedIn=false;
//		
//		if(cookies !=null)
//		{
//			for (Cookie cookie : cookies) {
//				if(cookie.getName().equals("at") )
//				{
//					isAlreadyloggedIn =true;
//					break;
//				}
//			}
//		}
//		if(isAlreadyloggedIn)
//		{
//			FilterExceptionHandler.handleJwtExpire(response, HttpStatus.UNAUTHORIZED.value(),   "Failed to Login",
//                    "Please clear the cookies and login");
//			return;
//		}
//
//		filterChain.doFilter(request, response);
//		
//	}
//
//}
