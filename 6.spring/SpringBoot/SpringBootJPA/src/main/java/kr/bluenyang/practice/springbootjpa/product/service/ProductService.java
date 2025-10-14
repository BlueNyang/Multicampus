package kr.bluenyang.practice.springbootjpa.product.service;

import kr.bluenyang.practice.springbootjpa.product.model.ProductDTO;

import java.util.List;
import java.util.Map;

public interface ProductService {
    List<ProductDTO> listAllProduct();

    ProductDTO findProductByPrdNo(String prdNo);

    void insertProduct(ProductDTO dto);

    void updateProduct(ProductDTO dto);

    void deleteProduct(String prdNo);

    String prdNoCheck(String prdNo);

    List<ProductDTO> searchProduct(Map<String, Object> condition);
}
