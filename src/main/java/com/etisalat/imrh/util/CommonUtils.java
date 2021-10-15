package com.etisalat.imrh.util;

import com.etisalat.imrh.dto.GenericResponseDto;
import java.util.*;

public class CommonUtils {


    public static boolean isNull(Object str) {
        if (str == null) {
            return true;
        }
        return false;
    }

    public static boolean isNull(Long str) {
        if (str == null) {
            return true;
        }
        return false;
    }

    public static boolean isNull(String str) {
        if (str == null) {
            return true;
        }
        return false;
    }

    public static boolean isNull(Boolean str) {
        if (str == null) {
            return true;
        }
        return false;
    }

    public static boolean isNull(Double str) {
        if (str == null) {
            return true;
        }
        return false;
    }

    public static boolean isNull(Date dt) {
        if (dt == null) {
            return true;
        } else if (String.valueOf(dt) == null) {
            return true;
        } else if (String.valueOf(dt).trim().length() <= 0) {
            return true;
        }
        return false;
    }

    public static <T> GenericResponseDto<T> getResponseWithMessageOnly(String message) {
        GenericResponseDto<Object> response = new GenericResponseDto<>();
        response.setMessage(message);
        return (GenericResponseDto<T>) response;
    }

    public static <T> GenericResponseDto<T> getResponseWithStatusAndMessageOnly(String status, String message) {
        GenericResponseDto<Object> response = new GenericResponseDto<>();
        response.setStatus(status);
        response.setMessage(message);
        return (GenericResponseDto<T>) response;
    }

    public static <T> GenericResponseDto<T> getResponseWithData(Object data, String status, String errorCode) {
        GenericResponseDto<Object> response = new GenericResponseDto<>();
        response.setData(data);
        response.setErrorCode(errorCode);
        response.setStatus(status);
        return  (GenericResponseDto<T>) response;
    }

    public static <T> GenericResponseDto<T> getResponseWithData(Object data, String status,
        String errorCode, String message) {
        GenericResponseDto<Object> response = new GenericResponseDto<>();
        response.setData(data);
        response.setErrorCode(errorCode);
        response.setStatus(status);
        response.setMessage(message);
        return (GenericResponseDto<T>) response;
    }

}
