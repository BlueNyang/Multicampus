package kr.bluenyang.practice.springbootreact.product.model;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private String prdNo;
    private String prdName;
    private int prdPrice;
    private String prdCompany;
    private int prdStock;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date prdDate;

    public static Product toEntity(ProductDTO dto) {
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
