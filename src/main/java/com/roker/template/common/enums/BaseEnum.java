package com.roker.template.common.enums;

/**
 * @Author Roker
 * @Date 2020/08/14 14:24
 * @Title BaseEnum
 * @Description 基础Enum
 */

public enum  BaseEnum {
    DJKASDF(2,"ddd"),
    SAF(2,"ddd");

    public int code;
    private String desc;
    BaseEnum(int code, String desc){
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
