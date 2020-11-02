package com.roker.template.common.utils;

import lombok.extern.slf4j.Slf4j;

/**
 * @author roker
 * Date: 2020年11月2日11:47:39
 * Description: 获取当前方法和行号
 * 使用说明：
 *      该工具类配合全局异常管理中的自定义异常使用，快速准确定位异常发生位置
 */
@Slf4j
public class MethodUtil {

    /**
     * 私有化工具类 防止被实例化
     */
    private MethodUtil() {
    }

    public static String getLineInfo() {
        StackTraceElement ste = new Throwable().getStackTrace()[1];
        return ste.getFileName() + " -> " + ste.getLineNumber() + "行";
    }

}
