package cn.noteblogs.service.Impl;

import cn.noteblogs.domain.Role;
import cn.noteblogs.domain.UserInfo;
import cn.noteblogs.mapper.UserMapper;
import cn.noteblogs.service.IRoleService;
import cn.noteblogs.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private IRoleService roleService;


    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = userMapper.findByUsername(username);
        System.out.println(userInfo);
        List<Role> roles = userInfo.getRoles();
        List<SimpleGrantedAuthority> authority = getAuthority(roles);
        User user = new User(userInfo.getUsername(), "{noop}" + userInfo.getPassword(),
                userInfo.getStatus() == 0 ? false : true, true,true,true,authority);

        return user;
    }

    /**
     * 封装权限
     * @param roles
     * @return
     */
    private List<SimpleGrantedAuthority> getAuthority(List<Role> roles){
        List<SimpleGrantedAuthority> authorities = new ArrayList();
        for(Role role : roles){
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        }
        return authorities;
    }

    public List<UserInfo> findAll() {
        List<UserInfo> users = userMapper.findAll();
        return users;
    }

    public void save(UserInfo userInfo) {
        userInfo.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        userMapper.save(userInfo);
    }

    public void delete(String id) {
        userMapper.delete(id);
    }

    public UserInfo findById(String id) {
        return userMapper.findById(id);
    }

    public List<Role> findOtherRole(String id) {
        return roleService.findOtherRoleByUserId(id);
    }

    public void addRoleToUser(String userId, String roleId) {
        userMapper.addRoleToUser(userId, roleId);
    }
}
