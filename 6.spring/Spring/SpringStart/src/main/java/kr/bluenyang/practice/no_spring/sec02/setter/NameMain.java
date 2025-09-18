package kr.bluenyang.practice.no_spring.sec02.setter;

public class NameMain {
    public static void main(String[] args) {
        NameService nameService = new NameService();
        NameController nameController = new NameController();
        nameController.setNameService(nameService);
        nameController.show("BlueNyang");
    }
}
