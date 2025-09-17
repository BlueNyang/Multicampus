package kr.bluenyang.practice.no_spring.di2_setter;

public class NameService {
    public String showName(String name) {
        System.out.println("NameService showName() method");
        return "my name is " + name;
    }
}
