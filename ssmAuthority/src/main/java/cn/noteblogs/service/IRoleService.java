package cn.noteblogs.service;

import cn.noteblogs.domain.Permission;
import cn.noteblogs.domain.Role;

import java.util.List;

/**
 * @author FoFiten
 * @create 2021/2/20 9:31
 */
public interface IRoleService {
    public List<Role> findAll() throws Exception;

    public void save(Role role) throws Exception;

    void deleteById(String id);

    Role findById(String roleId);

    List<Permission> findOtherPermissions(String roleId);

    void addPermissionToRole(String roleId, String[] permissionIds);



    List<Role> findOtherRoleByUserId(String userId);
}

