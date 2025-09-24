package kr.bluenyang.practice.sec02.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private String prdNo;
    private String prdName;
    private int prdPrice;
    private String prdMaker;
    private String prdColor;
    private int ctgNo;
}
