package kr.bluenyang.practice.no_spring.di2_setter;

public class NameMain {
    public static void main(String[] args) {
        NameService nameService = new NameService();
        NameController nameController = new NameController();
        nameController.setNameService(nameService);
        nameController.show("BlueNyang");
    }
}
