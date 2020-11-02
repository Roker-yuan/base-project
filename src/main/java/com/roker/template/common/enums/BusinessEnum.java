package com.roker.template.common.enums;

import java.util.Map;

/**
 * @author roker
 * Date: 2020年11月2日11:00:14
 * Description: 业务状态枚举类
 */
public enum BusinessEnum implements BaseEnum{


    /**
     * User 操作相关枚举
     */
    USER_INFO_ADD_FAIL(500101,"用户信息新增失败"),
    USER_INFO_DELETE_FAIL(500102,"用户信息删除失败");


    private int code;
    private String desc;
    BusinessEnum(int code, String desc){
        this.desc = desc;
        this.code = code;
    }

    public String desc() {
        return desc;
    }

    public Integer code() {
        return code;
    }

    public Map respMessage(){
        return BaseEnum.enum2Map(this.code,this.desc);
    }


}
