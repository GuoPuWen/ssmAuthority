package cn.noteblogs.mapper;

import cn.noteblogs.domain.SysLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author FoFiten
 * @create 2021/3/13 23:29
 */
@Repository("sysLogMapper")
public interface SysLogMapper {
    @Insert("insert into syslog values(#{p.id},#{p.visitTime},#{p.username},#{p.ip},#{p.url},#{p.executionTime},#{p.method})")
    void save(@Param("p") SysLog sysLog);

    @Select("select * from syslog")
    List<SysLog> findAll();
}
