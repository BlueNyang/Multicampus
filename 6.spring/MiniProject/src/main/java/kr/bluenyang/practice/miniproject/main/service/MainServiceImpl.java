package kr.bluenyang.practice.miniproject.main.service;

import kr.bluenyang.practice.miniproject.main.model.BannerImageDTO;
import kr.bluenyang.practice.miniproject.main.repository.BannerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MainServiceImpl implements MainService {
    private final BannerRepository repo;

    @Override
    public List<BannerImageDTO> getBannerImages() {
        var list = repo.findByIsActiveOrderBySortOrderAsc(1);

        return list.stream()
                .map(BannerImageDTO::fromEntity)
                .toList();
    }
}
