package kr.bluenyang.practice.aop.sec02;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Run {
    public static void main(String[] args) {
        AbstractApplicationContext ctx = new GenericXmlApplicationContext("spring/aop/application-config-aop02.xml");

        Evaluation evaluation = ctx.getBean("evaluation", Evaluation.class);
        evaluation.showScores();

        Circle circle = ctx.getBean("circle", Circle.class);
        circle.showResult();

        ctx.close();
    }
}
