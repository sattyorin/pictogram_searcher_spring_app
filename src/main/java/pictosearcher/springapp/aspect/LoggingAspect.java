package pictosearcher.springapp.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Aspect for logging execution of controller methods.
 */
@Aspect
@Component
public class LoggingAspect {

  private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

  /**
   * Logs before the execution of a controller method.
   *
   * @param joinPoint provides information about the method being executed
   */
  @Before("execution(* pictosearcher.springapp.controller..*(..))")
  public void logBeforeController(JoinPoint joinPoint) {
    logger.info("Before executing controller method : {}", joinPoint.getSignature().getName());
  }

  /**
   * Logs after the execution of a controller method.
   *
   * @param joinPoint provides information about the method being executed
   */
  @After("execution(* pictosearcher.springapp.controller..*(..))")
  public void logAfterController(JoinPoint joinPoint) {
    logger.info("After executing controller method : {}", joinPoint.getSignature().getName());
  }
}
