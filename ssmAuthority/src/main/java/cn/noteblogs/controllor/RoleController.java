package cn.noteblogs.controllor;

import cn.noteblogs.domain.Permission;
import cn.noteblogs.domain.Role;
import cn.noteblogs.service.IRoleService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.NamedBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import java.util.List;

@Controller
@RequestMapping("/role")
@Secured({"ROLE_ADMIN"})
public class RoleController {
    @Autowired
    private IRoleService roleService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        //调用service查询所有
        List<Role> roles = roleService.findAll();
        mv.addObject("roleList",roles);
        mv.setViewName("role-list");
        return mv;
    }

    //通过id查询role信息permission-name-url
    @RequestMapping("/findById.do")
    public ModelAndView findById(String roleId){
        ModelAndView modelAndView = new ModelAndView();
        Role role = roleService.findById(roleId);
        modelAndView.addObject("role",role);
        modelAndView.setViewName("role-show");
        return modelAndView;
    }

    //保存role
    @RequestMapping("/save.do")
    public String save(Role role) throws Exception {
        roleService.save(role);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findRoleByIdAndAllPermission.do")
    public ModelAndView findRoleByIdAndAllPermission(@RequestParam(name = "id") String roleId){
        //根据roleId查询
        Role role = roleService.findById(roleId);
        //根据roleId查询可添加的权限
        List<Permission> otherPermissions=roleService.findOtherPermissions(roleId);
        ModelAndView mv=new ModelAndView();
        mv.addObject("role",role);
        mv.addObject("permissionList",otherPermissions);
        mv.setViewName("role-permission-add");
        return mv;
    }

    @RequestMapping("/addPermissionToRole.do")
    public String addPermissionToRole(@RequestParam("roleId") String roleId, @RequestParam("ids") String[] permissionIds){
        roleService.addPermissionToRole(roleId, permissionIds);
        return "redirect:findAll.do";
    }







}
