package sample.simple;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Trace {

    @Before("execution(public * sample.simple..*(..))")
    public void traceMethodExecution(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        System.out.printf("[TRACE] Méthode appelée : %s.%s%n", className, methodName);
    }
}
