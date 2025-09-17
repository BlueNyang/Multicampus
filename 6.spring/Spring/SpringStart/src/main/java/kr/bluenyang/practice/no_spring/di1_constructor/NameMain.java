package kr.bluenyang.practice.no_spring.di1_constructor;

public class NameMain {
    public static void main(String[] args) {
        NameService nameService = new NameService();
        NameController nameController = new NameController(nameService);
        nameController.show("BlueNyang");
    }
}
