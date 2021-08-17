package com.syscho.boot.service;

import com.syscho.boot.model.ProductEntity;
import com.syscho.boot.repo.ProductRepository;
import com.syscho.boot.vo.ProductVO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.mockito.ArgumentMatchers.any;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DataJpaTest
public class ProductServiceTest {
    @InjectMocks
    private ProductService productService;
    @Autowired
    private ProductRepository productRepository;

    @Test
    void testShouldSaveProduct() {
        ProductVO product = buildProduct();

        ProductVO product1 = productService.saveProduct(product);


        ProductVO productById = productService.getProductById(product.getProductId());
        System.out.println(productById);
    }

    private ProductVO buildProduct() {
        return ProductVO.builder().productId(1L)
                .productPrice(13123)
                .productDescription("description")
                .productName("name").build();
    }

}
