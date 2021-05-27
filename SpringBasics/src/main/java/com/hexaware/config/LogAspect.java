package com.hexaware.config;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Aspect
@Configuration
public class LogAspect{

	@Before("execution(* com.hexaware.config.*.test*())")
	public void before(JoinPoint joinPoint) {
		System.out.println("in advice");
//System.out.println(joinPoint.getThis());		
	}

}
