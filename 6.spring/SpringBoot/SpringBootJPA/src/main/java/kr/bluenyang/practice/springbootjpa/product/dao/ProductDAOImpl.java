package kr.bluenyang.practice.springbootjpa.product.dao;

import kr.bluenyang.practice.springbootjpa.product.model.Product;
import kr.bluenyang.practice.springbootjpa.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
@Component
@RequiredArgsConstructor
public class ProductDAOImpl implements ProductDAO {
    private final ProductRepository repository;

    @Override
    public List<Product> listAllProduct() {
        log.info("listAllProduct - called");
        return repository.findAll();
    }

    @Override
    public Optional<Product> findProductByPrdNo(String prdNo) {
        log.info("findProductByPrdNo - called");

        return repository.findById(prdNo);
    }

    @Override
    public void insertProduct(Product entity) {
        log.info("insertProduct - called");

        repository.save(entity);
    }

    @Override
    public void updateProduct(Product entity) {
        log.info("updateProduct - called");

        repository.save(entity);
    }

    @Override
    public void deleteProduct(String prdNo) {
        log.info("deleteProduct - called");

        repository.deleteById(prdNo);
    }

    @Override
    public List<Product> searchProduct(Map<String, Object> map) {
        log.info("searchProduct - called");
        String type = (String) map.get("type");
        String keyword = (String) map.get("keyword");

        log.info("type: {}, keyword: {}", type, keyword);
        return repository.searchProducts(type, keyword);
    }
}
