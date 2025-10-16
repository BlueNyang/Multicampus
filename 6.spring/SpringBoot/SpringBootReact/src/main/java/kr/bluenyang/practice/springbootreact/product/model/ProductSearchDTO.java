package kr.bluenyang.practice.springbootreact.product.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductSearchDTO {
    private String type;
    private String keyword;
}
