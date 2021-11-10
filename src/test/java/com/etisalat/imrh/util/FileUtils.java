package com.etisalat.imrh.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class FileUtils {

    private static final String BASE_PATH = "src/test/resources/";

    public static <T> String readFileIntoJson(Class<T> type, String fileName) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(objectMapper.readValue(new File(BASE_PATH + fileName),  type));

    }

    public static <T> T readObjectFromJsonFile(Class<T> type, String fileName) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File(BASE_PATH + fileName), type);

    }
}
