package cn.noteblogs;


import cn.noteblogs.domain.Product;
import cn.noteblogs.mapper.ProductMapper;
import cn.noteblogs.service.IProductService;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

public class test1 {
    @Test
    public void testSpring(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        IProductService productService = ac.getBean("productService", IProductService.class);
        System.out.println(productService);
    }
    @Test
    public void testMybatis() throws IOException {
        InputStream rs = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(rs);
        SqlSession session = build.openSession();
        ProductMapper productDao = session.getMapper(ProductMapper.class);
        List<Product> accounts = productDao.findAll();
        for (Product account : accounts) {
            System.out.println(account);
        }
    }
    @Test
    public void testBCryptPasswordEncoder(){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        System.out.println(bCryptPasswordEncoder.encode("123456"));
    }
    @Test
    public void testUUID(){
        for (int i = 0; i < 5; i++) {
            System.out.println(UUID.randomUUID().toString().replaceAll("-", ""));
        }
    }

    @Test
    public void testSpiring(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        String[] names = context.getBeanDefinitionNames();
        for(String name : names){
            System.out.println(name);
        }
    }




}
