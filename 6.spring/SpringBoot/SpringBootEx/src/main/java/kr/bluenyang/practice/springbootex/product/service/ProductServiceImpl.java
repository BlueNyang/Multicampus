package kr.bluenyang.practice.springbootex.product.service;

import kr.bluenyang.practice.springbootex.product.dao.ProductDAO;
import kr.bluenyang.practice.springbootex.product.model.ProductDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    ProductDAO dao;

    @Override
    public List<ProductDTO> inquireAllProduct() {
        log.info("inquireAllProduct");
        try {
            var list = dao.getAllProductList();
            return list.stream().map(ProductDTO::fromEntity).toList();
        } catch (Exception e) {
            log.error("inquireAllProduct failed: {}", e.getMessage());
            return null;
        }
    }

    @Override
    public List<ProductDTO> findProductListByCtgId(String ctgId) {
        log.info("findProductListByCtgId({}) invoked.", ctgId);
        try {
            var list = dao.getProductListByCtgId(ctgId);
            return list.stream().map(ProductDTO::fromEntity).toList();
        } catch (Exception e) {
            log.error("findProductListByCtgId({}) failed: {}", ctgId, e.getMessage());
            return null;
        }
    }

    @Override
    public ProductDTO findProductByPrdId(String prdId) {
        log.info("findProductByPrdId({}) invoked.", prdId);
        try {
            var prd = dao.getProductById(prdId);

            if (prd == null) {
                log.warn("findProductByPrdId({}) is null", prdId);
                return null;
            }

            return ProductDTO.fromEntity(prd);
        } catch (Exception e) {
            log.error("findProductByPrdId({}) failed: {}", prdId, e.getMessage());
            return null;
        }
    }
}
