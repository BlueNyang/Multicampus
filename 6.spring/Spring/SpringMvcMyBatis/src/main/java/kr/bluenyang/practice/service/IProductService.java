package kr.bluenyang.practice.service;

import kr.bluenyang.practice.model.ProductVO;

import java.util.List;

public interface IProductService {
    List<ProductVO> listAllProduct();

    ProductVO findProductByPrdNo(String prdNo);

    void isertProduct(ProductVO productVO);

    void updateProduct(ProductVO productVO);

    void deleteProduct(String prdNo);
}
