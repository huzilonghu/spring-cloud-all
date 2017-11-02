package com.miao.car.base.erro;


/**
 *  1XX：指示信息。表示请求信息已接收，继续处理。
 *　2XX：成功。表示请求已经被成功接收、理解、接受。
 *　3XX：重定向。要完成请求必须进行更进一步的操作。
 *　4XX：客户端错误。请求有语法错误或请求无法实现。
 *　5XX：服务器端错误。服务器未能实现合法的请求。
 */
public class HttpStatus {

    /**
     * Bad Request
     * 请求无效;一般是参数错误
     * 1、语义有误，当前请求无法被服务器理解。除非进行修改，否则客户端不应该重复提交这个请求。
     * 2、请求参数有误。
     */
    public static final int HTTP_400 = 400;

    /**
     * Unauthorized
     * 未授权;
     */
    public static final int HTTP_401 = 401;

    /**
     * 禁止访问 ;Forbidden
     */
    public static final int HTTP_403 = 403;







}
