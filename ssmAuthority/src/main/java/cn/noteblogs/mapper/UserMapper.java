package cn.noteblogs.mapper;

import cn.noteblogs.domain.Order;
import cn.noteblogs.domain.UserInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Repository
public interface UserMapper {
    @Select("select * from users where id = #{id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "email", column = "email"),
            @Result(property = "phoneNum", column = "phoneNum"),
            @Result(property = "password", column = "password"),
            @Result(property = "status", column = "status"),
            @Result(property = "roles",column = "id", javaType = java.util.List.class, many = @Many(select = "cn.noteblogs.mapper.RoleMapper.findRoleByUserId"))
    })
    UserInfo findById(String id);

    @Select("select * from users where username = #{username}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "email", column = "email"),
            @Result(property = "phoneNum", column = "phoneNum"),
            @Result(property = "password", column = "password"),
            @Result(property = "status", column = "status"),
            @Result(property = "roles",column = "id", javaType = java.util.List.class, many = @Many(select = "cn.noteblogs.mapper.RoleMapper.findRoleByUserId"))
    })
    UserInfo findByUsername(String username);

    @Select("select * from users")
    List<UserInfo> findAll();

    @Insert("insert into users values(#{u.id},#{u.email},#{u.username},#{u.password},#{u.phoneNum},#{u.status})")
    void save(@Param("u") UserInfo userInfo);

    @Delete("delete from users where id = id")
    void delete(String id);

    @Insert("insert into users_role values(#{userId},#{roleId})")
    void addRoleToUser(@Param("userId") String userId, @Param("roleId") String roleId);
}
