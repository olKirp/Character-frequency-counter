package com.t1consulting.counter.aspects;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

@Log4j2
@Aspect
@Configuration
public class FrequencyCounterControllerAspect {

    @Around("execution(* com.t1consulting.counter.controller.FrequencyCounterController.countCharacterFrequency(..))")
    public Object countCharacterFrequency(ProceedingJoinPoint point) throws Throwable {
        log.info("Incoming request POST frequencyCounter/count, request body: " + point.getArgs()[0] + ".");
        return point.proceed();
    }
}
