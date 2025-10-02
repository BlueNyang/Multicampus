package kr.bluenyang.practice.springbootex.product.model;

import kr.bluenyang.practice.springbootex.product.vo.Money;

public record ProductDTO(String prdNo, String prdName, Money prdPrice, String prdCompany,
                         int stock, String prdDesc, String prdImg, String ctgId) {
    public static ProductDTO fromEntity(Product product) {
        return new ProductDTO(
                product.getPrdNo(), product.getPrdName(), product.getPrdPrice(), product.getPrdCompany(),
                product.getStock(), product.getPrdDesc(), product.getPrdImg(), product.getCtgId()
        );
    }
}
