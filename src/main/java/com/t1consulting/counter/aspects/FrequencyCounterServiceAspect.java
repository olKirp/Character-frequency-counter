package com.t1consulting.counter.aspects;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;

@Log4j2
@Aspect
@Configuration
public class FrequencyCounterServiceAspect {

    @Around("execution(* com.t1consulting.counter.service.FrequencyCounterService+.countCharacterFrequency(..))")
    public Object countCharacterFrequency(ProceedingJoinPoint point) throws Throwable {
        log.info("Count character frequency in string \"" + point.getArgs()[0] + "\".");
        LinkedHashMap<Character, Integer> map = (LinkedHashMap<Character, Integer>) point.proceed();
        log.info("LinkedHashMap with " + map.size() + " elements was successfully created");
        return map;
    }

}
