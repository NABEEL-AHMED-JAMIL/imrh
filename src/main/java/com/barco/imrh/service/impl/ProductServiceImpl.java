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
                   String.format(PRODUCT_FIND_SUCCESSFULLY_WITH_ID, productDto.getProductId()));
        }
        return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST.series().name(),
                String.format(PRODUCT_NOT_FOUND_WITH_ID, productId));
    }

    @Override
    public GenericResponseDto<Object> updateProduct(ProductDto productDto) {
        if (CommonUtils.isNull(productDto.getProductId())) {
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST
                    .series().name(), PRODUCT_ID_MISSING);
        } else if (CommonUtils.isNull(productDto.getProductName())) {
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST
                    .series().name(), PRODUCT_NAME_MISSING);
        }
        Optional<Product> product = this.productRepository.findById(productDto.getProductId());
        if (product.isPresent()) {
            product.get().setProductName(productDto.getProductName());
            product.get().setEnabled(productDto.getEnabled().name());
            productDto.setProductImageUrl(product.get().getProductImageUrl());
            this.productRepository.save(product.get());
            return CommonUtils.getResponseWithData(productDto, HttpStatus.OK.series().name(),
            String.format(PRODUCT_UPDATE_SUCCESSFULLY_WITH_ID, productDto.getProductId()));
        }
        return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST.series().name(),
            String.format(PRODUCT_NOT_FOUND_WITH_ID, productDto.getProductId()));
    }

    @Override
    public GenericResponseDto<Object> enableDisableProduct(ProductDto productDto) {
        if (CommonUtils.isNull(productDto.getProductId())) {
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST
                    .series().name(), PRODUCT_ID_MISSING);
        }
        Optional<Product> product = this.productRepository.findById(productDto.getProductId());
        if (product.isPresent()) {
            product.get().setEnabled(productDto.getEnabled().name());
            this.productRepository.save(product.get());
            return CommonUtils.getResponseWithData(productDto, HttpStatus.OK.series().name(),
                String.format(PRODUCT_UPDATE_SUCCESSFULLY_WITH_ID, productDto.getProductId()));
        }
        return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST.series().name(),
                String.format(PRODUCT_NOT_FOUND_WITH_ID, productDto.getProductId()));
    }

    @Override
    public GenericResponseDto<Object> enableDisableAllProduct(Enable enable) {
        return CommonUtils.getResponseWithData(this.productRepository.setAllProductStatus(enable.name()),
            HttpStatus.OK.series().name(), ALL_PRODUCT_UPDATE_SUCCESSFULLY);
    }

    @Override
    public GenericResponseDto<Object> fetchAllProduct() {
        logger.info("Fetch fetchAllProduct");
        return CommonUtils.getResponseWithData(
            this.productRepository.findAllProduct(), HttpStatus.OK.series().name(),
            String.format(PRODUCT_FETCH_SUCCESSFULLY));
    }
}