package kr.bluenyang.practice.springbootex.product.dao;

import kr.bluenyang.practice.springbootex.product.model.ProductVO;
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
    List<ProductVO> getAllProductList();

    /**
     * Get product list by category id
     *
     * @param ctgId category id
     * @return List of Product
     */
    List<ProductVO> getProductListByCtgId(String ctgId);

    /**
     * Get product by product id
     *
     * @param productId product id
     * @return Product
     */
    ProductVO getProductById(String productId);
}
