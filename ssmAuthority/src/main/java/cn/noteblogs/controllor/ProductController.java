package cn.noteblogs.controllor;

import cn.noteblogs.domain.Product;
import cn.noteblogs.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/product")
@Secured({"ROLE_ADMIN","ROLE_USER"})
public class ProductController {

    @Autowired
    private IProductService productService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(){
        ModelAndView mv = new ModelAndView();
        List<Product> list = productService.findAll();
        mv.addObject("productList", list);
        mv.setViewName("product-list");
        return mv;
    }

    @RequestMapping("/save.do")
    public String save(Product product) throws Exception {
        System.out.println(product);
        productService.save(product);
        return "redirect:findAll.do";
    }

    @RequestMapping("/delete.do")
    public String delete(String id){
        System.out.println(id);
        productService.delete(id);
        return "redirect:findAll.do";
    }

    @RequestMapping("/edit.do")
    public ModelAndView edit(String id){
        ModelAndView mv = new ModelAndView();
        Product product = productService.findById(id);
        System.out.println(product);
        mv.addObject("product",product);
        mv.setViewName("product-edit");
        return mv;
    }

    @RequestMapping("/editSave.do")
    public String editSave(Product product){
        System.out.println(product);
        productService.update(product);
        return "redirect:findAll.do";
    }


}
