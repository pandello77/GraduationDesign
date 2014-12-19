package com.ccnu.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;



@Aspect
public class SecurityHandler {
	
	@Around("execution(* round*(..))")
	public void doRound(ProceedingJoinPoint pjp) throws Throwable{
//		System.out.println("…Ë÷√ ÷ª˙∫≈¬Î ß∞‹");
		pjp.proceed();
		
	}

	
}