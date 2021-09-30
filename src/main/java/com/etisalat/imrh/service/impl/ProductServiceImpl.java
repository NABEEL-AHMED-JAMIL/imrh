package com.etisalat.imrh.service.impl;

import com.etisalat.imrh.dto.GenericResponseDto;
import com.etisalat.imrh.entity.Product;
import com.etisalat.imrh.repository.ProductRepository;
import com.etisalat.imrh.service.ProductService;
import com.etisalat.imrh.dto.Enable;
import com.etisalat.imrh.dto.ProductDto;
import com.etisalat.imrh.util.CommonUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Service
@Transactional
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
            this.productRepository.save(product.get());
            return CommonUtils.getResponseWithData(productDto, HttpStatus.OK.series().name(),
                null, String.format("Product update successfully with %d.", productDto.getProductId()));
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
            product.get().setEnabled(productDto.getEnable().name());
            this.productRepository.save(product.get());
            return CommonUtils.getResponseWithData(productDto, HttpStatus.OK.series().name(),
                    null, String.format("Product update successfully with %d.", productDto.getProductId()));
        }
        return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.BAD_REQUEST.series().name(),
                String.format("Product not found with %d.", productDto.getProductId()));
    }

    @Override
    public GenericResponseDto<Object> enableDisableAllProduct(Enable enable) {
        return CommonUtils.getResponseWithData(this.productRepository.setAllProductStatus(enable.name()), HttpStatus.OK.series().name(),
            null, "All Product update successfully.");
    }

    @Override
    public GenericResponseDto<Object> fetchAllProduct() {
        return CommonUtils.getResponseWithData(this.productRepository.findAllProduct(), HttpStatus.OK.series().name(),
            null, String.format("Product fetch successfully."));
    }
}
