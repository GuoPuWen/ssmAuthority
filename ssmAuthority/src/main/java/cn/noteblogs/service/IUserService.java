package cn.noteblogs.service;


import cn.noteblogs.domain.Role;
import cn.noteblogs.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * @author FoFiten
 * @create 2021/2/18 19:53
 */
public interface IUserService extends UserDetailsService {
    List<UserInfo> findAll();

    void save(UserInfo userInfo);

    void delete(String id);

    UserInfo findById(String id);

    List<Role> findOtherRole(String id);

    void addRoleToUser(String userId, String roleId);
}
