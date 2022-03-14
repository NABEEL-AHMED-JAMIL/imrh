package com.barco.imrh.service.impl;

import com.barco.imrh.repository.ProductRepository;
import com.barco.imrh.dto.GenericResponseDto;
import com.barco.imrh.entity.Product;
import com.barco.imrh.service.ProductService;
import com.barco.imrh.dto.Enable;
import com.barco.imrh.dto.ProductDto;
import com.barco.imrh.util.CommonUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

/**
 * @author Nabeel Ahmed
 */
@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    public Logger logger = LogManager.getLogger(ProductServiceImpl.class);

    @Autowired
    private ProductRepository productRepository;

    @Override
    public GenericResponseDto<Object> findByProductId(Long productId) {
        Optional<Product> product = this.productRepository.findById(productId);
        if (product.isPresent()) {
            ProductDto productDto = new ProductDto();
            productDto.setProductId(product.get().getProductId());
            productDto.setProductName(product.get().getProductName());
            productDto.setProductImageUrl(product.get().getProductImageUrl());
            productDto.setEnabled(Enable.valueOf(product.get().getEnabled()));
            return CommonUtils.getResponseWithData(productDto, HttpStatus.OK.series().name(),
                String.format("Product find successfully with %d.", productDto.getProductId()));
        }
        return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST.series().name(),
                String.format("Product not found with %d.", productId));
    }

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
            product.get().setEnabled(productDto.getEnabled().name());
            productDto.setProductImageUrl(product.get().getProductImageUrl());
            this.productRepository.save(product.get());
            return CommonUtils.getResponseWithData(productDto, HttpStatus.OK.series().name(),
            String.format("Product update successfully with %d.", productDto.getProductId()));
        }
        return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST.series().name(),
            String.format("Product not found with %d.", productDto.getProductId()));
    }

    @Override
    public GenericResponseDto<Object> enableDisableProduct(ProductDto productDto) {
        if (CommonUtils.isNull(productDto.getProductId())) {
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST.series().name(),
                "Product id missing.");
        }
        Optional<Product> product = this.productRepository.findById(productDto.getProductId());
        if (product.isPresent()) {
            product.get().setEnabled(productDto.getEnabled().name());
            this.productRepository.save(product.get());
            return CommonUtils.getResponseWithData(productDto, HttpStatus.OK.series().name(),
                String.format("Product update successfully with %d.", productDto.getProductId()));
        }
        return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST.series().name(),
                String.format("Product not found with %d.", productDto.getProductId()));
    }

    @Override
    public GenericResponseDto<Object> enableDisableAllProduct(Enable enable) {
        return CommonUtils.getResponseWithData(this.productRepository.setAllProductStatus(enable.name()),
            HttpStatus.OK.series().name(), "All Product update successfully.");
    }

    @Override
    @Cacheable(value="product")
    public GenericResponseDto<Object> fetchAllProduct() {
        logger.info("Fetch fetchAllProduct");
        return CommonUtils.getResponseWithData(this.productRepository.findAllProduct(), HttpStatus.OK.series().name(),
            String.format("Product fetch successfully."));
    }
}