package com.camelot.common.constant;

/**
 * 后期上国际化需要干掉
 */
public interface CommonMsg {

    public final static String TOKEN_IS_INVALID_MSG = "Token失效，请重新登录!";

    public final static String IMPORT_DATA_SUCCESS = "文件导入成功！数据行数：%s";

    public final static String AUTOMATION_SAVE_SUCCESS = "保存成功！";

    public final static String AUTOMATION_SAVE_ERROR = "保存失败！";

    public final static String IMPORT_DATA_ERROR_EMPTY = "导入失败！";

    public final static String EXPORT_DATA_ERROR = "导出失败！";

    public final static String NOT_IN_DATE = "计提月份不在当前月！";

    public final static String UNKNOWN_TYPE_DSP = "未知类型DSP的数据";

    public final static String NOT_DATA_ACCRUAL_BY = "当前查询的计提人未进行计提配置";

    public final static String NOT_DATA_CURRENT_PARAM = "该查询条件无数据";

    public final static String NOT_PARAM = "必选条件不能为空";

    public final static String ERROR_DATA_AMOUNT = "金额格式有误";

    public final static String ERROR_DATA_PARAM = "数据参数有误";

    public final static String NO_CONFIG_REPLACE_TYPE_COUNTRY = "国家配置不存在";

    public final static String NO_CONFIG_EXCHANGE_RATE = "汇率配置不存在";

    public final static String NO_CONFIG_EXCHANGE_RATE_CURRENCY = "汇率配置币种不存在";

    public final static String NO_OFFLINE_SOURCE_DATA = "offline计提原数据未查到";

    public final static String NO_OFFLINE_CONFIG_DATA = "offline计提配置信息未查到";

    public final static String SC_JEECG_NO_AUTHZ = "权限认证未通过";

    public final static String CONFIG_ACCRUAL_CONFIG_OFF = "计提配置—配置上传开关未开启";

    public final static String CONFIG_ACCRUAL_OFF = "计提开关未开启";

    public final static String NO_RECORD_OFFLINE_CONFIG_AM = "Offline计提计提查询/导出：AM条件查询配置数据为空";

    public final static String NO_RECORD_MIADS_CONFIG_AM = "Miads计提计提查询/导出：AM条件查询配置数据为空";

    public final static String NO_RECORD_MIADS_CONFIG_ACCOUNT_ID = "Miads计提计提查询/导出：账户ID条件查询配置数据为空";

    public final static String NO_RECORD_MIADS_CONFIG_DSP_LEVEL2 = "Miads计提计提查询/导出：二级DSP条件查询配置数据为空";

    public final static String RECORD_MIADS_CONFIG_EMPTY= "Miads计提计提查询/导出：组合条件查询数据为空";

}
