package kr.bluenyang.practice.membercontrol.domain.product;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductDTO {
    private String prdNo;
    private String prdName;
    private int prdPrice;
    private String prdMaker;
    private String prdColor;
    private int ctgNo;

    public ProductDTO() {
    }

    public ProductDTO(String prdNo, String prdName, int prdPrice, String prdMaker, String prdColor, int ctgNo) {
        this.prdNo = prdNo;
        this.prdName = prdName;
        this.prdPrice = prdPrice;
        this.prdMaker = prdMaker;
        this.prdColor = prdColor;
        this.ctgNo = ctgNo;
    }

    public ProductDTO(String prdNo, String prdName, int prdPrice) {
    }

    public static ProductDTO fromEntity(Product product) {
        return new ProductDTO(
                product.getPrdNo(),
                product.getPrdName(),
                product.getPrdPrice(),
                product.getPrdMaker(),
                product.getPrdColor(),
                product.getCtgNo()
        );
    }

    public Product toEntity() {
        return new Product(
                this.getPrdNo(),
                this.getPrdName(),
                this.getPrdPrice(),
                this.getPrdMaker(),
                this.getPrdColor(),
                this.getCtgNo()
        );
    }
}
