package com.barco.imrh.repository;

import com.barco.imrh.repository.projection.ProductProjection;
import com.barco.imrh.entity.Product;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.barco.imrh.util.ConstantUtils.ProductRepositoryConst;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * @author Nabeel Ahmed
 */
@Repository
@Transactional
public interface ProductRepository extends CrudRepository<Product, Long> {

    @Query(value = ProductRepositoryConst.FIND_ALL_PRODUCT, nativeQuery = true)
    public List<ProductProjection> findAllProduct();

    @Modifying
    @Query(value = ProductRepositoryConst.SET_ALL_PRODUCT_STATUS)
    public int setAllProductStatus(String enabled);

}