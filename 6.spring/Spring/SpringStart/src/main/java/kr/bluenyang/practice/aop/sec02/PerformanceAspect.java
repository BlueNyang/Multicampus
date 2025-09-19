package kr.bluenyang.practice.aop.sec02;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PerformanceAspect {

    @Pointcut("within(kr.bluenyang.practice.aop.sec02.*)")
    private void pointcutMethod() {
    }

    @Around("pointcutMethod()")
    public Object measure(ProceedingJoinPoint pjp) throws Throwable {
        Signature signature = pjp.getSignature();
        String methodName = signature.getName();

        long start = System.nanoTime();
        System.out.println("===============================");
        System.out.println("The method " + methodName + " begins");
        System.out.println("===============================");

        Object retVal = pjp.proceed();

        long end = System.nanoTime();
        System.out.println("===============================");
        System.out.println("The method " + methodName + " ends");
        System.out.println(methodName + " took " + (end - start) + " nanoseconds.");
        System.out.println("===============================");

        return retVal;
    }
}
