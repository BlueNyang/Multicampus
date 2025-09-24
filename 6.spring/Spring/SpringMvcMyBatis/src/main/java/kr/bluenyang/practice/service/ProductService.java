package kr.bluenyang.practice.service;

import kr.bluenyang.practice.dao.IProductDAO;
import kr.bluenyang.practice.model.ProductVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@Repository
@RequiredArgsConstructor
public class ProductService implements IProductService {
    private final IProductDAO dao;

    @Override
    public List<ProductVO> listAllProduct() {
        List<ProductVO> prdList = dao.listAllProduct();
        return prdList != null ? prdList : Collections.emptyList();
    }

    @Override
    public ProductVO findProductByPrdNo(String prdNo) {
        return dao.findProductByPrdNo(prdNo);
    }

    @Override
    public void isertProduct(ProductVO productVO) {

    }

    @Override
    public void updateProduct(ProductVO productVO) {

    }

    @Override
    public void deleteProduct(String prdNo) {

    }
}
