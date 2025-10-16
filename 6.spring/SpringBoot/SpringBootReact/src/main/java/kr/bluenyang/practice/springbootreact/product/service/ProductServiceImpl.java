package kr.bluenyang.practice.springbootreact.product.service;

import kr.bluenyang.practice.springbootreact.product.model.Product;
import kr.bluenyang.practice.springbootreact.product.model.ProductDTO;
import kr.bluenyang.practice.springbootreact.product.model.ProductSearchDTO;
import kr.bluenyang.practice.springbootreact.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository repo;

    @Override
    public List<ProductDTO> listAllProduct() {
        log.info("listAllProduct - called");

        var prdList = repo.findAll(Sort.by("prdNo"));

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
        log.info("findProductByPrdNo - entity found: {}", entity.isPresent());

        return entity.map(Product::toDTO).orElse(null);

    }

    @Override
    public String insertProduct(ProductDTO dto) {
        log.info("insertProduct - called");

        if (repo.existsById(dto.getPrdNo())) {
            log.info("insertProduct - product already exists");
            return "exists";
        }

        repo.save(ProductDTO.toEntity(dto));
        log.info("insertProduct - product inserted");

        return "success";
    }

    @Override
    public void updateProduct(ProductDTO dto) {
        log.info("updateProduct - called");
        repo.save(ProductDTO.toEntity(dto));
        log.info("updateProduct - product updated");
    }

    @Override
    public void deleteProduct(String prdNo) {
        log.info("deleteProduct - called");
        repo.deleteById(prdNo);
        log.info("deleteProduct - product deleted");
    }

    @Override
    public List<ProductDTO> searchProduct(ProductSearchDTO dto) {
        log.info("searchProduct - called");

        log.info("searchProduct - condition: type={}, keyword={}", dto.getType(), dto.getKeyword());

        var keyword = "%" + dto.getKeyword() + "%";
        var list = repo.findAll(
                (root, query, criteriaBuilder)
                        -> criteriaBuilder.like(root.get(dto.getType()), keyword)
        );

        if (list.isEmpty()) {
            log.info("searchProduct - No products found");
            return Collections.emptyList();
        }

        log.info("searchProduct - products found: {}", list.size());
        return list.stream()
                .map(Product::toDTO)
                .toList();
    }
}
