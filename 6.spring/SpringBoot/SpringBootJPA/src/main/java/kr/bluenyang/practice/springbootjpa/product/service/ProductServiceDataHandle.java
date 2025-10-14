package kr.bluenyang.practice.springbootjpa.product.service;

import kr.bluenyang.practice.springbootjpa.product.model.Product;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ProductServiceDataHandle {
    List<Product> listAllProduct();

    Optional<Product> findProductByPrdNo(String prdNo);

    void insertProduct(Product entity);

    void updateProduct(Product entity);

    void deleteProduct(String prdNo);

    List<Product> searchProduct(Map<String, Object> condition);
}
