package kr.bluenyang.practice.spring.sec04_annotation_component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NameController {
    INameService nameService;

    @Autowired
    public void setNameService(INameService nameService) {
        this.nameService = nameService;
    }

    public void show(String name) {
        System.out.println("NameController: " + nameService.showName(name));
    }
}
