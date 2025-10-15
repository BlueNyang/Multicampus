package kr.bluenyang.practice.springbootreact.product.repository;

import kr.bluenyang.practice.springbootreact.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

//@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    @Query("""
            SELECT p
              FROM Product p
              WHERE (:type = 'prdName' AND p.prdName LIKE concat('%', :keyword, '%'))
                 OR (:type = 'prdCompany'AND p.prdCompany LIKE concat('%',:keyword,'%'))
            """)
    List<Product> searchProduct(@Param("type") String type,
                                @Param("keyword") String keyword);
}
