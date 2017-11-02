package com.miao.car.base.common.base;

/**
 * Created by turbo on 2017/3/14.
 */
public class ConstantsMsg {

    /**
     * 每页显示的大小数量
     */
    public static final Integer PAGE_SIZE = 10;
    /**
     * 添加成功
     */
    public static final String ADD_SUCCESS = "添加数据成功";

    public static final int INTEREST_MONTH_INTERVAL=30;  //定期的派息周期

    /**
     *  Finance classes combined
     */
    public static final String FINANCE_CATEGORY="FC";  //理财类产品 只包括DA / CA

    public static final String COMBINED_CATEGORY="CC";  //组合类产品 只包括基金组合 和 固收组合

    /**
     * 添加失败
     */
    public static final String ADD_FAIL = "添加数据失败";

    public static final String REQUEST_PATH_ERROR = "请求路径错误";

    public static final String PAGE_NUMBER_ERROR = "页码格式错误";

    public static final String CONSTANTS_TYPE_CODE_ERROR = "常量类型入参错误";

    public static final String CONSTANTS_TYPE_MATHCH_ERROR = "未找到对应的常量配置";

    public static final String USER_ALREADY_EXISTS="登陆名已经存在";

    public static final String LOGIN_NAME_EMPTY="用户名为空";

    public static final String LOGIN_PASS_EMPTY="密码为空";

    public static final String USERLOGINANAME_NOT_EXISTS="登陆名不存在";

    public static final String USERLOGINANAME_PASS_ERROR="密码错误";

    public static final String LOGIN_FAIL = "登陆失败";

    public static final String LOGIN_SUCCESS = "登陆成功";

    public static final String APPID_EMPTY = "获取服务号失败";

    public static final String PARAMETER_CHANELID_EMPTY = "渠道编码不能为空";

    public static final String API_VERSION_EMPTY = "接口版本号为空";

    public static final String SYSUSER_UN_LOGIN = "系统管理员未登陆";

    public static final String LOGOUT_ERROR="注销失败";

    public static final String DELETE_IDS_ERROR="未获取到要删除的数据";

    public static final String DELETE_DEPT_ERROR="部门下有员工不能删除";

    public static final String DELETE_DATA_ERROR="您没有权限删除该数据";

    public static final String DELETE_PART_DATA_ERROR="部分数据您没有权限删除";

    public static final String GET_DATA_IDERROR="获取数据异常";

    public static final String PARAMETER_ERROR="参数错误";

    public static final String UPDATE_DATA_ERROR="修改数据有异常";

    public static final String UPDATE_DATA_SUCCESS="修改数据成功";

    public  static  final  String  SYSUSER_FULLNAME_EMPTY="系统用户姓名为空";

    public  static  final  String  COMPANY_NAME_EMPTY="公司名称为空";

    public  static  final  String  COMPANY_SHORETNAME_EMPTY="公司简称为空";


    public  static  final  String  OPENACCOUNT_COMPANY_ERROR="开户时公司信息注册失败";

    public  static  final  Long  OPENACCOUNT_DEFAULTDEPT_ID=0L;  //开户的时候 数据的初始化，默认的部门ID

    public  static  final  Long  OPENACCOUNT_DEFAULTROLE_ID=0L;   //开户的时候 数据的初始化，默认的角色ID

    public  static  final  String  OPENACCOUNT_DEFAULTDEPT_NAME="后台管理";

    public  static  final  String  OPENACCOUNT_DEPT_ERROR="开户时获取部门失败";

    public  static  final  String  OPENACCOUNT_SYSUSER_ERROR="开户时添加管理员失败";

    public  static  final  String  OPENACCOUNT_AUTH_ERROR="开户时权限管理失败";

    public  static  final  String  AUTH_ID_EMPTY="权限ID不能为空";

    public  static  final  String  FUNDS_CODE_EMPTY="请选中需要比较的基金项目";

    public  static  final  String  BENCHMARK_TYPE_EMPTY="业绩基准类型不能为空";

    public  static  final  String  FUNDS_TYPE_EMPTY="比较数据类型不能为空";

    public  static  final  String SYS_CONST_CODE_KYC_Q_C = "kyc_question_category";

    public  static final   String ASSET_STATUS_ORDER="300";   //申购成功的资产单

    public  static final   String ASSET_STATUS_REDEEM="400";   //赎回成功的资产单


}
