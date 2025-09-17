package kr.bluenyang.practice.no_spring.di3_no_di;

public class NameService {
    public String showName(String name) {
        System.out.println("NameService showName() method");
        return "my name is " + name;
    }
}
