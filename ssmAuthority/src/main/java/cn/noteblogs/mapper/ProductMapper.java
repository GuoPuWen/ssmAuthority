package cn.noteblogs.mapper;

import cn.noteblogs.domain.Product;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author FoFiten
 * @create 2021/2/9 9:18
 */
@Repository
public interface ProductMapper {

    @Select("select * from product")
    List<Product> findAll();


    @Insert({"insert into product(id,productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus)" +
            "values(#{p.id},#{p.productNum},#{p.productName},#{p.cityName},#{p.departureTimeStr},#{p.productPrice},#{p.productDesc},#{p.productStatus})"})
    int save(@Param("p") Product p);

    @Delete("delete from product where id = #{productId}")
    int delete(String productId);

    @Select("select * from product where id = #{productId}")
    Product findById(String productId);

    @Update("update product set productNum=#{p.productNum},productName=#{p.productName}," +
            "cityName=#{p.cityName},departureTime=#{p.departureTimeStr},productPrice=#{p.productPrice},productDesc=#{p.productDesc}," +
            "productStatus=#{p.productStatus} where id = #{p.id}")
    int update(@Param("p")Product p);
}
