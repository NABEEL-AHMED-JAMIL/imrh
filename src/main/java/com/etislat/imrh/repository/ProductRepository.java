package com.etislat.imrh.repository;

import com.etislat.imrh.entity.Product;
import com.etislat.imrh.repository.projection.ProductProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Transactional(readOnly = true)
    @Query(value = "SELECT PRODUCT_ID as productId, PRODUCT_NAME as productName, ENABLED as enabled from PRODUCT", nativeQuery = true)
    List<ProductProjection> findAllProduct();
}
