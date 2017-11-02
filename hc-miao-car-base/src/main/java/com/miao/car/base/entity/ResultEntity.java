package com.miao.car.base.entity;



import com.miao.car.base.erro.IErro;

import java.io.Serializable;

import lombok.Data;

@Data
public class ResultEntity<T> implements IEntity, Serializable {

    private String statusCode;

    private String message;

    private T result;

    public ResultEntity setResult(T t) {
        this.result = t;
        return this;
    }

    public ResultEntity() {
        this.message = IErro.SUCCESS.getMessage();
        this.statusCode = IErro.SUCCESS.getStatusCode();
    }

    public ResultEntity(ErrorEntity codeMsg) {
        this.message = codeMsg.getMessage();
        this.statusCode = codeMsg.getStatusCode();
    }

    public ResultEntity(String statusCode,String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public ResultEntity(String message) {
        this.message = message;
        this.statusCode = IErro.SUCCESS.getStatusCode();
    }

    public ResultEntity(T t) {
        this.message = IErro.SUCCESS.getMessage();
        this.statusCode = IErro.SUCCESS.getStatusCode();
        this.result = t;
    }

    public void setErroEntity(ErrorEntity codeMsg) {
        this.message = codeMsg.getMessage();
        this.statusCode = codeMsg.getStatusCode();
    }


}
