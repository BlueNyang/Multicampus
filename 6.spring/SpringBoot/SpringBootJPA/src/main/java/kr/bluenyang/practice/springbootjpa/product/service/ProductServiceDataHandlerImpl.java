package kr.bluenyang.practice.springbootjpa.product.service;

import kr.bluenyang.practice.springbootjpa.product.dao.ProductDAO;
import kr.bluenyang.practice.springbootjpa.product.model.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceDataHandlerImpl implements ProductServiceDataHandler {
    private final ProductDAO dao;

    @Override
    public List<Product> listAllProduct() {
        log.info("listAllProduct - called");

        var list = dao.listAllProduct();

        if (list.isEmpty()) {
            log.info("listAllProduct - list is empty");
            return List.of();
        }

        return list;
    }

    @Override
    public Optional<Product> findProductByPrdNo(String prdNo) {
        log.info("findProductByPrdNo - called");

        return dao.findProductByPrdNo(prdNo);
    }

    @Override
    public void insertProduct(Product entity) {
        log.info("insertProduct - called");

        dao.insertProduct(entity);
    }

    @Override
    public void updateProduct(Product entity) {
        log.info("updateProduct - called");

        dao.updateProduct(entity);
    }

    @Override
    public void deleteProduct(String prdNo) {
        log.info("deleteProduct - called");

        dao.deleteProduct(prdNo);
    }

    @Override
    public List<Product> searchProduct(Map<String, Object> condition) {
        log.info("searchProduct - called");
        return dao.searchProduct(condition);
    }
}
