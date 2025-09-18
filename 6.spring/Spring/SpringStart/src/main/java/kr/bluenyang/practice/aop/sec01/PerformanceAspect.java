package kr.bluenyang.practice.aop.sec01;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;

public class PerformanceAspect {

    @Pointcut("within(kr.bluenyang.practice.aop.sec01.*)")
    public void pointcutMethod() {
    }

    @Around("pointcutMethod()")
    public Object trace(ProceedingJoinPoint pjp) throws Throwable {
        Signature signature = pjp.getSignature();
        String methodName = signature.getName();

        Object ret = null;

        System.out.println("===============================");
        System.out.println("[LOG] Before: " + methodName + " is start.");
        System.out.println("===============================");

        long start = System.nanoTime();
        try {
            ret = pjp.proceed();
        } catch (Exception e) {
            System.out.println(methodName + " is error.");
            throw e;
        }
        long end = System.nanoTime();
        System.out.println("===============================");
        System.out.println("[LOG] Before: " + methodName + " is end.");
        System.out.println("[LOG] After: " + methodName + " 경과 시간 : " + (end - start) + "ns");
        System.out.println("===============================");
        return ret;
    }
}
