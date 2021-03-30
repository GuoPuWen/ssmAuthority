package cn.noteblogs.service.Impl;


import cn.noteblogs.domain.Product;
import cn.noteblogs.mapper.ProductMapper;
import cn.noteblogs.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service("productService")
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductMapper productMapper;


    public List<Product> findAll() {
        List<Product> list = productMapper.findAll();
        System.out.println(list);
        return list;
    }

    public int save(Product product) {
        //设置UUID
        String s = UUID.randomUUID().toString().replaceAll("-", "");
        product.setId(s);
        return productMapper.save(product);
    }

    public int delete(String productId) {
        return productMapper.delete(productId);
    }

    public Product findById(String id) {
        Product product = productMapper.findById(id);
        product.setId(id);
        return product;
    }

    public int update(Product product) {
        return productMapper.update(product);
    }
}
