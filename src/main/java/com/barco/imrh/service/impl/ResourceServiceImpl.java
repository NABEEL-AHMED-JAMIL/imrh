package com.barco.imrh.service.impl;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import com.barco.imrh.dto.GenericResponseDto;
import com.barco.imrh.service.ResourceService;
import com.barco.imrh.util.CommonUtils;
import com.google.cloud.storage.*;
import com.google.firebase.cloud.StorageClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.UUID;

/**
 * @author Nabeel Ahmed
 */
@Service
@Transactional
public class ResourceServiceImpl implements ResourceService {

    public Logger logger = LogManager.getLogger(ResourceServiceImpl.class);

    @Value(value = FIRE_BASE_BUCKET_NAME)
    private String bucketName;
    @Value(value = FIRE_BASE_IMAGE_URL)
    private String resourceAccessUrl;

    /**
     * Method use to upload the file to firebase
     * */
    @Override
    public GenericResponseDto<Object> uploadFile(MultipartFile file,
        String folderName) throws IOException {
        String fileName = UUID.randomUUID().toString();
        Bucket bucket = StorageClient.getInstance().bucket();
        String fileNameWithFolderPath = String.format(SS, folderName, fileName);
        bucket.create(fileNameWithFolderPath, file.getInputStream(), file.getContentType());
        return CommonUtils.getResponseWithData(String.format(this.resourceAccessUrl, this.bucketName,
            String.format(SSS, folderName, F2, fileName)), HttpStatus.OK.series().name(), FILE_STORE_SUCCESSFULLY);
    }

    /**
     * Method use to download the file to firebase
     * */
    @Override
    public ByteArrayOutputStream downloadImageFile(String fileName) {
        Bucket bucket = StorageClient.getInstance().bucket();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        bucket.get(fileName).downloadTo(out);
        return out;
    }

    /**
     * Method use to delete the file to firebase
     * */
    @Override
    public GenericResponseDto<Object> deleteImageFile(String fileName) {
        Bucket bucket = StorageClient.getInstance().bucket();
        Blob blob = bucket.get(fileName);
        if (CommonUtils.isNull(blob)) {
            return CommonUtils.getResponseWithStatusAndMessageOnly(
                HttpStatus.BAD_REQUEST.series().name(), FILE_NOTE_FOUND);
        }
        blob.delete();
        return CommonUtils.getResponseWithData(fileName, HttpStatus.OK.series().name(),
                FILE_DELETE_SUCCESSFULLY);
    }

}