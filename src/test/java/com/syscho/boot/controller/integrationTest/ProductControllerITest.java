package com.syscho.boot.controller.integrationTest;


import com.syscho.boot.Application;
import com.syscho.boot.vo.ProductVO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import java.util.List;

@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductControllerITest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testAllProducts() {
        List productVOS = this.restTemplate
                .getForObject("http://localhost:" + port + "/product", List.class);
        Assertions.assertNotNull(productVOS);
    }

    @Test
    public void testProductById() {
        ProductVO productVOS = this.restTemplate
                .getForObject("http://localhost:" + port + "/product/1", ProductVO.class);
        Assertions.assertNotNull(productVOS);
    }

    @Test
    public void testProductByName() {
        List<ProductVO> productVOS = this.restTemplate
                .getForObject("http://localhost:" + port + "/product/name/jeans", List.class);
        Assertions.assertNotNull(productVOS);
    }


    @Test
    public void testDeleteById() {
        Assertions.assertDoesNotThrow(() -> this.restTemplate
                .delete("http://localhost:" + port + "/product/1", String.class));
    }

    @Test
    public void testSaveProduct() {
        ProductVO product = new ProductVO();
        product.setProductName("Shoes");
        product.setProductPrice(232);
        product.setProductDescription("Mens shoes");

        ProductVO saveProduct = this.restTemplate
                .postForObject("http://localhost:" + port + "/product", product, ProductVO.class);

        Assertions.assertNotNull(saveProduct);
        Assertions.assertNotNull(saveProduct.getProductId());
        Assertions.assertEquals(product.getProductName(), saveProduct.getProductName());
    }

    @Test
    public void testUpdateProduct() {
        ProductVO product = new ProductVO();
        product.setProductId(1L);
        product.setProductPrice(232);
        product.setProductDescription("Mens shoes");

        Assertions.assertDoesNotThrow(() -> this.restTemplate
                .put("http://localhost:" + port + "/product", product, ProductVO.class));

    }

}
