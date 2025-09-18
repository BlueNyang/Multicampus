package kr.bluenyang.practice.no_spring.sec02_setter;

public class NameController {
    NameService nameService;

    public void setNameService(NameService nameService) {
        this.nameService = nameService;
    }

    public void show(String name) {
        System.out.println("NameController: " + nameService.showName(name));
    }
}
