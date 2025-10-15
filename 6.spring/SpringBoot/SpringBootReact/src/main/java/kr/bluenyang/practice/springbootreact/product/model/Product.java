package kr.bluenyang.practice.springbootreact.product.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product2")
public class Product {
    @Id
    private String prdNo;
    private String prdName;
    private int prdPrice;
    private String prdCompany;
    private int prdStock;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date prdDate;

    public static ProductDTO toDTO(Product entity) {
        return ProductDTO.builder()
                .prdNo(entity.getPrdNo())
                .prdName(entity.getPrdName())
                .prdPrice(entity.getPrdPrice())
                .prdCompany(entity.getPrdCompany())
                .prdStock(entity.getPrdStock())
                .prdDate(entity.getPrdDate())
                .build();
    }
}
