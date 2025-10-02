package kr.bluenyang.practice.springbootex.product.service;

import kr.bluenyang.practice.springbootex.product.model.ProductDTO;

import java.util.List;

public interface ProductService {
    List<ProductDTO> inquireAllProduct();

    List<ProductDTO> findProductListByCtgId(String ctgId);

    ProductDTO findProductByPrdId(String prdId);
}
