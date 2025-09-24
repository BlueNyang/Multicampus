package kr.bluenyang.practice.sec01.service;

import kr.bluenyang.practice.sec01.model.ProductVO;

import java.util.List;

public interface IProductService {
    List<ProductVO> listAllProduct();

    ProductVO findProductByPrdNo(String prdNo);

    void isertProduct(ProductVO productVO);

    void updateProduct(ProductVO productVO);

    void deleteProduct(String prdNo);
}
