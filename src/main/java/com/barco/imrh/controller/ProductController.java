package com.barco.imrh.controller;

import com.barco.imrh.dto.GenericResponseDto;
import com.barco.imrh.service.ProductService;
import com.barco.imrh.dto.Enable;
import com.barco.imrh.dto.ProductDto;
import com.barco.imrh.util.CommonUtils;
import com.barco.imrh.util.ConstantUtils;
import com.barco.imrh.util.ConstantUtils.ProductControllerConst;
import com.barco.imrh.util.ExceptionUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * @author Nabeel Ahmed
 */
@RestController
@CrossOrigin(origins = ProductControllerConst.ORIGINS)
@RequestMapping(ProductControllerConst.IMRH_PRODUCT)
public class ProductController {

    public Logger logger = LogManager.getLogger(PartnerController.class);

    @Autowired
    private ProductService productService;

    // working
    @RequestMapping(path = ProductControllerConst.FIND_BY_PRODUCT_ID, method = RequestMethod.GET)
    public GenericResponseDto<Object> findByProductId(@RequestParam(name = "productId") Long productId) {
        try {
            logger.info("Request findByProductId productId ==> " + productId);
            return this.productService.findByProductId(productId);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while findByProductId", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR
                    .series().name(), ConstantUtils.SOME_INTERNAL_ERROR);
        }
    }

    // working
    @RequestMapping(path = ProductControllerConst.UPDATE_PRODUCT, method = RequestMethod.POST)
    public GenericResponseDto<Object> updateProduct(@RequestBody ProductDto productDto) {
        try {
            logger.info("Request updateProduct " + productDto);
            return this.productService.updateProduct(productDto);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while updateProduct", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR
                    .series().name(), ConstantUtils.SOME_INTERNAL_ERROR);
        }
    }

    // working
    @RequestMapping(path = ProductControllerConst.ENABLE_DISABLE_PRODUCT, method = RequestMethod.POST)
    public GenericResponseDto<Object> enableDisableProduct(@RequestBody ProductDto productDto) {
        try {
            logger.info("Request enableDisableProduct " + productDto);
            return this.productService.enableDisableProduct(productDto);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while enableDisableProduct", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR
                    .series().name(), ConstantUtils.SOME_INTERNAL_ERROR);
        }
    }

    // working
    @RequestMapping(path = ProductControllerConst.ENABLE_DISABLE_ALL_PRODUCT, method = RequestMethod.POST)
    public GenericResponseDto<Object> enableDisableAllProduct(@RequestParam(name = "enable") Enable enable) {
        try {
            logger.info("Request enableDisableAllProduct enable ==> " + enable.name());
            return this.productService.enableDisableAllProduct(enable);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while updateAllProduct", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR
                    .series().name(), ConstantUtils.SOME_INTERNAL_ERROR);
        }
    }

    // working
    @RequestMapping(path = ProductControllerConst.FETCH_ALL_PRODUCT, method = RequestMethod.GET)
    public GenericResponseDto<Object> fetchAllProduct() {
        try {
            logger.info("Request fetchAllProduct");
            return this.productService.fetchAllProduct();
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while fetchAllProduct", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR
                    .series().name(), ConstantUtils.SOME_INTERNAL_ERROR);
        }
    }

}