package com.wipro.sandhya.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.example.questionService..*(..))")
    public void logBefore(JoinPoint joinPoint) {
        log.info("Entering method: {} with arguments: {}",
                 joinPoint.getSignature().toShortString(),
                 joinPoint.getArgs());
    }

    @AfterReturning(value = "execution(* com.example.questionService..*(..))", returning = "result")
    public void logAfter(JoinPoint joinPoint, Object result) {
        log.info("Exiting method: {} with return value: {}",
                 joinPoint.getSignature().toShortString(),
                 result);
    }
}
