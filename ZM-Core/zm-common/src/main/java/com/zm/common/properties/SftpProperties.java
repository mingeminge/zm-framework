package com.zm.common.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * ==================================
 *
 * @author yizuomin
 * @description:
 * @date 2020/4/26 10:14
 * ==================================
 **/
@Data
@Component
@ConfigurationProperties(ignoreInvalidFields = false, prefix = "sftp")
public class SftpProperties {
    private String host;

    private Integer port;

    private String protocol;

    private String username;

    private String password;

    private String root;

    private String privateKey;

    private String passphrase;

    private String sessionStrictHostKeyChecking;

    private Integer sessionConnectTimeout;

    private Integer channelConnectedTimeout;
}
