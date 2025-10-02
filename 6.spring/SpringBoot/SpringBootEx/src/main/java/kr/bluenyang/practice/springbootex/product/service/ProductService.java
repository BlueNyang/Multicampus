package kr.bluenyang.practice.springbootex.product.service;

import kr.bluenyang.practice.springbootex.product.model.ProductVO;

import java.util.HashMap;
import java.util.List;

public interface ProductService {
    // 구현 클래스에서 오버라이딩할 추상 메소드
    // 규격지정
    List<ProductVO> listAllProduct(); // 전체 상품 조회

    List<ProductVO> ctgListProduct(String ctgId); // 카테고리별 상품 조회

    void insertProduct(ProductVO vo);       // 상품 정보 등록

    void updateProduct(ProductVO prdVo);   // 상품 정보 수정

    void deleteProduct(String prdNo);      // 상품 정보 삭제

    ProductVO detailViewProduct(String prdNo);// 상세 상품 조회

    String prdNoCheck(String prdNo); // 상품번호 중복확인

    List<ProductVO> productSearch(HashMap<String, Object> map); // 상품검색
}
