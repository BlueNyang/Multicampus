package kr.bluenyang.practice.spring.sec02.xml.setter;

public class NameController {
    NameService nameService;

    public void setNameService(NameService nameService) {
        this.nameService = nameService;
    }

    public void show(String name) {
        System.out.println("NameController: " + nameService.showName(name));
    }
}
