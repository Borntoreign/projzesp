package pl.lodz.p.carpooling.exceptionhandling;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Mateusz Surmański on 25.10.2015.
 */
@Aspect
public class ExceptionHandlingAspect {

    private Logger logger = LoggerFactory.getLogger("Credit Service Logger");

    @AfterThrowing(pointcut = "execution(* pl.lodz.p.carpooling.* (..))", throwing = "e")
    public void exceptionInterceptor(Exception e) {
        logger.error(e.getMessage(), e);
    }
}

