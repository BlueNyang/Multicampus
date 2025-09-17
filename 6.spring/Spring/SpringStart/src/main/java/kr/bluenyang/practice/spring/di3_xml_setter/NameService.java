package kr.bluenyang.practice.spring.di3_xml_setter;

public class NameService {
    public String showName(String name) {
        System.out.println("NameService showName() method");
        return "my name is " + name;
    }
}
