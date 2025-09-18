package kr.bluenyang.practice.spring.sec04_annotation_component;

import org.springframework.stereotype.Service;

@Service
public class NameService implements INameService {
    public String showName(String name) {
        System.out.println("NameService showName() method");
        return "my name is " + name;
    }
}
