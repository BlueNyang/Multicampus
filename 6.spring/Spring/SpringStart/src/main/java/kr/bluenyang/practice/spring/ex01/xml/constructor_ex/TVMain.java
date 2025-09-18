package kr.bluenyang.practice.spring.ex01.xml.constructor_ex;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVMain {
    public static void main(String[] args) {
        AbstractApplicationContext context = new GenericXmlApplicationContext("spring/context/application-context-ex01.xml");

        TV tv = (TV) context.getBean("tv");
        tv.volumeUp();
        tv.volumeDown();

        context.close();
    }
}
