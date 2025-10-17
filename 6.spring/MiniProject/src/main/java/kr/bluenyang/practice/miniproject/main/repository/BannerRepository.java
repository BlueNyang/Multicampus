package kr.bluenyang.practice.miniproject.main.repository;

import kr.bluenyang.practice.miniproject.main.model.BannerImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BannerRepository extends JpaRepository<BannerImage, Integer>, JpaSpecificationExecutor<BannerImage> {
    List<BannerImage> findByIsActiveOrderBySortOrderAsc(int isActive);
}
