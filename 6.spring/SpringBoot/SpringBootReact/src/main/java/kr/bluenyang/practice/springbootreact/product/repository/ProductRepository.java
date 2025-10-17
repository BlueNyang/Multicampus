package kr.bluenyang.practice.springbootreact.product.repository;

import kr.bluenyang.practice.springbootreact.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

//@Repository
public interface ProductRepository extends JpaRepository<Product, String>, JpaSpecificationExecutor<Product> {
}
