package kr.bluenyang.practice.springbootex.product.dao;

import kr.bluenyang.practice.springbootex.product.model.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductDAO {
    List<Product> getAllProductList();

    List<Product> getProductListByCtgId(String ctgId);

    Product getProductById(String productId);
}
