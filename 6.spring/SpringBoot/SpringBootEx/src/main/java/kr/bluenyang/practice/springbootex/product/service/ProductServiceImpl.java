package kr.bluenyang.practice.springbootex.product.service;

import kr.bluenyang.practice.springbootex.product.dao.ProductDAO;
import kr.bluenyang.practice.springbootex.product.model.ProductVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductDAO dao;

    @Override
    public List<ProductVO> getAllProduct() {
        log.info("getAllProduct");
        try {
            // VO List
            return dao.getAllProductList();
        } catch (Exception e) {
            log.error("getAllProduct failed: {}", e.getMessage());
            return null;
        }
    }

    @Override
    public List<ProductVO> findProductListByCtgId(String ctgId) {
        log.info("findProductListByCtgId({}) invoked.", ctgId);
        try {
            return dao.getProductListByCtgId(ctgId);
        } catch (Exception e) {
            log.error("findProductListByCtgId({}) failed: {}", ctgId, e.getMessage());
            return null;
        }
    }

    @Override
    public ProductVO findProductByPrdId(String prdId) {
        log.info("findProductByPrdId({}) invoked.", prdId);
        try {
            var prd = dao.getProductById(prdId);

            // null check
            if (prd == null) {
                log.warn("findProductByPrdId({}) is null", prdId);
                return null;
            }

            return prd;
        } catch (Exception e) {
            log.error("findProductByPrdId({}) failed: {}", prdId, e.getMessage());
            return null;
        }
    }
}
