package kr.bluenyang.practice.no_spring.di3_no_di;

public class NameController {
    NameService nameService = new NameService();

    public void show(String name) {
        System.out.println("NameController: " + nameService.showName(name));
    }
}
