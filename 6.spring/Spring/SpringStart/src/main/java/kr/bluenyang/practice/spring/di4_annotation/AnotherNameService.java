package kr.bluenyang.practice.spring.di4_annotation;

public class AnotherNameService implements INameService {
    @Override
    public String showName(String name) {
        System.out.println("AnotherNameService showName() method");
        return "Another my name is " + name;
    }
}
