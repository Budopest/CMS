package customer.management.system.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@Aspect
public class CMSLoggingAspect {

    //setup logger
    private Logger logger = Logger.getLogger(getClass().getName());

    //declare pointcuts
    @Pointcut(value = "execution(* customer.management.system.web.*.*(..))")
    private void webPackage(){}
    @Pointcut(value = "execution(* customer.management.system.dao.*.*(..))")
    private void daoPackage(){}
    @Pointcut(value = "execution(* customer.management.system.service.*.*(..))")
    private void servicePackage(){}
    @Pointcut(value = "webPackage() || daoPackage() || servicePackage()")
    private void webDaoServicePackages(){}

    @Before("webDaoServicePackages()")
    public void beforeListingCustomers(JoinPoint joinPoint){
        logger.info("Methods Signature==> " + joinPoint.getSignature().toShortString());
    }


}
