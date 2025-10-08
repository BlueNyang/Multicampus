package kr.bluenyang.practice.springbootex.order.dao;

import kr.bluenyang.practice.springbootex.order.model.OrderInfoVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface OrderDAO {
    void insertOrderInfo(OrderInfoVO vo);

    void insertOrderProduct(Map<String, Object> map);
}
