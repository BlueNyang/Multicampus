package kr.bluenyang.practice.springbootex.product.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductDTO {
    private String prdNo;
    private String prdName;
    private int prdPrice;
    private String prdCompany;
    private int prdStock;
    private String prdDesc;
    private String prdImg;
    private String ctgId;

    public static ProductDTO fromEntity(Product product) {

        return new ProductDTO(
                product.getPrdNo(), product.getPrdName(), product.getPrdPrice().amount(),
                product.getPrdCompany(), product.getPrdStock(), product.getPrdDesc(),
                product.getPrdImg(), product.getCtgId()
        );
    }
}
