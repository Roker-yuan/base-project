package com.roker.template.common.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Roker
 * @Date 2020/08/14 14:24
 * @Title BaseEnum
 * @Description 基础Enum接口
 */

public interface  BaseEnum {
    /**
     * 获取枚举标识
     *
     * @return
     */
    Integer code();

    /**
     * 获取枚举描述
     *
     * @return
     */
    String desc();

    /**
     * 通过枚举类型和code值获取对应的枚举类型
     *
     * @param enumType
     * @param code
     * @param <T>
     * @return
     */
    static <T extends BaseEnum> T valueOf(Class<? extends BaseEnum> enumType, Integer code) {
        if (enumType == null || code == null) {
            return null;
        }
        T[] enumConstants = (T[]) enumType.getEnumConstants();
        if (enumConstants == null) {
            return null;
        }
        for (T enumConstant : enumConstants) {
            int enumCode = enumConstant.code();
            if (code.equals(enumCode)) {
                return enumConstant;
            }
        }
        return null;
    }

    /**
     * 将enum转换为list
     *
     * @param enumType
     * @param <T>
     * @return
     */
    static <T extends BaseEnum> List<Map<String, Object>> enum2List(Class<? extends BaseEnum> enumType) {
        if (enumType == null) {
            return null;
        }
        T[] enumConstants = (T[]) enumType.getEnumConstants();
        if (enumConstants == null) {
            return null;
        }
        ArrayList<Map<String, Object>> results = new ArrayList<>();
        for (T bean : enumConstants) {
            String desc = bean.desc();
            Integer code = bean.code();
            HashMap<String, Object> map = new HashMap<>();
            map.put("code", code);
            map.put("desc", desc);
            results.add(map);
        }
        return results;
    }

    static Map<String,String> enum2Map(Integer code,String desc){
        Map<String, String> result = new HashMap<>();
        result.put("code", String.valueOf(code));
        result.put("desc",desc);
        return result;
    }
}
