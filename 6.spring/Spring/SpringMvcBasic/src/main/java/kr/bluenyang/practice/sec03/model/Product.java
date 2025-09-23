package kr.bluenyang.practice.sec03.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    String prdNo;
    String prdName;
    int prdPrice;
    String prdCompany;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate prdDate;
    int prdStock;
}
