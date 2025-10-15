package kr.bluenyang.practice.springbootreact.product.service;

import kr.bluenyang.practice.springbootreact.product.model.Product;
import kr.bluenyang.practice.springbootreact.product.model.ProductDTO;
import kr.bluenyang.practice.springbootreact.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository repo;

    @Override
    public List<ProductDTO> listAllProduct() {
        log.info("listAllProduct - called");

        var prdList = repo.findAll();

        if (prdList.isEmpty()) {
            log.info("listAllProduct - list is empty");
            return Collections.emptyList();
        }

        log.info("listAllProduct - products found: {}", prdList.size());
        return prdList.stream()
                .map(Product::toDTO)
                .toList();
    }

    @Override
    public ProductDTO findProductByPrdNo(String prdNo) {
        log.info("findProductByPrdNo - called");
        var entity = repo.findById(prdNo);
        return entity.map(Product::toDTO).orElse(null);

    }

    @Override
    public void insertProduct(ProductDTO dto) {
        log.info("insertProduct - called");
        repo.save(ProductDTO.toEntity(dto));

    }

    @Override
    public void updateProduct(ProductDTO dto) {
        log.info("updateProduct - called");
        repo.save(ProductDTO.toEntity(dto));
    }

    @Override
    public void deleteProduct(String prdNo) {
        log.info("deleteProduct - called");
        repo.deleteById(prdNo);
    }

    @Override
    public String prdNoCheck(String prdNo) {
        log.info("prdNoCheck - called");
        var check = repo.findById(prdNo);
        return check.map(Product::getPrdNo).orElse(null);
    }

    @Override
    public List<ProductDTO> searchProduct(Map<String, Object> condition) {
        log.info("searchProduct - called");
        var list = repo.searchProduct(
                condition.get("type").toString(),
                condition.get("keyword").toString()
        );
        if (list.isEmpty()) {
            return Collections.emptyList();
        }

        return list.stream()
                .map(Product::toDTO)
                .toList();
    }
}
