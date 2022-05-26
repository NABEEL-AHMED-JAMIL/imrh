package com.barco.imrh.service;

import com.barco.imrh.dto.GenericResponseDto;
import org.springframework.web.multipart.MultipartFile;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @author Nabeel Ahmed
 */
public interface ResourceService {

    public static final String F2 = "%2F";
    public static final String SS = "%s/%s";
    public static final String SSS = "%s%s%s";
    public static final String FIRE_BASE_BUCKET_NAME = "${firebase.bucket-name}";
    public static final String FIRE_BASE_IMAGE_URL = "${firebase.image-url}";
    public static final String FILE_STORE_SUCCESSFULLY = "File Store successfully";
    public static final String FILE_NOTE_FOUND = "file not found.";
    public static final String FILE_DELETE_SUCCESSFULLY = "File delete successfully";

    public GenericResponseDto<Object> uploadFile(MultipartFile file, String folderName) throws IOException;

    public ByteArrayOutputStream downloadImageFile(String fileName);

    public GenericResponseDto<Object> deleteImageFile(String name) throws IOException;

}