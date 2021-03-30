package cn.noteblogs.service.Impl;

import cn.noteblogs.domain.SysLog;
import cn.noteblogs.mapper.SysLogMapper;
import cn.noteblogs.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("sysLogService")
public class SysLogServiceImpl implements ISysLogService {

    @Qualifier("sysLogMapper")
    @Autowired
    SysLogMapper sysLogMapper;

    public void save(SysLog sysLog) {
        sysLogMapper.save(sysLog);
    }

    public List<SysLog> findAll() {
        return sysLogMapper.findAll();
    }
}
