package com.barco.imrh.service;

import com.barco.imrh.dto.Enable;
import com.barco.imrh.dto.GenericResponseDto;
import com.barco.imrh.dto.ProductDto;

/**
 * @author Nabeel Ahmed
 */
public interface ProductService {

    public static final String PRODUCT_FIND_SUCCESSFULLY_WITH_ID = "Product find successfully with %d.";
    public static final String PRODUCT_NOT_FOUND_WITH_ID = "Product not found with %d.";
    public static final String PRODUCT_ID_MISSING = "Product id missing.";
    public static final String PRODUCT_NAME_MISSING = "Product name missing.";
    public static final String PRODUCT_UPDATE_SUCCESSFULLY_WITH_ID = "Product update successfully with %d.";
    public static final String ALL_PRODUCT_UPDATE_SUCCESSFULLY = "All Product update successfully.";
    public static final String PRODUCT_FETCH_SUCCESSFULLY = "Product fetch successfully.";

    public GenericResponseDto<Object> findByProductId(Long productId);

    public GenericResponseDto<Object> updateProduct(ProductDto productDto);

    public GenericResponseDto<Object> enableDisableProduct(ProductDto productDto);

    public GenericResponseDto<Object> enableDisableAllProduct(Enable enable);

    public GenericResponseDto<Object> fetchAllProduct();

}