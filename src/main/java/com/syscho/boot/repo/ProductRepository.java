package com.syscho.boot.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.syscho.boot.model.ProductEntity;

@Repository
public interface ProductRepository extends CrudRepository<ProductEntity, Long> {

    List<ProductEntity> findAll();

    ProductEntity findByProductId(Long prodId);

    List<ProductEntity> findAllByProductNameIgnoreCase(String prodName);

    int deleteByProductId(long prodId);
}
