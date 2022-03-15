package com.barco.imrh.service;

import com.barco.imrh.dto.Enable;
import com.barco.imrh.dto.GenericResponseDto;
import com.barco.imrh.dto.ProductDto;

/**
 * @author Nabeel Ahmed
 */
public interface ProductService {

    public GenericResponseDto<Object> findByProductId(Long productId);

    public GenericResponseDto<Object> updateProduct(ProductDto productDto);

    public GenericResponseDto<Object> enableDisableProduct(ProductDto productDto);

    public GenericResponseDto<Object> enableDisableAllProduct(Enable enable);

    public GenericResponseDto<Object> fetchAllProduct();

}