package kr.bluenyang.practice.spring.sec03_annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class NameController {
    INameService nameService;

    @Autowired
    @Qualifier("anotherNameService")
    public void setNameService(INameService nameService) {
        this.nameService = nameService;
    }

    public void show(String name) {
        System.out.println("NameController: " + nameService.showName(name));
    }
}
