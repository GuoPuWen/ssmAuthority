package cn.noteblogs.service.Impl;

import cn.noteblogs.domain.Permission;
import cn.noteblogs.mapper.PermissionMapper;
import cn.noteblogs.service.IPermissionService;
import cn.noteblogs.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service("permissionService")
public class PermissionServiceImpl implements IPermissionService {

    @Autowired
    private PermissionMapper permissionDao;

    public Permission findById(String id) {
        return permissionDao.findById(id);

    }


    public void delete(String id) {
        permissionDao.delete(id);
    }


    public void save(Permission permission) {
        String format="yyMMdd-HHmm";
        permission.setId(DateUtil.data2String(new Date(),format));
        permissionDao.save(permission);
    }


    public List<Permission> findAll() {
        return permissionDao.findAll();
    }
}
