package kr.bluenyang.practice.spring.di3_xml_setter;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class NameMain {
    public static void main(String[] args) {

        AbstractApplicationContext ctx = new GenericXmlApplicationContext("application-context2.xml");
        NameController control = ctx.getBean("nameController", NameController.class);
        control.show("BlueNyang");
    }
}
