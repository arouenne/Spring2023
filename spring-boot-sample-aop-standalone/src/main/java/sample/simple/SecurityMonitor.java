package sample.simple;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SecurityMonitor {
    private boolean isAuthenticated(){
        double d = Math.random();
        return d < 0.5;
    }

    @Around("execution(public * sample.simple.bank.Bank.getBankName())")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        if (isAuthenticated()) {
            return joinPoint.proceed();
        }else{
            throw new Exception("Error : Not Authenticated");
        }
    }
}
