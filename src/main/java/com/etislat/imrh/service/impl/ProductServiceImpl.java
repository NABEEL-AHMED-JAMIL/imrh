package com.etislat.imrh.service.impl;

import com.etislat.imrh.dto.GenericResponseDto;
import com.etislat.imrh.dto.ProductDto;
import com.etislat.imrh.entity.Product;
import com.etislat.imrh.repository.ProductRepository;
import com.etislat.imrh.service.ProductService;
import com.etislat.imrh.util.CommonUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    public Logger logger = LogManager.getLogger(ProductServiceImpl.class);

    @Autowired
    private ProductRepository productRepository;

    @Override
    public GenericResponseDto<Object> updateProduct(ProductDto productDto) {
        if (CommonUtils.isNull(productDto.getProductId())) {
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST.series().name(),
                "Product id missing.");
        } else if (CommonUtils.isNull(productDto.getProductName())) {
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST.series().name(),
                "Product name missing.");
        }
        Optional<Product> product = this.productRepository.findById(productDto.getProductId());
        if (product.isPresent()) {
            product.get().setProductName(productDto.getProductName());
            product.get().setEnabled(productDto.getEnable().name());
            return CommonUtils.getResponseWithData(this.productRepository.save(product.get()), HttpStatus.OK.series().name(),
                null, String.format("Product update successfully with %d.", productDto.getProductId()));
        }
        return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST.series().name(),
            String.format("Product not found with %d.", productDto.getProductId()));
    }

    @Override
    public GenericResponseDto<Object> disableProduct(ProductDto productDto) {
        if (CommonUtils.isNull(productDto.getProductId())) {
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST.series().name(),
                    "Product id missing.");
        }
        Optional<Product> product = this.productRepository.findById(productDto.getProductId());
        if (product.isPresent()) {
            product.get().setEnabled(productDto.getEnable().name());
            return CommonUtils.getResponseWithData(this.productRepository.save(product.get()), HttpStatus.OK.series().name(),
                    null, String.format("Product update successfully with %d.", productDto.getProductId()));
        }
        return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST.series().name(),
                String.format("Product not found with %d.", productDto.getProductId()));
    }

    @Override
    public GenericResponseDto<Object> fetchAllProduct() {
        return CommonUtils.getResponseWithData(this.productRepository.findAllProduct(), HttpStatus.OK.series().name(),
            null, String.format("Product fetch successfully."));
    }
}
