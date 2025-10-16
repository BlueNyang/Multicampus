package kr.bluenyang.practice.springbootmybatis.product.service;

import kr.bluenyang.practice.springbootmybatis.product.dao.ProductDAO;
import kr.bluenyang.practice.springbootmybatis.product.model.ProductVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
@Repository
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductDAO dao;

    @Override
    public List<ProductVO> listAllProduct() {
        List<ProductVO> prdList = dao.listAllProduct();
        return prdList != null ? prdList : Collections.emptyList();
    }

    @Override
    public ProductVO findProductByPrdNo(String prdNo) {
        var product = dao.findProductByPrdNo(prdNo);

        return product.orElse(null);

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
        var check = dao.findProductByPrdNo(prdNo);
        if (check.isPresent()) {
            return "unavailable";
        }
        return "available";
    }

    @Override
    public ArrayList<ProductVO> searchProduct(Map<String, Object> condition) {
        log.info("searchProduct");
        return dao.searchProduct(condition);
    }
}
