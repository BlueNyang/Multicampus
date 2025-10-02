package kr.bluenyang.practice.springbootex.product.dao;

import kr.bluenyang.practice.springbootex.product.model.Product;

import java.util.List;

public interface ProductDAO {
    List<Product> getAllProductList();

    List<Product> getProductListByCtgId(String ctgId);

    Product getProductById(String productId);
}
