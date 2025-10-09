package kr.bluenyang.practice.springbootjpa.product.repository;

import kr.bluenyang.practice.springbootjpa.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

//@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    @Query("""
            SELECT p
            FROM Product p
            WHERE (:type='prdName' AND p.prdName LIKE CONCAT('%', :keyword, '%'))
                 OR (:type='prdCompany' AND p.prdCompany LIKE CONCAT('%', :keyword, '%'))
            """)
    List<Product> searchProducts(@Param("type") String type,
                                 @Param("keyword") String keyword);
}
