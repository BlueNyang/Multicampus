package kr.bluenyang.practice.product.service;

import kr.bluenyang.practice.product.dao.IProductDAO;
import kr.bluenyang.practice.product.model.ProductVO;
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
    public void insertProduct(ProductVO productVO) {
        dao.insertProduct(productVO);
    }

    @Override
    public void updateProduct(ProductVO productVO) {
        dao.updateProduct(productVO);
    }

    @Override
    public void deleteProduct(String prdNo) {
        dao.deleteProduct(prdNo);
    }

    @Override
    public String prdNoCheck(String prdNo) {
        ProductVO check = dao.findProductByPrdNo(prdNo);
        if (check != null) {
            return check.getPrdNo();
        }
        return null;
    }
}
