package com.spring.LogisticsStatusTrackingWebsite.domain.response;

public class ApiResponse<T> {

    private String status;
    private T data;
    private ErrorResponse error;

    public ApiResponse(String status, T data, ErrorResponse error) {
        this.status = status;
        this.data = data;
        this.error = error;
    }

    public ApiResponse(String status, T data) {
        this.status = status;
        this.data = data;
        this.error = null;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ErrorResponse getError() {
        return error;
    }

    public void setError(ErrorResponse error) {
        this.error = error;
    }
}
