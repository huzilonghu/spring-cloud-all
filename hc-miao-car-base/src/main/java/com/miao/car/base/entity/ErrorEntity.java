package com.miao.car.base.entity;

public class ErrorEntity implements IEntity {
    /**
     * 结果状态
     */
//    private int status;

    /**
     * 执行结束时间
     */
//    private Long currentTime = System.currentTimeMillis();

//    private int httpStuta = HttpStatus.HTTP_400;

    /**
     * 状态编码
     */
    private String statusCode;

    /**
     * 结果的说明消息
     */
    private String message = "";


    public ErrorEntity() {

    }

//    public ErrorEntity(ErrorEntity entity) {
//        this.statusCode = entity.statusCode;
//        this.message = entity.message;
//    }

    public ErrorEntity(String statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public void addMessage(String message) {
        this.message = this.message.concat(" ").concat(message);
    }


    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
