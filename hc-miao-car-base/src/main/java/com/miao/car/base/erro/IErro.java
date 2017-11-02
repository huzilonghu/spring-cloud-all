package com.miao.car.base.erro;


import com.miao.car.base.entity.ErrorEntity;

/**
 * 重复使用的提示信息.定义在此处,不常用的 实时创建
 */
public interface IErro {

    String EXCEPTION = "EXCEPTION";

    String INVALIDE = "PARAM INVALIDE";

    String  UNAUTHORIZED="UNAUTHORIZED EXCEPTION";

    ErrorEntity SUCCESS = new ErrorEntity("SUCCESS", "请求成功");

    ErrorEntity SUCCESS_INSERT = new ErrorEntity("INSERT SUCCESS", "添加成功");

    ErrorEntity SUCCESS_UPDATE = new ErrorEntity("UPDATE SUCCESS", "修改成功");

    ErrorEntity SUCCESS_REGISTER = new ErrorEntity("SUCCESS", "注册成功");

    ErrorEntity SUCCESS_LOGIN = new ErrorEntity("SUCCESS_LOGIN", "登录成功");

    /////////////////////////////////////////////////////////////////////////////////////////

    ErrorEntity ERRO = new ErrorEntity("ERRO", "获取数据失败");

    ErrorEntity ERRO_INSERT = new ErrorEntity("INSERT ERRO", "增加数据失败");

    ErrorEntity ERRO_UPDATE = new ErrorEntity("UPDATE ERRO", "修改数据失败");

    ErrorEntity ERRO_DELETE = new ErrorEntity("DELETE ERRO", "删除数据失败");

    ErrorEntity ERRO_LOGIN = new ErrorEntity("UN_LOGIN", "登录失败");

    ErrorEntity ERRO_PARAM_INVALIDE = new ErrorEntity("PARAM INVALIDE", "提交参数有误");

    ErrorEntity ERRO_PARAM_PAGE = new ErrorEntity(IErro.INVALIDE, "页码不能小于1");

    ErrorEntity UN_LOGIN = new ErrorEntity("UN_LOGIN", "未登录");


}
