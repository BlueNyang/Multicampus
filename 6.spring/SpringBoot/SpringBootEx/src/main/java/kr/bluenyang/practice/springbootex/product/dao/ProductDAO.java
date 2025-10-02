package kr.bluenyang.practice.springbootex.product.dao;

import java.util.ArrayList;
import java.util.HashMap;

import kr.bluenyang.practice.springbootex.product.model.ProductVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductDAO {
    ArrayList<ProductVO> listAllProduct(); // 전체 상품 조회

    void insertProduct(ProductVO vo);       // 상품 정보 등록

    void updateProduct(ProductVO prdVo);   // 상품 정보 수정

    void deleteProduct(String prdNo);      // 상품 정보 삭제

    ProductVO detailViewProduct(String prdNo);// 상세 상품 조회

    String prdNoCheck(String prdNo);// 상품번호 중복 확인

    ArrayList<ProductVO> productSearch(HashMap<String, Object> map);// 상품검색
}
