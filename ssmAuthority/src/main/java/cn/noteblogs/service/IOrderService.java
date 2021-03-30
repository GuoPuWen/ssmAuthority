package cn.noteblogs.service;

import cn.noteblogs.domain.Order;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.List;

public interface IOrderService {
    public List<Order> findAll();
    public Order findById(String orderId);

    List<Order> findAllByPage(Integer page, Integer size);
}
