package com.syscho.boot;

import com.syscho.boot.service.ProductService;
import com.syscho.boot.vo.ProductVO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@Slf4j
@AllArgsConstructor
@EnableJpaRepositories("com.syscho.boot.repo")
@EntityScan(basePackages = {"com.syscho.boot.model"})
public class Application implements CommandLineRunner {

    private ProductService productService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        productService.saveProduct(new ProductVO("jeans", 800, "Mens Wear"));
        productService.saveProduct(new ProductVO("shirt", 1000, "Mens Wear"));
        productService.saveProduct(new ProductVO("skirt", 750, "Ladies Wear"));

        log.info("3 products added successfully !!");
    }


}





















