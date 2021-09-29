package com.etisalat.imrh.repository;

import com.etisalat.imrh.entity.Product;
import com.etisalat.imrh.repository.projection.ProductProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "SELECT PRODUCT_ID as productId, PRODUCT_NAME as productName, " +
        "ENABLED as enabled from PRODUCT", nativeQuery = true)
    @Transactional(readOnly = true)
    public List<ProductProjection> findAllProduct();

    @Modifying
    @Query("update Product product set product.enabled = ?1")
    public int setAllProductStatus(String enabled);

}
