package com.roker.template.common.enums;

/**
 * 异常枚举
 */
public enum ExceptionEnum {

    NULL_POINTER_EXCEPTION(40001,"空指针异常"),
    ARGUMENT_BIND_EXCEPTION(40002,"参数绑定异常"),
    ARGUMENT_VALIDATED_EXCEPTION(40003,"参数校验异常：");

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
