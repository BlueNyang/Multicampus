package kr.bluenyang.practice.springbootjpa.product.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product2")
public class Product {
    @Id
    @Column(length = 10)
    private String prdNo;

    @Column(nullable = false, length = 30)
    private String prdName;

    @Column
    private int prdPrice;

    @Column(length = 30)
    private String prdCompany;

    @Column
    private int prdStock;

    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date prdDate;

    public static ProductDTO toDTO(Product product) {
        return ProductDTO.builder()
                .prdNo(product.getPrdNo())
                .prdName(product.getPrdName())
                .prdPrice(product.getPrdPrice())
                .prdCompany(product.getPrdCompany())
                .prdStock(product.getPrdStock())
                .prdDate(product.getPrdDate())
                .build();
    }
}
