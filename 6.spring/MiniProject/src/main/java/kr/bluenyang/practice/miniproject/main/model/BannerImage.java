package kr.bluenyang.practice.miniproject.main.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="prj_banners")
public class BannerImage {
    @Id
    int id;
    String imageTitle;
    String imageUrl;
    String imageAlt;
    String linkUrl;
    int isActive;
    int sortOrder;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    Date createdAt;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    Date updatedAt;
}
