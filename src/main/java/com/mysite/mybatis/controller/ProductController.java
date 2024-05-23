package com.mysite.mybatis.controller;

import com.mysite.mybatis.mapper.ProductMapper;
import com.mysite.mybatis.model.Product;
import com.mysite.mybatis.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// RestController 는 화면없이 바로 객체나 문자열을 제이슨으로 리턴 => 공공데이터가 줄때 사용
@RestController // 화면이 없는 컨트롤러
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductMapper productMapper;

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id) {
        Product product = productMapper.selectProductById(id);
        return product;
    }
    // 모든 유저 리스트를 리턴
    @GetMapping
    public List<Product> getProductList() {
        List<Product> productList = productMapper.selectAllProducts();
        return productList;
    }

    @PostMapping
    public void createProduct(@RequestParam("name") String prodName,
                           @RequestParam("price") int prodPrice) {
        productMapper.insertProduct(new Product(prodName, prodPrice));
    }

    // 유저 업데이트 PUT 메서드
    @PutMapping("/{id}")
    public void editProduct( @PathVariable("id") Long prodId,
                          @RequestParam("name") String prodName,
                          @RequestParam("price") int prodPrice) {
        productMapper.updateProduct(new Product(prodId, prodName, prodPrice));
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long prod_id) {
        productMapper.deleteProductById(prod_id);
    }
}
