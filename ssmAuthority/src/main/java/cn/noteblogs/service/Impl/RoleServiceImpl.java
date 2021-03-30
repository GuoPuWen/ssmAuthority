package cn.noteblogs.service.Impl;

import cn.noteblogs.domain.Permission;
import cn.noteblogs.domain.Role;
import cn.noteblogs.mapper.RoleMapper;
import cn.noteblogs.service.IRoleService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service("roleService")
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired


    public List<Role> findAll() throws Exception {
        return roleMapper.findAll();
    }

    public void save(Role role) throws Exception {
        String id = UUID.randomUUID().toString().replaceAll("-", "");
        role.setId(id);
        roleMapper.save(role);
    }

    public void deleteById(String id) {

    }

    public Role findById(String roleId) {
        return roleMapper.findById(roleId);
    }

    public List<Permission> findOtherPermissions(String roleId) {
        return roleMapper.findOtherPermissions(roleId);
    }

    public void addPermissionToRole(String roleId, String[] permissionIds) {
        for (String permissionId:permissionIds){
            roleMapper.addPermissionToRole(roleId,permissionId);
        }
    }

    public List<Role> findOtherRoleByUserId(String userId) {
        return roleMapper.findOtherRoleByUserId(userId);
    }


}
