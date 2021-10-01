package com.etisalat.imrh.controller;

import com.etisalat.imrh.dto.GenericResponseDto;
import com.etisalat.imrh.service.ProductService;
import com.etisalat.imrh.dto.Enable;
import com.etisalat.imrh.dto.ProductDto;
import com.etisalat.imrh.util.CommonUtils;
import com.etisalat.imrh.util.ExceptionUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * @author Nabeel Ahmed
 */
@RestController
@RequestMapping("/imrh/country")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {

    public Logger logger = LogManager.getLogger(PartnerController.class);

    @Autowired
    private ProductService productService;

    @RequestMapping(path = "/updateProduct", method = RequestMethod.POST)
    public GenericResponseDto<Object> updateProduct(@RequestBody ProductDto productDto) {
        try {
            return this.productService.updateProduct(productDto);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while updateProduct", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR.series().name(),
                    "Some Internal error accrue contact with support team.");
        }
    }

    @RequestMapping(path = "/enableDisableProduct", method = RequestMethod.POST)
    public GenericResponseDto<Object> enableDisableProduct(@RequestBody ProductDto productDto) {
        try {
            return this.productService.enableDisableProduct(productDto);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while enableDisableProduct", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR.series().name(),
                    "Some Internal error accrue contact with support team.");
        }
    }

    @RequestMapping(path = "/enableDisableAllProduct", method = RequestMethod.POST)
    public GenericResponseDto<Object> enableDisableAllProduct(@RequestParam(name = "enable") Enable enable) {
        try {
            return this.productService.enableDisableAllProduct(enable);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while updateAllProduct", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR.series().name(),
                    "Some Internal error accrue contact with support team.");
        }
    }

    @RequestMapping(path = "/fetchAllProduct", method = RequestMethod.GET)
    public GenericResponseDto<Object> fetchAllProduct() {
        try {
            return this.productService.fetchAllProduct();
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while fetchAllProduct", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR.series().name(),
                "Some Internal error accrue contact with support team.");
        }
    }

}
