package com.roker.template.common.enums;

/**
 * 异常枚举
 */
public enum ExceptionEnum {

    UNKNOWN_EXCEPTION(40000,"未知异常"),
    NULL_POINTER_EXCEPTION(40001,"空指针异常"),
    ARGUMENT_BIND_EXCEPTION(40002,"参数绑定异常"),
    ARGUMENT_VALIDATED_EXCEPTION(40003,"参数校验异常："),
    REQ_METHOD_NOT_SUPPORT(40004,"请求方式不支持"),
    ARGUMENT_TYPE_MISMATCH(40005,"参数类型不匹配"),
    FORMAT_ERROR(40006,"参数格式不匹配");

    private int code;
    private String desc;
    ExceptionEnum(int code, String desc){
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
