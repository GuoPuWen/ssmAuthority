package cn.noteblogs.service;

import cn.noteblogs.domain.Product;

import java.util.List;

/**
 * @author FoFiten
 * @create 2021/2/9 9:15
 */
public interface IProductService {
    List<Product> findAll();
    int save(Product product);
    int delete(String productId);
    Product findById(String id);
    int update(Product product);
}
