package cn.noteblogs.controllor;

import cn.noteblogs.domain.Order;
import cn.noteblogs.service.IOrderService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/orders")
@Secured({"ROLE_ADMIN","ROLE_USER"})
public class OrderController {

    @Autowired
    private IOrderService orderService;


    @RequestMapping("/findAll.do")
    public ModelAndView findAll(
            @RequestParam(name = "page", required = true, defaultValue = "1") Integer page,
            @RequestParam(name = "size", required = true, defaultValue = "4")Integer size){
        ModelAndView mv = new ModelAndView();
        List<Order> list = orderService.findAllByPage(page,size);
        PageInfo<Order> orderPageInfo = new PageInfo<Order>(list);
        mv.addObject("pageInfo", orderPageInfo);
        mv.setViewName("orders-list");
        return mv;
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(String id){
        ModelAndView mv = new ModelAndView();
        Order orders = orderService.findById(id);
        mv.addObject("orders", orders);
        mv.setViewName("orders-show");
        return mv;
    }
}
