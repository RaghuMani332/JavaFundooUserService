package com.fundoouserservice.jwtservices;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.fundoouserservice.entity.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JWTService {
	
	
	@Value("${application.jwt.secretkey}")
	private String secretKey;

//	public boolean validateToken(String token,UserDetails userDetails) {
//		Claims c= extractToken(token);
//		final String email=extractEmail(token);
//		return(email.equals(userDetails.getUsername()) && isTokenExpired(token));
//	}
//	
	
//	 public boolean isTokenExpired(String token) {
//		return extractToken(token).getExpiration().after(new Date());
//	}
//
//
//	public String extractUserName(String token) {
//		return extractToken(token).getSubject();
//	}
//
//
//	public Claims extractToken(String token) {
//	        try {
//	            Claims claims = Jwts.parser()
//	                                .verifyWith((SecretKey) getKey())  // Validate using the same signing key
//	                                .build()
//	                                .parseSignedClaims(token)  // Parse the JWT token
//	                                .getPayload();
//	            return claims;  // Extract the subject (name) from the claims
//	        } catch (JwtException | IllegalArgumentException e) {
//	            // Handle exceptions (invalid token, expired token, etc.)
//	            throw new RuntimeException("Invalid or expired token", e);
//	        }
//	    }

	 private Key getKey() {
			byte[] keyBytes = Decoders.BASE64.decode(secretKey);
			return Keys.hmacShaKeyFor(keyBytes);
		}


	public String generateToken(User user, long expiry) {
		Map<String, Object> claim= new HashMap<>();
		claim.put("email",user.getEmail());
		
		return Jwts.builder()
					.claims()
					.add(claim)
					.subject(user.getUserName())
					.issuedAt(new Date(System.currentTimeMillis()))
					.expiration(new Date(System.currentTimeMillis() + expiry))
					.and()
					.signWith(getKey())
					.compact();
		
	}


//	public String extractEmail(String accessToken) {
//		return extractToken(accessToken).get("email").toString();
//				
//	}
	

}
