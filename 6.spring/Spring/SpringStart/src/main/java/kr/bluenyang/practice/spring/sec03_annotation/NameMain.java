package kr.bluenyang.practice.spring.sec03_annotation;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class NameMain {
    public static void main(String[] args) {
        AbstractApplicationContext ctx = new GenericXmlApplicationContext("application-config-sec03.xml");

        NameController control = ctx.getBean("nameController", NameController.class);
        control.show("BlueNyang");
    }
}
