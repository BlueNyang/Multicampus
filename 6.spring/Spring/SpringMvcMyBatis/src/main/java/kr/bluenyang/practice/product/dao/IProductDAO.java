package kr.bluenyang.practice.product.dao;

import kr.bluenyang.practice.product.model.ProductVO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface IProductDAO {
    List<ProductVO> listAllProduct();

    ProductVO findProductByPrdNo(String prdNo);

    void insertProduct(ProductVO productVO);

    void updateProduct(ProductVO productVO);

    void deleteProduct(String prdNo);

    ArrayList<ProductVO> searchProduct(Map<String, Object> map);
}
