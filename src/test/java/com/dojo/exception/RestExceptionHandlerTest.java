package com.dojo.exception;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.MissingRequestHeaderException;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Header;


@SpringBootTest(classes = {RestExceptionHandlerTest.class})
public class RestExceptionHandlerTest {

	@Test
	public void test_handleUnauthorizedExceptions() {
		UnauthorizedException ex = new UnauthorizedException("Test_handleUnauthorizedException");
		RestExceptionHandler restExceptionHandler = new RestExceptionHandler();
		restExceptionHandler.handleUnauthorizedExceptions(ex);
	}
	
	@Test
	public void test_handleMissingRequestHeaderException() {
		MethodParameter methodParameter = null;
		MissingRequestHeaderException ex = new MissingRequestHeaderException("TestHeaderName",methodParameter);
		RestExceptionHandler restExceptionHandler = new RestExceptionHandler();
		restExceptionHandler.handleMissingRequestHeaderException(ex);
	}
	
	@Test
	public void test_handleExpiredJwtException() {
		Header header = null;
		Claims claims= null;
		String message = "test";
		ExpiredJwtException expiredJwtException = new ExpiredJwtException(header, claims, message);
		RestExceptionHandler restExceptionHandler = new RestExceptionHandler();	
		restExceptionHandler.handleExpiredJwtException(expiredJwtException);
	}
	
	
}
