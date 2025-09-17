package kr.bluenyang.practice.no_spring.di1_constructor;

public class NameController {
    NameService nameService;

    public NameController(NameService nameService) {
        this.nameService = nameService;
    }

    public void show(String name) {
        System.out.println("NameController: " + nameService.showName(name));
    }
}
