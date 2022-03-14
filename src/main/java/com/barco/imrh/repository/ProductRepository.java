package com.barco.imrh.repository;

import com.barco.imrh.repository.projection.ProductProjection;
import com.barco.imrh.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * @author Nabeel Ahmed
 */
@Repository
@Transactional
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "SELECT PRODUCT_ID AS productId, PRODUCT_NAME AS productName,\n" +
         "PRODUCT_IMAGE_URl AS productImageUrl, ENABLED AS enabled FROM PRODUCT", nativeQuery = true)
    @Transactional(readOnly = true)
    public List<ProductProjection> findAllProduct();

    @Modifying
    @Query("UPDATE Product product SET product.enabled = ?1")
    public int setAllProductStatus(String enabled);

}