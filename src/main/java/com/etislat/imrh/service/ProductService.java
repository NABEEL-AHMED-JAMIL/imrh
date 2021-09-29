package com.etislat.imrh.service;

import com.etislat.imrh.dto.GenericResponseDto;
import com.etislat.imrh.dto.ProductDto;

public interface ProductService {

    public GenericResponseDto<Object> updateProduct(ProductDto productDto);

    public GenericResponseDto<Object> disableProduct(ProductDto productDto);

    public GenericResponseDto<Object> fetchAllProduct();
}
