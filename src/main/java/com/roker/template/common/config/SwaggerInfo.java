package com.roker.template.common.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author Roker
 * @Date 2020/10/26 15:47
 * @Title SwaggerInfo
 * @Description swagger 配置信息
 */

@Data
@Component
@ConfigurationProperties(prefix = "swagger")
public class SwaggerInfo {
    /**
     * 标题
     */
    private String title;

    /**
     * 简介
     */
    private String description;

    /**
     * 分组名称
     */
    private String groupName;

    /**
     * 版本
     */
    private String version;

    /**
     * 扫描的包路径
     */
    private String basePackage;

    /**
     * 接口作者
     */
    private String author;
}
