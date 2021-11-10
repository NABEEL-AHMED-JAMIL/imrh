package com.etisalat.imrh.controller;

import com.etisalat.imrh.dto.GenericResponseDto;
import com.etisalat.imrh.service.ResourceService;
import com.etisalat.imrh.util.CommonUtils;
import com.etisalat.imrh.util.ExceptionUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Nabeel Ahmed
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/imrh/resource")
public class ResourceController {

    public Logger logger = LogManager.getLogger(ResourceController.class);

    @Autowired
    private ResourceService resourceService;

    // working
    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public GenericResponseDto<Object> uploadFile(@RequestParam(name = "file") MultipartFile file,
        @RequestParam(name = "folderName") String folderName) {
        try {
            logger.info("Request uploadFile fileName " + file.getOriginalFilename());
            return this.resourceService.uploadFile(file, folderName);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while uploadFile", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR.series().name(),
                "Some Internal error accrue contact with support team.");
        }
    }

    @RequestMapping(value = "/download/image/file-name", method = RequestMethod.GET)
    public ResponseEntity<?> downloadImageFile(@RequestParam(name = "fileName", required = true) String fileName) {
        try {
            logger.info("Request downloadImageFile fileName " + fileName);
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Disposition", "attachment; filename=" + fileName);
            return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(new ByteArrayResource(this.resourceService.downloadImageFile(fileName).toByteArray()));
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while downloadImageFile", ExceptionUtil.getRootCause(ex));
            return new ResponseEntity<>(CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR.series().name(),
                    "Some Internal error accrue contact with support team."), HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/delete/image/file-name", method = RequestMethod.POST)
    public GenericResponseDto<Object> deleteImageFile(@RequestParam(name = "fileName", required = true) String fileName) {
        try {
            logger.info("Request deleteImageFile fileName " + fileName);
            return this.resourceService.deleteImageFile(fileName);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while deleteImageFile", ExceptionUtil.getRootCause(ex));
            return CommonUtils.getResponseWithStatusAndMessageOnly(HttpStatus.INTERNAL_SERVER_ERROR.series().name(),
                    "Some Internal error accrue contact with support team.");
        }
    }

}