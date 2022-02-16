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

    /**
     * Method use to check the object is null or not
     * @param obj
     * @return boolean
     * */
    public static boolean isNull(Object obj) {
        if (obj == null) {
            return true;
        }
        return false;
    }

    /**
     * Method use to check the long is null or not
     * @param lon
     * @return boolean
     * */
    public static boolean isNull(Long lon) {
        if (lon == null) {
            return true;
        }
        return false;
    }

    /**
     * Method use to check the str is null or not
     * @param str
     * @return boolean
     * */
    public static boolean isNull(String str) {
        if (str == null || str.length() == 0) {
            return true;
        }
        return false;
    }

    /**
     * Method use to check the boolean is null or not
     * @param bool
     * @return boolean
     * */
    public static boolean isNull(Boolean bool) {
        if (bool == null) {
            return true;
        }
        return false;
    }

    /**
     * Method use to check the double is null or not
     * @param doub
     * @return boolean
     * */
    public static boolean isNull(Double doub) {
        if (doub == null) {
            return true;
        }
        return false;
    }

    /**
     * Method use to check is date is null or not
     * @param dt
     * @return boolean
     * */
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

    /**
     * Method use to check is valid msisdn or not
     * @param msisdn
     * @return boolean
     * */
    public static boolean isValidMsisdn(String msisdn) {
        Matcher matcher = pattern.matcher(msisdn);
        return matcher.matches();
    }

    /**
     * Method use to fill response only with message
     * @param message
     * @return T
     * */
    public static <T> GenericResponseDto<T> getResponseWithMessageOnly(String message) {
        GenericResponseDto<Object> response = new GenericResponseDto<>();
        response.setMessage(message);
        return (GenericResponseDto<T>) response;
    }

    /**
     * Method use to fill response with status, message
     * @param status
     * @param message
     * @return T
     * */
    public static <T> GenericResponseDto<T> getResponseWithStatusAndMessageOnly(String status, String message) {
        GenericResponseDto<Object> response = new GenericResponseDto<>();
        response.setStatus(status);
        response.setMessage(message);
        return (GenericResponseDto<T>) response;
    }

    /**
     * Method use to fill response with data
     * @param data
     * @param status
     * @param message
     * @return T
     * */
    public static <T> GenericResponseDto<T> getResponseWithData(Object data, String status, String message) {
        GenericResponseDto<Object> response = new GenericResponseDto<>();
        response.setData(data);
        response.setStatus(status);
        response.setMessage(message);
        return (GenericResponseDto<T>) response;
    }

}
