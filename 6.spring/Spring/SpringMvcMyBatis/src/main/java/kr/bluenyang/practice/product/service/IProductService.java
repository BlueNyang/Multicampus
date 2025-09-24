package kr.bluenyang.practice.product.service;

import kr.bluenyang.practice.product.model.ProductVO;

import java.util.List;

public interface IProductService {
    List<ProductVO> listAllProduct();

    ProductVO findProductByPrdNo(String prdNo);

    void insertProduct(ProductVO productVO);

    void updateProduct(ProductVO productVO);

    void deleteProduct(String prdNo);
}
