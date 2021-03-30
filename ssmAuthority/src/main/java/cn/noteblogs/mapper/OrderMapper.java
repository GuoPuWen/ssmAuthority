package cn.noteblogs.mapper;

import cn.noteblogs.domain.Member;
import cn.noteblogs.domain.Order;
import cn.noteblogs.domain.Product;
import cn.noteblogs.domain.Traveller;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author FoFiten
 * @create 2021/2/14 17:41
 */
@Repository
public interface OrderMapper {

    @Select("select * from orders")
    @Results({
            @Result(property = "id", column = "id",id = true),
            @Result(property = "orderNum", column = "orderNum"),
            @Result(property = "orderTime", column = "orderTime"),
            @Result(property = "orderStatus", column = "orderStatus"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "payType", column = "payType"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "product", column = "productId", javaType = Product.class, one = @One(select = "cn.noteblogs.mapper.ProductMapper.findById"))

    })
    List<Order> findAll();

    @Select("select * from orders where id = #{orderId}")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "orderNum", column = "orderNum"),
            @Result(property = "orderTime", column = "orderTime"),
            @Result(property = "orderStatus", column = "orderStatus"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "payType", column = "payType"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "product", column = "productId", javaType = Product.class, one = @One(select = "cn.noteblogs.mapper.ProductMapper.findById")),
            @Result(property = "member", column = "memberId", javaType = Traveller.class, one = @One(select = "cn.noteblogs.mapper.MemberMapper.findById")),
            @Result(property = "travellers", column = "id", javaType = java.util.List.class, many = @Many(select = "cn.noteblogs.mapper.TravellerMapper.findByOrderId"))
    })
    Order findById(String orderId);
}
