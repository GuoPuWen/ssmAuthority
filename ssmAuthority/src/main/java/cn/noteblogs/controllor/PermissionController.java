package cn.noteblogs.controllor;

import cn.noteblogs.domain.Permission;
import cn.noteblogs.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/permission")
@Secured({"ROLE_ADMIN"})
public class PermissionController {

    @Autowired
    private IPermissionService permissionService;

    //查询所有的
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(){
        ModelAndView modelAndView = new ModelAndView();
        List<Permission> permissions=permissionService.findAll();
        modelAndView.setViewName("permission-list");
        modelAndView.addObject("permissionList",permissions);
        return modelAndView;
    }

    @RequestMapping("/save.do")
    public String save(Permission permission){
        permissionService.save(permission);
        return "redirect:findAll.do";
    }

    //删除权限
    @RequestMapping("/deletePermission.do")
    public String delete(String id){
        permissionService.delete(id);
        return "redirect:findAll.do";
    }

    //详情
    @RequestMapping("/findById")
    public ModelAndView findById(String id){
        ModelAndView modelAndView=new ModelAndView();
        Permission permission=permissionService.findById(id);
        modelAndView.addObject("permission",permission);
        modelAndView.setViewName("permission-show");
        return modelAndView;
    }
}
