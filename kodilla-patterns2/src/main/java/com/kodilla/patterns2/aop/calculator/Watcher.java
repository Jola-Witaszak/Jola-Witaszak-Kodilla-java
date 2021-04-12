package com.kodilla.patterns2.aop.calculator;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Aspect
public class Watcher {
    public static final Logger LOGGER = LoggerFactory.getLogger(Watcher.class);

    @Before(value = "execution(* com.kodilla.patterns2.aop.calculator.Calculator.factorial(..))" +
            "&& args(theNumber) && target(object)", argNames = "theNumber,object")
    public void logEvent(BigDecimal theNumber, Object object) {
        LOGGER.info("Class: " + object.getClass().getName() + ", Args: " + theNumber);
    }

    @Around("execution(* com.kodilla.patterns2.aop.calculator.Calculator.factorial(..))")
    public Object measureTime(final ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object result;
        try {
            long begin = System.currentTimeMillis();
            result = proceedingJoinPoint.proceed();
            long end = System.currentTimeMillis();
            LOGGER.info("Time consumed: " + (end - begin) + " [ms]");
        } catch (Throwable throwable) {
            LOGGER.error(throwable.getMessage());
            throw throwable;
        }
        return result;
    }
    @After("execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..))")
    public void logEachMethodCall() {
        LOGGER.info("Method processOrder() in class OrderFacade has been started..." );
    }
}
