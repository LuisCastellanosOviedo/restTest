package com.restesting.restesting.flowManager.stepServices.entity;

import com.mashape.unirest.http.HttpResponse;

import java.util.Map;

public class FlowStep {


    private Map<String,String> headers;
    private String url;
    private String method;
    private String bodyResponse;
    private String bodyRequest;
    private int stepNumer;


    private HttpResponse<String> responseAsString;


    public FlowStep(Map<String, String> headers, String url, String method, String bodyResponse) {
        this.headers = headers;
        this.url = url;
        this.method = method;
        this.bodyResponse = bodyResponse;
    }


    public FlowStep() {
    }


    public int getStepNumer() {
        return stepNumer;
    }

    public void setStepNumer(int stepNumer) {
        this.stepNumer = stepNumer;
    }

    public String getBodyRequest() {
        return bodyRequest;
    }

    public void setBodyRequest(String bodyRequest) {
        this.bodyRequest = bodyRequest;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getBodyResponse() {
        return bodyResponse;
    }

    public void setBodyResponse(String bodyResponse) {
        this.bodyResponse = bodyResponse;
    }

    public HttpResponse<String> getResponseAsString() {
        return responseAsString;
    }

    public void setResponseAsString(HttpResponse<String> responseAsString) {
        this.responseAsString = responseAsString;
    }
}
