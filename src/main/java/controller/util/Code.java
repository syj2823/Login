package controller.util;

/**
 * 状态码
 */
public class Code {
    // 成功
    public static final Integer SELECT_OK = 2001;
    public static final Integer INSERT_OK = 3001;
    public static final Integer UPDATE_OK = 4001;
    public static final Integer DELETE_OK = 5001;

    // 失败
    public static final Integer SELECT_ERR = 2004;
    public static final Integer INSERT_ERR = 3004;
    public static final Integer UPDATE_ERR = 4004;
    public static final Integer DELETE_ERR = 5004;

    //异常处理
    public static final Integer SYSTEM_ERROR = 6005;               //系统异常
    public static final Integer SYSTEM_TIMEOUT_ERROR = 7005;       //系统超时
    public static final Integer SYSTEM_UNKNOWN_ERROR = 8005;       //未知异常
    public static final Integer BUSINESS_ERROR = 9005;             //业务繁忙

}
