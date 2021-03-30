package cn.noteblogs.service;

import cn.noteblogs.domain.Permission;

import java.util.List;

/**
 * @author FoFiten
 * @create 2021/2/20 9:54
 */
public interface IPermissionService {
    public List<Permission> findAll();

    void save(Permission permission);

    void delete(String id);

    Permission findById(String id);
}
