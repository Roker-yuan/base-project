package com.roker.template.model.vo;

/**
 * @Author Roker
 * @Date 2020/10/26 16:29
 * @Title BaseDTO
 * @Description 基础 DTO
 */

public abstract class BaseVO<E,T> {

    /**
     * 通过 DTO 获取具体实体类实例
     * @return T
     */
    public abstract T buildVO(E t);
}
