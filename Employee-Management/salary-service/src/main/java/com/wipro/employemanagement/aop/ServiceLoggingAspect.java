package com.wipro.employemanagement.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceLoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(ServiceLoggingAspect.class);

    /**
     * Pointcut: matches all methods in classes under service package
     */
    @Pointcut("execution(* com.wipro.employemanagement.service..*(..))")
    public void serviceMethods() {}

    /**
     * Log method entry
     */
    @Before("serviceMethods()")
    public void logBefore(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        logger.info("Entering method: {}.{}() with arguments = {}",
                signature.getDeclaringTypeName(),
                signature.getName(),
                joinPoint.getArgs());
    }

    /**
     * Log method exit
     */
    @AfterReturning(pointcut = "serviceMethods()", returning = "result")
    public void logAfter(JoinPoint joinPoint, Object result) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        logger.info("Exiting method: {}.{}() with result = {}",
                signature.getDeclaringTypeName(),
                signature.getName(),
                result);
    }

    /**
     * Log exceptions
     */
    @AfterThrowing(pointcut = "serviceMethods()", throwing = "ex")
    public void logException(JoinPoint joinPoint, Throwable ex) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        logger.error("Exception in method: {}.{}() with message = {}",
                signature.getDeclaringTypeName(),
                signature.getName(),
                ex.getMessage(), ex);
    }

    /**
     * Measure execution time
     */
    @Around("serviceMethods()")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - start;

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        logger.info("Executed method: {}.{}() in {} ms",
                signature.getDeclaringTypeName(),
                signature.getName(),
                executionTime);

        return proceed;
    }
}
