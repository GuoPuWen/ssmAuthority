package cn.noteblogs.service.Impl;

import cn.noteblogs.domain.Order;
import cn.noteblogs.mapper.OrderMapper;
import cn.noteblogs.service.IOrderService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("orderService")
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private OrderMapper orderMapper;

    public List<Order> findAll() {
        List<Order> list = orderMapper.findAll();
        System.out.println(list);
        return list;
    }

    public Order findById(String orderId) {
        Order order = orderMapper.findById(orderId);
        System.out.println(order);
        return order;
    }

    public List<Order> findAllByPage(Integer page, Integer size) {
        PageHelper.startPage(page, size);
        List<Order> list = orderMapper.findAll();
        return list;
    }
}
