package kr.bluenyang.practice.sec01.dao;

import kr.bluenyang.practice.sec01.model.ProductVO;

import java.util.ArrayList;

public interface IProductDAO {
    ArrayList<ProductVO> listAllProduct();

    ProductVO findProductByPrdNo(String prdNo);

    void insertProduct(ProductVO productVO);

    void updateProduct(ProductVO productVO);

    void deleteProduct(String prdNo);

}
