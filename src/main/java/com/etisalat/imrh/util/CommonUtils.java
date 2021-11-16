package com.etisalat.imrh.util;

import com.etisalat.imrh.dto.GenericResponseDto;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Nabeel Ahmed
 */
public class CommonUtils {

    private final static String phoneRegex = "^((\\+92)|(0092))-{0,1}\\d{3}-{0,1}\\d{7}$|^\\d{11}$|^\\d{4}-\\d{7}$";
    private final static Pattern pattern;

    static {
        pattern = Pattern.compile(phoneRegex);
    }

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
        if (str == null || str.length() == 0) {
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

    public static boolean isValidMsisdn(String msisdn) {
        Matcher matcher = pattern.matcher(msisdn);
        return matcher.matches();
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

    public static <T> GenericResponseDto<T> getResponseWithData(Object data, String status, String message) {
        GenericResponseDto<Object> response = new GenericResponseDto<>();
        response.setData(data);
        response.setStatus(status);
        response.setMessage(message);
        return (GenericResponseDto<T>) response;
    }

}
