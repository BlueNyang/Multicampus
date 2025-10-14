package kr.bluenyang.practice.springbootjpa.product.dao;

import kr.bluenyang.practice.springbootjpa.product.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ProductDAO {
    List<Product> listAllProduct();

    Optional<Product> findProductByPrdNo(String prdNo);

    void insertProduct(Product productVO);

    void updateProduct(Product productVO);

    void deleteProduct(String prdNo);

    List<Product> searchProduct(Map<String, Object> map);
}
