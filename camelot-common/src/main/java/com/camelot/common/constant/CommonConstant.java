package com.camelot.common.constant;


import com.camelot.common.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonConstant {

    /**
     * 正常状态
     */
    public static final Integer STATUS_NORMAL = 0;

    /**
     * 禁用状态
     */
    public static final Integer STATUS_DISABLE = -1;

    /**
     * 删除标志
     */
    public static final Integer DEL_FLAG_1 = 1;

    /**
     * 未删除
     */
    public static final Integer DEL_FLAG_0 = 0;

    /**
     * 系统日志类型： 登录
     */
    public static final int LOG_TYPE_1 = 1;

    /**
     * 系统日志类型： 操作
     */
    public static final int LOG_TYPE_2 = 2;

    /**
     * 操作日志类型： 查询
     */
    public static final int OPERATE_TYPE_1 = 1;

    /**
     * 操作日志类型： 添加
     */
    public static final int OPERATE_TYPE_2 = 2;

    /**
     * 操作日志类型： 更新
     */
    public static final int OPERATE_TYPE_3 = 3;

    /**
     * 操作日志类型： 删除
     */
    public static final int OPERATE_TYPE_4 = 4;

    /**
     * 操作日志类型： 倒入
     */
    public static final int OPERATE_TYPE_5 = 5;

    /**
     * 操作日志类型： 导出
     */
    public static final int OPERATE_TYPE_6 = 6;


    /**
     * {@code 500 Server Error} (HTTP/1.0 - RFC 1945)
     */
    public static final Integer SC_INTERNAL_SERVER_ERROR_500 = 500;
    /**
     * {@code 200 OK} (HTTP/1.0 - RFC 1945)
     */
    public static final Integer SC_OK_200 = 200;
    /**
     * 访问权限认证未通过 510
     */
    public static final Integer SC_JEECG_NO_AUTHZ = 403;
    /**
     * 计提无数据
     */
    public static final Integer NOT_DATA_ACCRUAL = 100604;
    /**
     * 计提参数为空
     */
    public static final Integer NOT_DATA_PARAM = 100605;

    /**
     * 保存失败
     */
    public static final Integer SAVE_ERROR = 100606;


    /**
     * 登录用户Shiro权限缓存KEY前缀
     */
    public static String PREFIX_USER_SHIRO_CACHE = "shiro:cache:org.jeecg.config.shiro.ShiroRealm.authorizationCache:";
    /**
     * 登录用户Token令牌缓存KEY前缀
     */
    public static final String PREFIX_USER_TOKEN = "prefix_user_token_";
    /**
     * Token缓存时间：3600秒即一小时
     */
    public static final int TOKEN_EXPIRE_TIME = 3600;


    /**
     * 0：一级菜单
     */
    public static final Integer MENU_TYPE_0 = 0;
    /**
     * 1：子菜单
     */
    public static final Integer MENU_TYPE_1 = 1;
    /**
     * 2：按钮权限
     */
    public static final Integer MENU_TYPE_2 = 2;

    /**
     * 通告对象类型（USER:指定用户，ALL:全体用户）
     */
    public static final String MSG_TYPE_UESR = "USER";
    public static final String MSG_TYPE_ALL = "ALL";

    /**
     * 发布状态（0未发布，1已发布，2已撤销）
     */
    public static final String NO_SEND = "0";
    public static final String HAS_SEND = "1";
    public static final String HAS_CANCLE = "2";

    /**
     * 阅读状态（0未读，1已读）
     */
    public static final String HAS_READ_FLAG = "1";
    public static final String NO_READ_FLAG = "0";

    /**
     * 优先级（L低，M中，H高）
     */
    public static final String PRIORITY_L = "L";
    public static final String PRIORITY_M = "M";
    public static final String PRIORITY_H = "H";

    /**
     * 短信模板方式  0 .登录模板、1.注册模板、2.忘记密码模板
     */
    public static final String SMS_TPL_TYPE_0 = "0";
    public static final String SMS_TPL_TYPE_1 = "1";
    public static final String SMS_TPL_TYPE_2 = "2";

    /**
     * 状态(0无效1有效)
     */
    public static final String STATUS_0 = "0";
    public static final String STATUS_1 = "1";

    /**
     * 状态(0未修改过1修改过)
     */
    public static final Integer UPDATED_0 = 0;
    public static final Integer UPDATED_1 = 1;

    /**
     * 同步工作流引擎1同步0不同步
     */
    public static final Integer ACT_SYNC_1 = 1;
    public static final Integer ACT_SYNC_0 = 0;

    /**
     * 消息类型1:通知公告2:系统消息
     */
    public static final String MSG_CATEGORY_1 = "1";
    public static final String MSG_CATEGORY_2 = "2";

    /**
     * 是否配置菜单的数据权限 1是0否
     */
    public static final Integer RULE_FLAG_0 = 0;
    public static final Integer RULE_FLAG_1 = 1;

    /**
     * 是否用户已被冻结 1正常(解冻) 2冻结
     */
    public static final Integer USER_UNFREEZE = 1;
    public static final Integer USER_FREEZE = 2;

    /**
     * 字典翻译文本后缀
     */
    public static final String DICT_TEXT_SUFFIX = "_dictText";


    /**
     * online参数值设置（是：Y, 否：N）
     */
    public static final String ONLINE_PARAM_VAL_IS_TURE = "Y";
    public static final String ONLINE_PARAM_VAL_IS_FALSE = "N";

    /**
     * 文件上传类型（本地：local，Minio：minio，阿里云：alioss）
     */
    public static final String UPLOAD_TYPE_LOCAL = "local";
    public static final String UPLOAD_TYPE_MINIO = "minio";
    public static final String UPLOAD_TYPE_OSS = "alioss";

    /**
     * 文档上传自定义桶名称
     */
    public static final String UPLOAD_CUSTOM_BUCKET = "eoafile";
    /**
     * 文档上传自定义路径
     */
    public static final String UPLOAD_CUSTOM_PATH = "eoafile";
    /**
     * 文件外链接有效天数
     */
    public static final Integer UPLOAD_EFFECTIVE_DAYS = 1;

    /**
     * 员工身份 （1:普通员工  2:上级）
     */
    public static final Integer USER_IDENTITY_1 = 1;
    public static final Integer USER_IDENTITY_2 = 2;


    /**
     * 公文文档上传自定义路径
     */
    public static final String UPLOAD_CUSTOM_PATH_OFFICIAL = "officialdoc";
    /**
     * 公文文档下载自定义路径
     */
    public static final String DOWNLOAD_CUSTOM_PATH_OFFICIAL = "officaldown";


    public final static String X_ACCESS_TOKEN = "X-Access-Token";
    public final static String X_SIGN = "X-Sign";
    public final static String X_TIMESTAMP = "X-TIMESTAMP";


    /**
     * 多租户 请求头
     */
    public final static String TENANT_ID = "tenant-id";

    /**
     * 微服务读取配置文件属性 服务地址
     */
    public final static String CLOUD_SERVER_KEY = "spring.cloud.nacos.discovery.server-addr";

    /**
     * 第三方登录 验证密码/创建用户 都需要设置一个操作码 防止被恶意调用
     */
    public final static String THIRD_LOGIN_CODE = "third_login_code";

    /**
     * 币种汇率上传标示
     */
    public final static String EXCHANGE_RATE_IMPORT = "exchange_rate_import";

    /**
     * 币种汇率上传标示
     */
    public final static String TAG_MEDIA_IMPORT = "tag_media_import";

    /**
     * 币种汇率上传标示
     */
    public final static String REGION_MEDIA_IMPORT = "region_media_import";

    /**
     * 币种汇率上传标示
     */
    public final static String OFFLINE_IMPORT = "offline_import";

    /**
     * 币种汇率上传标示
     */
    public final static String MIADS_IMPORT = "miads_import";

    /**
     * 计提一级DSP配置
     */
    public final static String DSP_LEVEL1_EFFECT = "效果";

    public final static String DSP_LEVEL1_ONLINE = "online";

    public final static String DSP_LEVEL1_OFFLINE = "offline";

    /**
     * 广告主账户类型
     */
    public final static String ACCOUNT_TYPE_ADUSER = "广告主";

    public final static String ACCOUNT_TYPE_AGENCY = "AA";

    public final static String ACCOUNT_TYPE_ADUSER_VIEW = "aduserAccount";

    public final static String ACCOUNT_TYPE_AGENCY_VIEW = "agencyAccount";

    /**
     * 计提开始标识
     */
    public final static String ACCRUAL_START = "accrual_start";
    /**
     * 程序化计提查询条件 原始表涵盖字段                                 [0]一级DSP    [1]广告主账户类型     [2]日期   [3]二级DSP      [4]广告主账户       [5]代理账户         [6]包名         [7]国家   [8]媒体         [9]页面查询用账号ID
     */
    public final static String[] ACCRUAL_MIADS_TITLE = new String[]{"dsp_level1", "aduser_account_type", "dt", "dsp_level2", "aduser_account", "agency_account", "package_name", "region", "media_type", "account_id"};

    /**
     * 程序化计提查询条件 原始表涵盖字段                                 [0]一级DSP       [1]账户ID  [2]日期   [3]计提人      [4]新媒体       [5]新国家     [6]是否修改
     */
    public final static String[] ACCRUAL_RECORD_TITLE = new String[]{"dsp_level1", "dt", "accrual_no", "accrual_by", "new_media", "new_region", "up_flag"};


    /**
     * 程序化计提字段
     */
    public final static String ACCRUAL_NO = "accrual_no";

    public final static String ACCRUAL_BY = "accrual_by";

    public final static String ACCRUAL_AM = "am";

    public final static String DSP_LEVEL1 = "dsp_level1";

    public final static String ADUSER_ACCOUNT_TYPE = "aduser_account_type";

    public final static String DT = "dt";

    public final static String DSP_LEVEL2 = "dsp_level2";

    public final static String ADUSER_ACCOUNT = "aduser_account";

    public final static String ACCOUNT_ID = "account_id";

    public final static String AGENCY_ACCOUNT = "agency_account";

    public final static String PACKAGE_NAME = "package_name";

    public final static String REGION = "region";

    public final static String NEW_REGION = "new_region";

    public final static String MEDIA_TYPE = "media_type";

    public final static String NEW_MEDIA = "new_media";

    public final static String DSP_ACTIVE = "dsp_active";

    public final static String DSP_FEE = "dsp_fee";

    public final static String TAG_ID = "tag_id";

    public final static String UP_FLAG = "up_flag";

    //效果的二级DSP默认值
    public final static String DSP2_EFFECT_DEFAULT = "xiaomi.dongfeng";


    /**
     * 广告主账号 默认值
     */
    public final static String ADUSER_ACCOUNT_VALUE = "-1";
    /**
     * 代理广告主 默认值
     */
    public final static String AGENCY_ACCOUNT_VALUE = "-1";

    /**
     * 广告主类型 默认值
     */
    public final static String ADUSER_ACCOUNT_TYPE_VALUE = "-1";
    /**
     * miads计提redis wrapper
     */
    public final static String REDIS_KEY_QUERY = "queryWrapper_";

    /**
     * miads计提redis param
     */
    public final static String REDIS_KEY_CONFIG = "queryConfig_";

    /**
     * miads计提第一步
     */
    public final static String REDIS_KEY_MIADS_FIRST = "miadsFirst_";

    /**
     * miads计提redis param
     */
    public final static String REDIS_KEY_MIADS_SAVE = "miadsSave_";

    /**
     * offline计提redis key
     */
    public final static String REDIS_KEY_OFFLINE_SAVE = "offlineSave_";

    /**
     * redis key默认超时时长 单位/s
     */
    public final static Integer REDIS_TIME_OUT = 3600;
    /**
     * redis key 计提配置开关
     */
    public final static String REDIS_KEY_ACCRUAL_SWITCH = "accrualSwitch";
    /**
     * redis key 用户计提配置开关权限
     */
    public final static String REDIS_KEY_ACCRUAL_SWITCH_USER = "accrualSwitchUserList";

    /**
     * redis key 计提配置版本号
     */
    public final static String REDIS_KEY_CONFIG_VERSION = "configVersion";


    /**
     * offline计提-计提目标
     */
    public final static String ACCRUAL_GOAL_REVENUE = "收入";
    public final static String ACCRUAL_GOAL_COST = "成本";
    /**
     * offline 计提，统一默认替换媒体
     */
    // 待确认编号，客户通知只存储数字（已确认，存汉字）
    public static String ACCRUAL_OFFLINE_REPLACE_PUBLISHER = "三⽅媒体-海外联盟业务";

    @Autowired()
    public void setOfflineFixedPublisher(@Value("${accrual.automation.offline.fixed-publisher}") String ACCRUAL_OFFLINE_REPLACE_PUBLISHER) {
        CommonConstant.ACCRUAL_OFFLINE_REPLACE_PUBLISHER = ACCRUAL_OFFLINE_REPLACE_PUBLISHER;
    }

    /**
     * config_region_media 替换类型-国家
     */
    public static final String CONFIG_REPLACE_TYPE_COUNTRY = "国家";
    /**
     * config_region_media 替换前国家-其他
     */
    public static final String CONFIG_COUNTRY_BEFORE_REPLACE_OTHER = "其他的国家编码";

    /**
     * 通用特殊符号
     */
    public final static String SYMBOL_LOW_LINE = "_";

    /**
     * 国家媒体类型 国家
     */
    public final static String CONFIG_TYPE_MEDIA = "媒体";

    /**
     * 国家媒体类型 替换后默认国家
     */
    public final static String CONFIG_OTHER_CODE = "OT";


    /**
     * 自动化计提固定天数计算量
     */
    public static int ACCRUAL_AUTOMATION_FIXED_DAYS;

    @Autowired()
    public void setFixedDays(@Value("${accrual.automation.miads-fixed-days}") int ACCRUAL_AUTOMATION_FIXED_DAYS) {
        CommonConstant.ACCRUAL_AUTOMATION_FIXED_DAYS = ACCRUAL_AUTOMATION_FIXED_DAYS;
    }

    /**
     * offline自动化计提固定天数计算量
     */
    public static int ACCRUAL_AUTOMATION_OFFLINE_FIXED_DAYS;

    @Autowired()
    public void setOfflineFixedDays(@Value("${accrual.automation.offline-fixed-days}") int ACCRUAL_AUTOMATION_OFFLINE_FIXED_DAYS) {
        CommonConstant.ACCRUAL_AUTOMATION_OFFLINE_FIXED_DAYS = DateUtils.getDayByMonth() - ACCRUAL_AUTOMATION_OFFLINE_FIXED_DAYS;
    }

    /**
     * 计提记录查询条件-账户ID
     */
    public static final String MIADS_ACCOUNT_ID = "miads_account_id";

    /**
     * 计提记录查询条件-advertiser
     */
    public static final String ADVERTISER_ID = "advertiser_id";

    /**
     * 计提记录导出标识-miads记录
     */
    public static final String RECORD_EXPORT_MIADS = "MIADS";
    /**
     * 计提记录导出标识-offline成本记录
     */
    public static final String RECORD_EXPORT_OFFLINE_COST = "OFFLINE_COST";
    /**
     * 计提记录导出标识-offline收入记录
     */
    public static final String RECORD_EXPORT_OFFLINE_REVENUE = "OFFLINE_REVENUE";
    /**
     * 微服务之间传递的唯一标识
     */
    public static final String MATE_TRACE_ID = "mate-trace-id";
    /**
     * 日志链路追踪id日志标志
     */
    public static final String LOG_TRACE_ID = "traceId";

}
