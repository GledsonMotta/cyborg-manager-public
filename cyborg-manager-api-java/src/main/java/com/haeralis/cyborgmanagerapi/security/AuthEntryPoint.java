package com.haeralis.cyborgmanagerapi.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.haeralis.cyborgmanagerapi.exception.model.ApiError;
import com.haeralis.cyborgmanagerapi.util.Constants;

/**
 * 
 * @author Haeralis (GledsonMotta)
 *
 */
@Component
public class AuthEntryPoint extends BasicAuthenticationEntryPoint implements AccessDeniedHandler {
 		
	/**
	 * Return unauthorized JSON message
	 */
    @Override
    public void commence(
      HttpServletRequest request, HttpServletResponse response, AuthenticationException authEx) throws IOException 
      {
    	   	
    	response.addHeader("WWW-Authenticate", "Basic realm=" + getRealmName() + "");
    	response.setContentType(Constants.JSON_CTYPE);    	
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);        
        PrintWriter writer = response.getWriter();        
        writer.println((new ApiError(HttpStatus.UNAUTHORIZED, Constants.UNAUTHORIZED_MSG, authEx)).toJson());
    }
    
    /**
	 * Return forbidden JSON message
	 */
    @Override
    public void handle(
      HttpServletRequest request,
      HttpServletResponse response, 
      AccessDeniedException authEx) throws IOException, ServletException {         
    	response.setContentType(Constants.JSON_CTYPE);    	
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);        
        PrintWriter writer = response.getWriter();
        writer.println((new ApiError(HttpStatus.FORBIDDEN, Constants.FORBIDDEN_MSG, authEx)).toJson());    
    }    
    
 
    @Override
    public void afterPropertiesSet() {
        setRealmName(Constants.REALM);
        super.afterPropertiesSet();
    }    
}