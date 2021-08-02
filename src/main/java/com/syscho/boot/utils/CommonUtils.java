package com.syscho.boot.utils;

import com.syscho.boot.model.ProductEntity;
import com.syscho.boot.vo.ProductVO;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class CommonUtils {

    public static ProductVO convertEntityToVo(ProductEntity source) {
        ProductVO target = new ProductVO();
        BeanUtils.copyProperties(source, target);
        return target;
    }

    public static List<ProductVO> convertEntityToVo(List<ProductEntity> source) {
        List<ProductVO> products = new ArrayList<>();
        for (ProductEntity product : source) {
            products.add(convertEntityToVo(product));
        }
        return products;
    }

    public static ProductEntity convertVoToEntity(ProductVO source) {
        ProductEntity target = new ProductEntity();
        BeanUtils.copyProperties(source, target);
        return target;
    }


}
