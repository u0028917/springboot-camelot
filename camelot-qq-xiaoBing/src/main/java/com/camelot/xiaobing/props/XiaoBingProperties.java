package com.camelot.xiaobing.props;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(XiaoBingProperties.PREFIX)
public class XiaoBingProperties {
    /**
     * 前缀
     */
    public static final String PREFIX = "camelot.qqxiaobing";

    /**
     * 是否开启
     */
    private Boolean enabled = false;

    /**
     * 通知群名称
     */
    private String groupName;

    private String appId = "cli_a1626ab4ab3bd00b";

    private String appSecret = "a0QZwt87lf8luBNirQjGMfrmpYJxi15J";

    private String tenantUrl = "https://open.feishu.cn/open-apis/auth/v3/tenant_access_token/internal";

    private String chartUrl = "https://open.feishu.cn/open-apis/im/v1/chats";

    private String messageUrl = "https://open.feishu.cn/open-apis/im/v1/messages";

}
