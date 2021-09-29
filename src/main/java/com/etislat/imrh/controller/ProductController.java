package com.etislat.imrh.controller;

import com.etislat.imrh.dto.GenericResponseDto;
import com.etislat.imrh.dto.ProductDto;
import com.etislat.imrh.service.ProductService;
import com.etislat.imrh.util.CommonUtils;
import com.etislat.imrh.util.ExceptionUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
            logger.error("An error occurred while fetchAllProduct", ExceptionUtil.getRootCauseMessage(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR.series().name(),
                    "Some Internal error accrue contact with support team.");
        }
    }

    @RequestMapping(path = "/disableProduct", method = RequestMethod.POST)
    public GenericResponseDto<Object> disableProduct(@RequestBody ProductDto productDto) {
        try {
            return this.productService.disableProduct(productDto);
        } catch (Exception ex) {
            logger.error("An error occurred while fetchAllProduct", ExceptionUtil.getRootCauseMessage(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR.series().name(),
                    "Some Internal error accrue contact with support team.");
        }
    }

    @RequestMapping(path = "/fetchAllProduct", method = RequestMethod.GET)
    public GenericResponseDto<Object> fetchAllProduct() {
        try {
            return this.productService.fetchAllProduct();
        } catch (Exception ex) {
            logger.error("An error occurred while fetchAllProduct", ExceptionUtil.getRootCauseMessage(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR.series().name(),
                "Some Internal error accrue contact with support team.");
        }
    }

}
