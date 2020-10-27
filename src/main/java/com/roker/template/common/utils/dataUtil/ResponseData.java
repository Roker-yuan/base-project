package com.roker.template.common.utils.dataUtil;

import com.roker.template.common.enums.HttpEnum;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author 刘鹏远
 * @date 2020/06/01
 * 功能描述：响应信息主体
 */

/**
 * <b><code>ResponseResult</code></b>
 * <p>
 * Description响应信息主体
 * </p>
 * <b>Creation Time:</b> 2019/11/26 17:55.
 *
 * @author chensen
 * @since gempile-boiler-code 0.1.0
 */

@Data
@Accessors(chain = true)
public class ResponseData<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    /** 状态码 */
    @Getter
    @Setter
    private int code;
    /** 状态信息 */
    @Getter
    @Setter
    private String message;
    /** 响应数据 */
    @Getter
    @Setter
    private T data;

    public static <T> ResponseData<T> ok() {
        return restResult(null, HttpEnum.OK_200.code(), HttpEnum.OK_200.desc());
    }

    public static <T> ResponseData<T> ok(T data) {
        return restResult(data, HttpEnum.OK_200.code(), HttpEnum.OK_200.desc());
    }

    public static <T> ResponseData<T> ok(T data, String msg) {
        return restResult(data, HttpEnum.OK_200.code(), msg);
    }

    public static <T> ResponseData<T> failed() {
        return restResult(null, HttpEnum.ERROR_500.code(),
                HttpEnum.ERROR_500.desc());
    }

    public static <T> ResponseData<T> failed(String msg) {
        return restResult(null, HttpEnum.ERROR_500.code(), msg);
    }

    public static <T> ResponseData<T> failed(int code, String msg) {
        return restResult(null, code, msg);
    }

    public static <T> ResponseData<T> failed(T data) {
        return restResult(data, HttpEnum.ERROR_500.code(),
                HttpEnum.ERROR_500.desc());
    }

    public static <T> ResponseData<T> failed(T data, String msg) {
        return restResult(data, HttpEnum.ERROR_500.code(), msg);
    }

    public static <T> ResponseData<T> failed(HttpEnum enumCode) {
        return restResult(null,enumCode.code(),enumCode.desc());
    }

    private static <T> ResponseData<T> restResult(T data, int code,String msg) {
        ResponseData<T> apiResult = new ResponseData<>();
        apiResult.setCode(code);
        apiResult.setData(data);
        apiResult.setMessage(msg);
        return apiResult;
    }

    private  T getResult () {
        return this.data;
    }





}
