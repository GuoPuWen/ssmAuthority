package cn.noteblogs.mapper;

import cn.noteblogs.domain.Permission;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PermissionMapper {
    @Select("select * from permission where id in(select permissionId from role_permission where roleId=#{roleId})")
    public List<Permission> findPermissionByRoleId(String roleId);


    @Select("select * from permission")
    public List<Permission> findAll();

    @Insert("insert into permission(id,permissionName,url) values(#{id},#{permissionName},#{url})")
    public void save(Permission permission);

    @Delete("delete from permission where id =#{id}")
    void delete(String id);

    @Select("select * from permission where id=#{id}")
    Permission findById(String id);
}
