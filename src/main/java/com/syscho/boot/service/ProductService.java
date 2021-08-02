package com.syscho.boot.service;

import com.syscho.boot.exception.NoDataFoundException;
import com.syscho.boot.model.ProductEntity;
import com.syscho.boot.repo.ProductRepository;
import com.syscho.boot.vo.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.syscho.boot.utils.CommonUtils.convertEntityToVo;
import static com.syscho.boot.utils.CommonUtils.convertVoToEntity;

/**
 * @author Soni
 */
@Service
public class ProductService {

    public static final String INVALID_PRODUCT_ID = "Invalid product id %d ";
    public static final String DELETED_SUCCESSFULLY = " %d id Deleted Successfully !!";

    @Autowired
    private ProductRepository productDao;

    public List<ProductVO> getProducts() {

        return convertEntityToVo(productDao.findAll());
    }

    public ProductVO getProductById(Long prodId) {

        ProductEntity product = productDao.findByProductId(prodId);
        if (null == product) {
            throw new NoDataFoundException(prodId);
        }
        return convertEntityToVo(product);
    }

    public List<ProductVO> getProductsByName(String prodName) {

        return convertEntityToVo(productDao.findAllByProductNameIgnoreCase(prodName));
    }

    @Transactional
    public String deleteProductById(long prodId) {

        int count = productDao.deleteByProductId(prodId);
        if (count == 0) {
            throw new NoDataFoundException(prodId);
        }

        return String.format(DELETED_SUCCESSFULLY, prodId);
    }

    @Transactional
    public ProductVO saveProduct(ProductVO product) {
        ProductEntity productEntity = convertVoToEntity(product);
        ProductEntity save = productDao.save(productEntity);
        product.setProductId(save.getProductId());
        return product;
    }

    @Transactional
    public ProductVO updateProduct(ProductVO updatedProduct) {

        ProductEntity oldProduct = productDao.findByProductId(updatedProduct.getProductId());
        if (null == oldProduct) {
            throw new RuntimeException(String.format(INVALID_PRODUCT_ID, updatedProduct.getProductId()));
        }
        ProductEntity productEntity = convertVoToEntity(updatedProduct);
        ProductEntity save = productDao.save(productEntity);
        updatedProduct.setProductId(save.getProductId());
        return updatedProduct;
    }

}







