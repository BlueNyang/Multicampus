package kr.bluenyang.practice.springbootmybatis.product.dao;

import kr.bluenyang.practice.springbootmybatis.product.model.ProductVO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ProductDAO {
    List<ProductVO> listAllProduct();

    Optional<ProductVO> findProductByPrdNo(String prdNo);

    void insertProduct(ProductVO productVO);

    void updateProduct(ProductVO productVO);

    void deleteProduct(String prdNo);

    ArrayList<ProductVO> searchProduct(Map<String, Object> map);
}
