package kr.bluenyang.practice.spring.di2_xml_constructor_ex;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVMain {
    public static void main(String[] args) {
        AbstractApplicationContext context = new GenericXmlApplicationContext("application-context1_1.xml");

        TV tv = (TV) context.getBean("tv");
        tv.volumeUp();
        tv.volumeDown();

        context.close();
    }
}
