package com.etisalat.imrh.service.impl;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import com.etisalat.imrh.dto.GenericResponseDto;
import com.etisalat.imrh.service.ResourceService;
import com.etisalat.imrh.util.CommonUtils;
import com.google.cloud.storage.*;
import com.google.firebase.cloud.StorageClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;
import java.util.UUID;

/**
 * @author Nabeel Ahmed
 */
@Service
@Transactional
public class ResourceServiceImpl implements ResourceService {

    public Logger logger = LogManager.getLogger(ResourceServiceImpl.class);

    private String F2 = "%2F";
    @Value("${firebase.bucket-name}")
    private String bucketName;

    @Value("${firebase.image-url}")
    private String resourceAccessUrl;

    @Override
    public GenericResponseDto<Object> uploadFile(MultipartFile file,
        String folderName) throws IOException {
        String fileName = UUID.randomUUID().toString();
        Bucket bucket = StorageClient.getInstance().bucket();
        String fileNameWithFolderPath = String.format("%s/%s", folderName, fileName);
        bucket.create(fileNameWithFolderPath, file.getInputStream(), file.getContentType());
        return CommonUtils.getResponseWithData(String.format(this.resourceAccessUrl, this.bucketName,
            String.format("%s%s%s", folderName, F2, fileName)), HttpStatus.OK.series().name(), "File Store successfully");
    }

    @Override
    public ByteArrayOutputStream downloadImageFile(String fileName) {
        Bucket bucket = StorageClient.getInstance().bucket();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        bucket.get(fileName).downloadTo(out);
        return out;
    }

    @Override
    public GenericResponseDto<Object> deleteImageFile(String fileName) {
        Bucket bucket = StorageClient.getInstance().bucket();
        Blob blob = bucket.get(fileName);
        if (CommonUtils.isNull(blob)) {
            return CommonUtils.getResponseWithStatusAndMessageOnly(
                HttpStatus.BAD_REQUEST.series().name(), "file not found.");
        }
        blob.delete();
        return CommonUtils.getResponseWithData(fileName, HttpStatus.OK.series().name(),
        "File delete successfully");
    }

}