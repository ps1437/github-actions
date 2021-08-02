package com.syscho.boot.controller;

import com.syscho.boot.service.ProductService;
import com.syscho.boot.vo.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author Soni
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/{id}")
    public ProductVO getProductById(@PathVariable("id") long prodId) {
        return productService.getProductById(prodId);
    }

    @GetMapping("/name/{name}")
    public List<ProductVO> getProductsByName(@PathVariable("name") String prodName) {
        return productService.getProductsByName(prodName);
    }

    @GetMapping
    public List<ProductVO> getProducts() {
        return productService.getProducts();
    }

    @PostMapping
    public ProductVO saveProduct(@RequestBody @Valid ProductVO product) {
        return productService.saveProduct(product);
    }

    @PutMapping
    public ProductVO updateProduct(@RequestBody @Valid ProductVO product) {
        return productService.updateProduct(product);
    }

    @DeleteMapping("/{id}")
    public String deleteProductById(@PathVariable("id") long prodId) {
        return productService.deleteProductById(prodId);
    }
}
