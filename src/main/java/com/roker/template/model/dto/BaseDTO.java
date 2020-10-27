package com.roker.template.model.dto;

/**
 * @Author Roker
 * @Date 2020/10/26 16:29
 * @Title BaseDTO
 * @Description 基础 DTO
 */

public abstract class BaseDTO<T> {

    /**
     * 通过 DTO 获取具体实体类实例
     * @return T
     */
    public abstract T buildEntity();
}
