package kr.bluenyang.practice.miniproject.main.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BannerImageDTO {
    private String imageUrl;
    private String imageTitle;
    private String imageAlt;
    private String linkUrl;

    public static BannerImageDTO fromEntity(BannerImage entity) {
        return BannerImageDTO.builder()
                .imageUrl(entity.getImageUrl())
                .imageTitle(entity.getImageTitle())
                .imageAlt(entity.getImageAlt())
                .linkUrl(entity.getLinkUrl())
                .build();
    }
}
