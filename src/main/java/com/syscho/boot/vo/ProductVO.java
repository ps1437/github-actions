package com.syscho.boot.vo;

import lombok.*;

import javax.validation.constraints.Min;

/**
 * @author Soni
 */
@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class ProductVO {


    private Long productId;
    private String productName;
    private int productPrice;
    private String productDescription;

    public ProductVO(String productName, int productPrice, String productDescription) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productDescription = productDescription;
    }
}
