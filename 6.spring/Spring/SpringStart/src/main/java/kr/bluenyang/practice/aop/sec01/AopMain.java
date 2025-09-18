package kr.bluenyang.practice.aop.sec01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AopMain {
    public static void main(String[] args) {
        AbstractApplicationContext ctx = new GenericXmlApplicationContext("spring/aop/application-config-aop01.xml");

        Rect rect = ctx.getBean("rect", Rect.class);
        rect.showRectResult();

        Gugudan gugudan = ctx.getBean("gugudan", Gugudan.class);
        gugudan.showResult();

        ctx.close();
    }
}
