package cn.noteblogs.mapper;

import cn.noteblogs.domain.Member;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberMapper {
    @Select("select * from member where id = #{orderId}")
    Member findById(String orderId);
}
