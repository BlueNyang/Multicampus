package kr.bluenyang.practice.spring.sec01.xml.constructor;

public class NameController {
    NameService nameService;

    public NameController(NameService nameService) {
        this.nameService = nameService;
    }

    public void show(String name) {
        System.out.println("NameController: " + nameService.showName(name));
    }
}
