package kr.bluenyang.practice.spring.sec03.annotation;

public class AnotherNameService implements INameService {
    @Override
    public String showName(String name) {
        System.out.println("AnotherNameService showName() method");
        return "Another my name is " + name;
    }
}
