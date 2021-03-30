package cn.noteblogs.mapper;

import cn.noteblogs.domain.Permission;
import cn.noteblogs.domain.Role;
import cn.noteblogs.domain.UserInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.security.core.parameters.P;

import java.util.List;

public interface RoleMapper {

    //通过userid查询所有的Role
    @Select("select * from role where id in(select roleId from users_role where userId=#{userId})")
    @Results({
            @Result(id=true,column = "id"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "roleDesc",column = "roleDesc"),
            @Result(property = "permissions",column = "id",javaType = java.util.List.class,many = @Many(select = "cn.noteblogs.mapper.PermissionMapper.findPermissionByRoleId")),
    })
    List<Role> findRoleByUserId(String userId);

    @Select("select * from role")
    List<Role> findAll();

    //通过roleId查询role的相关属性
    @Select("select * from role where id =#{roleId}")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "permissions",column = "id",javaType = java.util.List.class,many = @Many(select = "cn.noteblogs.mapper.PermissionMapper.findPermissionByRoleId"))
    })
    Role findById(String roleId);

    //插入信息
    @Insert("insert into role(id,roleName,roleDesc) values(#{id},#{roleName},#{roleDesc})")
    public void save(Role role);

    @Select("select * from role where id not in(select roleId from users_role where userId = #{userId})")
    List<Role> findOtherRoleByUserId(String userId);

    //查询所有的Permission
    @Select("select * from permission where id not in(select permissionId from role_permission where roleId=#{roleId})")
    List<Permission> findOtherPermissions(String roleId);

    @Insert("insert into role_permission values(#{permissionId},#{roleId})")
    void addPermissionToRole(@Param("roleId") String roleId, @Param("permissionId") String permissionId);
}
