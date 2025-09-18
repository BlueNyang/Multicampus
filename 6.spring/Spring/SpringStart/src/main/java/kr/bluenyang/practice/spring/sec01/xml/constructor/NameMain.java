package kr.bluenyang.practice.spring.sec01.xml.constructor;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class NameMain {
    public static void main(String[] args) {
        // NameService nameService = new NameService();
        // NameController Class 입장에서는 Constructor Injection을 통해 NameService를 주입받음
        // Spring Container Object 생성
        AbstractApplicationContext ctx = new GenericXmlApplicationContext("spring/context/application-context-sec01.xml");
//        NameController nameController = new NameController(nameService);
        NameController nameController = ctx.getBean("nameController", NameController.class);
        nameController.show("BlueNyang");
    }
}
