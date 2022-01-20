package com.camelot.redis.props;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * redis配置
 *
 * @author pangu
 */
@Getter
@Setter
@ConfigurationProperties(MateRedisProperties.PREFIX)
public class MateRedisProperties {
    /**
     * 前缀
     */
    public static final String PREFIX = "camelot.lettuce.redis";
    /**
     * 是否开启Lettuce
     */
    private Boolean enable = true;
}
