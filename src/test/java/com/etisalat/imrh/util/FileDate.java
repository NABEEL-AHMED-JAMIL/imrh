package com.etisalat.imrh.util;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;

/**
 * @author Nabeel Ahmed
 */
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FileDate<Request, Response> {

    private Request request;
    private GenericResponse<Response> response;

    public FileDate() {}

    public Request getRequest() {
        return request;
    }
    public void setRequest(Request request) {
        this.request = request;
    }

    public GenericResponse<Response> getResponse() {
        return response;
    }
    public void setResponse(GenericResponse<Response> response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
