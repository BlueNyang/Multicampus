package kr.bluenyang.practice.no_spring.sec03_no_di;

public class NameMain {
    public static void main(String[] args) {
        NameController nameController = new NameController();
        nameController.show("BlueNyang");
    }
}
