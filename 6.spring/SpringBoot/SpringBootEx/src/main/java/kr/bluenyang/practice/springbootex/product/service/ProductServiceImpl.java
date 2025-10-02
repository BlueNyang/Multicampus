package kr.bluenyang.practice.springbootex.product.service;

import kr.bluenyang.practice.springbootex.product.dao.ProductDAO;
import kr.bluenyang.practice.springbootex.product.model.ProductVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductDAO dao;

    @Override
    public String prdNoCheck(String prdNo) {
        return dao.prdNoCheck(prdNo);
    }


    @Override
    public ArrayList<ProductVO> productSearch(HashMap<String, Object> map) {
        return dao.productSearch(map);
    }


    @Override
    public ArrayList<ProductVO> listAllProduct() {
        return dao.listAllProduct();
    }

    @Override
    public void insertProduct(ProductVO vo) {
        dao.insertProduct(vo);
    }

    @Override
    public void updateProduct(ProductVO prdVo) {
        dao.updateProduct(prdVo);
    }

    @Override
    public void deleteProduct(String prdNo) {
        dao.deleteProduct(prdNo);
    }

    @Override
    public ProductVO detailViewProduct(String prdNo) {

        return dao.detailViewProduct(prdNo);
    }

}
