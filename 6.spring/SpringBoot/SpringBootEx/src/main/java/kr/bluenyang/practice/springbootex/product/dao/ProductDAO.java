package kr.bluenyang.practice.springbootex.product.dao;

import kr.bluenyang.practice.springbootex.product.model.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Product DAO
 */
@Mapper
public interface ProductDAO {
    /**
     * Get all product list
     *
     * @return List of Product
     */
    List<Product> getAllProductList();

    /**
     * Get product list by category id
     *
     * @param ctgId category id
     * @return List of Product
     */
    List<Product> getProductListByCtgId(String ctgId);

    /**
     * Get product by product id
     *
     * @param productId product id
     * @return Product
     */
    Product getProductById(String productId);
}
