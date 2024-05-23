package com.mysite.mybatis.mapper;

import com.mysite.mybatis.model.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {
    // xml 을 사용할때는 추상메서드만 만들고 실제 sql 은 지정된 폴더의 xml에 적음

    Product selectProductById(Long id);
    List<Product> selectAllProducts();
    void insertProduct(Product product);
    void updateProduct(Product product);
    void deleteProductById(Long id);
}
