package cn.noteblogs.controllor;

import cn.noteblogs.domain.SysLog;
import cn.noteblogs.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/sysLog")
@Secured("ROLE_ADMIN")
public class SysLogController {

    @Autowired
    ISysLogService sysLogService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(){
        List<SysLog> sysLogs = sysLogService.findAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject("sysLogList", sysLogs);
        mv.setViewName("syslog-list");
        return mv;
    }
}
