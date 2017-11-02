package com.miao.car.base.exception;

import com.miao.car.base.entity.ErrorEntity;

import org.springframework.http.HttpStatus;

public class RestfulException extends RuntimeException {

    private HttpStatus status = HttpStatus.BAD_REQUEST;

    private final ErrorEntity entity;

    public ErrorEntity getEntity() {
        return entity;
    }

    public RestfulException(HttpStatus status,ErrorEntity entity) {
        this.status = status;
        this.entity = entity;
    }

    public RestfulException() {
        this.entity = null;
    }

    public RestfulException(ErrorEntity entity) {
        this.entity = entity;
    }

    public RestfulException(HttpStatus status,String statusCode, String message) {
        this.status = status;
        this.entity = new ErrorEntity(statusCode, message);
    }

    public RestfulException(String statusCode, String message) {
        this.entity = new ErrorEntity(statusCode, message);
    }

    public RestfulException(String message) {
        this.entity = new ErrorEntity("ERRO", message);
    }


    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}
