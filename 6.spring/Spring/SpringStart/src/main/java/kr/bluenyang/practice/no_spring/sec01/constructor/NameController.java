package kr.bluenyang.practice.no_spring.sec01.constructor;

public class NameController {
    NameService nameService;

    public NameController(NameService nameService) {
        this.nameService = nameService;
    }

    public void show(String name) {
        System.out.println("NameController: " + nameService.showName(name));
    }
}
