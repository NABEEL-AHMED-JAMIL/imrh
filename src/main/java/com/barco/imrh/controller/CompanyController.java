package com.barco.imrh.controller;


import com.barco.imrh.dto.CompanyDto;
import com.barco.imrh.dto.GenericResponseDto;
import com.barco.imrh.util.CommonUtils;
import com.barco.imrh.util.ConstantUtils;
import com.barco.imrh.util.ConstantUtils.CompanyControllerConst;
import com.barco.imrh.util.ExceptionUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * @author Nabeel Ahmed
 */
@RestController
@CrossOrigin(origins = CompanyControllerConst.ORIGINS)
@RequestMapping(CompanyControllerConst.IMRH_COMPANY)
public class CompanyController {

    public Logger logger = LogManager.getLogger(CompanyController.class);

    @RequestMapping(path = CompanyControllerConst.CREATE_COMPANY, method = RequestMethod.POST)
    public GenericResponseDto<Object> createCompany(@RequestBody CompanyDto companyDto) {
        try {
            logger.info("Request createCompany ==> " + companyDto);
            return null;
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while createCompany", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR
                    .series().name(), ConstantUtils.SOME_INTERNAL_ERROR);
        }
    }

    @RequestMapping(path = CompanyControllerConst.UPDATE_COMPANY_DETAIL, method = RequestMethod.POST)
    public GenericResponseDto<Object> updateCompanyDetail(@RequestBody CompanyDto companyDto) {
        try {
            logger.info("Request updateCompanyDetail ==> " + companyDto);
            return null;
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while updateCompanyDetail", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR
                    .series().name(), ConstantUtils.SOME_INTERNAL_ERROR);
        }
    }

    @RequestMapping(path = CompanyControllerConst.CLOSE_COMPANY_DETAIL, method = RequestMethod.POST)
    public GenericResponseDto<Object> closeCompany(@RequestBody CompanyDto companyDto) {
        try {
            logger.info("Request closeCompany ==> " + companyDto);
            return null;
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while closeCompany", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR
                    .series().name(), ConstantUtils.SOME_INTERNAL_ERROR);
        }
    }





}
