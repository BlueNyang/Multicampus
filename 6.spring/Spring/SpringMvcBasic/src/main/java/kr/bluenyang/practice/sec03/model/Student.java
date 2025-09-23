package kr.bluenyang.practice.sec03.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private String no;
    private String name;
    private int year;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;
}
