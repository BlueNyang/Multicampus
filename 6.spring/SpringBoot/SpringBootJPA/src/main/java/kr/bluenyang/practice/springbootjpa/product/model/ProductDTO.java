package kr.bluenyang.practice.springbootjpa.product.model;

import lombok.Builder;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


// @Data
@Getter
// @Setter
// @NoArgsConstructor
// @AllArgsConstructor
@Builder
public class ProductDTO {
    private String prdNo;
    private String prdName;
    private int prdPrice;
    private String prdCompany;
    private int prdStock;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date prdDate;

    static public Product toEntity(ProductDTO dto) {
        return Product.builder()
                .prdNo(dto.getPrdNo())
                .prdName(dto.getPrdName())
                .prdPrice(dto.getPrdPrice())
                .prdCompany(dto.getPrdCompany())
                .prdStock(dto.getPrdStock())
                .prdDate(dto.getPrdDate())
                .build();
    }
}
