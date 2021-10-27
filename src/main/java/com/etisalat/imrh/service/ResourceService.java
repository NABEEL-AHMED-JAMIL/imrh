package com.etisalat.imrh.service;

import com.etisalat.imrh.dto.GenericResponseDto;
import org.springframework.web.multipart.MultipartFile;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @author Nabeel Ahmed
 */
public interface ResourceService {

    public GenericResponseDto<Object> uploadFile(MultipartFile file, String folderName) throws IOException;

    public ByteArrayOutputStream downloadImageFile(String fileName);

    public GenericResponseDto<Object> deleteImageFile(String name) throws IOException;

}