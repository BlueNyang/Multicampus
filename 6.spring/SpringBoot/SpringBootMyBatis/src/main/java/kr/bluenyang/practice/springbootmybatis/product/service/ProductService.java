package kr.bluenyang.practice.springbootmybatis.product.service;

import kr.bluenyang.practice.springbootmybatis.product.model.ProductVO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface ProductService {
    List<ProductVO> listAllProduct();

    ProductVO findProductByPrdNo(String prdNo);

    void insertProduct(ProductVO productVO);

    void updateProduct(ProductVO productVO);

    void deleteProduct(String prdNo);

    String prdNoCheck(String prdNo);

    ArrayList<ProductVO> searchProduct(Map<String, Object> condition);
}
