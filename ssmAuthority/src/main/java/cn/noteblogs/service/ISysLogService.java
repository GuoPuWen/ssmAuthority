package cn.noteblogs.service;

import cn.noteblogs.domain.SysLog;

import java.util.List;

/**
 * @author FoFiten
 * @create 2021/3/13 23:27
 */
public interface ISysLogService {
    void save(SysLog sysLog);
    List<SysLog> findAll();

}
