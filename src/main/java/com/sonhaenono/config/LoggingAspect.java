package com.sonhaenono.config;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	private Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
	
	@Before(value = "execution(* com.sonhaenono..service.*.*(..)) or execution(* com.sonhaenono..controller.*.*(..))")
	public void loggin(JoinPoint joinPoint) {
		logger.debug("before call method : {}", joinPoint.getSignature());
		logger.debug("메서드 선언부: {} 전달 파라미터 : {}", joinPoint.getSignature(), Arrays.toString(joinPoint.getArgs()));
	}

	@AfterReturning(value = "execution(* com.sonhaenono..service.*.*(..)) or execution(* com.sonhaenono..controller.*.*(..))", returning = "obj")
	public void afterReturningMethod(JoinPoint joinPoint, Object obj) {
		logger.debug("afterReturning call method : {} ", joinPoint.getSignature());
		logger.debug("return value : {}", obj);
	}
	
	@AfterThrowing(value = "execution(* com.sonhaenono..service.*.*(..)) or execution(* com.sonhaenono..controller.*.*(..))", throwing = "exception")
	public void afterThrowingMethod(JoinPoint joinPoint, Exception exception) {
		logger.debug("afterThrowing call method : {}", joinPoint.getSignature());
		logger.debug("exception : {}", exception);
	}
}
