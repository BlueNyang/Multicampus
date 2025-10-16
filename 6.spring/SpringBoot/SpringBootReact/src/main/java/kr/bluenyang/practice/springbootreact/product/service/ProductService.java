package kr.bluenyang.practice.springbootreact.product.service;

import kr.bluenyang.practice.springbootreact.product.model.ProductDTO;
import kr.bluenyang.practice.springbootreact.product.model.ProductSearchDTO;

import java.util.List;
import java.util.Map;

public interface ProductService {
    List<ProductDTO> listAllProduct();

    ProductDTO findProductByPrdNo(String prdNo);

    String insertProduct(ProductDTO dto);

    void updateProduct(ProductDTO dto);

    void deleteProduct(String prdNo);

    List<ProductDTO> searchProduct(ProductSearchDTO dto);
}
