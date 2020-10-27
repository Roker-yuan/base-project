package com.roker.template.common.enums;

/**
 * 详细编号HttpEnum
 */
public enum HttpEnum {

    /**
     * 请求处理正常
     */
    OK_200(200, "请求成功"),

    /**
     * 请求处理正常
     */
    CREATED_201(201, "创建成功"),


    /**
     * 请求处理异常，请稍后再试
     */
    ERROR_400(400, "非法请求"),

    /**
     * 访问内容不存在
     */
    NotFound_400(404, "访问内容不存在"),

    /**
     * 系统内部错误
     */
    ERROR_500(500, "系统内部错误"),

    /**
     * 参数校验失败
     */
    ERROR_600(600, "参数校验失败");


    private int code;
    private String desc;
    HttpEnum(int code, String desc){
        this.desc = desc;
        this.code = code;
    }

    public String desc() {
        return desc;
    }

    public int code() {
        return code;
    }


}

