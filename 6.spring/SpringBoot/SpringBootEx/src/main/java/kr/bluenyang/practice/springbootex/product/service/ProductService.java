package kr.bluenyang.practice.springbootex.product.service;

import kr.bluenyang.practice.springbootex.product.model.ProductDTO;

import java.util.List;

/**
 * Product Service
 */
public interface ProductService {
    /**
     * Get all product list
     *
     * @return List of ProductDTO
     */
    List<ProductDTO> getAllProduct();

    /**
     * Get product list by category id
     *
     * @param ctgId category id
     * @return List of ProductDTO
     */
    List<ProductDTO> findProductListByCtgId(String ctgId);

    /**
     * Get product by product id
     *
     * @param prdId product id
     * @return ProductDTO
     */
    ProductDTO findProductByPrdId(String prdId);
}
