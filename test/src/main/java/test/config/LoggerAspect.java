package test.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class LoggerAspect {

    private final String EXECUTION = "execution(* test.controller..*(..))";


    @Around(EXECUTION)
    public Object printLog(ProceedingJoinPoint joinPoint) throws Throwable {

        String name = joinPoint.getSignature().getDeclaringTypeName();
        log.info("start name : {}", name);

        long beforeTime = System.currentTimeMillis();

        Object proceed = joinPoint.proceed();

        long afterTime = System.currentTimeMillis();
        long secDiffTime = (afterTime - beforeTime);
        log.info("endTime : {}", secDiffTime);

        return proceed;
    }
}
