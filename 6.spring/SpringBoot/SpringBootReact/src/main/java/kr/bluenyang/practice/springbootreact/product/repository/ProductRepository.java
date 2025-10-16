package kr.bluenyang.practice.springbootreact.product.repository;

import kr.bluenyang.practice.springbootreact.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

//@Repository
public interface ProductRepository extends JpaRepository<Product, String>, JpaSpecificationExecutor<Product> {
    @Query("""
            SELECT p
              FROM Product p
              WHERE (:type = 'prdName' AND p.prdName LIKE concat('%', :keyword, '%'))
                 OR (:type = 'prdCompany'AND p.prdCompany LIKE concat('%',:keyword,'%'))
              ORDER BY p.prdNo
            """)
    List<Product> searchProduct(@Param("type") String type,
                                @Param("keyword") String keyword);
}
