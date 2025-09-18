package kr.bluenyang.practice.spring.sec04.annotation.cpnt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NameController {
    @Autowired
    INameService nameService;

    // public void setNameService(NameService nameService) {
    //     this.nameService = nameService;
    // }

    public void show(String name) {
        System.out.println("NameController: " + nameService.showName(name));
    }
}
