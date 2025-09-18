package kr.bluenyang.practice.spring.sec02_xml_setter;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class NameMain {
    public static void main(String[] args) {

        AbstractApplicationContext ctx = new GenericXmlApplicationContext("application-context-ex01.xml");
        NameController control = ctx.getBean("nameController", NameController.class);
        control.show("BlueNyang");
    }
}
