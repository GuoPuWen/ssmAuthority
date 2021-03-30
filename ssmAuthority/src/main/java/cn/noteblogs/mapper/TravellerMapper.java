package cn.noteblogs.mapper;

import cn.noteblogs.domain.Traveller;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TravellerMapper {

    @Select("select * from traveller where id = #{id}")
    Traveller findById(String id);

    @Select("select * from traveller where id in (select travellerId from order_traveller where OrderId = #{OrderId})")
    List<Traveller> findByOrderId(String OrderId);
}
