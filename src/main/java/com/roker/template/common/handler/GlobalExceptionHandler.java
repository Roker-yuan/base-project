package com.roker.template.common.handler;

import com.roker.template.common.enums.ExceptionEnum;
import com.roker.template.common.utils.dataUtil.ResponseData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

/**
 * @Author Roker
 * @Date 2020/08/14 14:40
 * @Title GlobalExceptionHandler
 * @Description 全局异常管理器
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 入参参数校验-Exception
     * @param exception
     * @return
     * 不带任何参数访问接口,会抛出 BindException
     */
    @ExceptionHandler(value = BindException.class)
    public ResponseData argumentBindException(BindException exception) {
        String message = exception.getAllErrors().get(0).getDefaultMessage();
        return ResponseData.failed(message);
    }

    /**
     * 入参必填项校验-Exception
     * @param exception
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseData argumentValidatedException(MethodArgumentNotValidException exception) {
        String message = exception.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        return ResponseData.failed(ExceptionEnum.ARGUMENT_VALIDATED_EXCEPTION.code(),ExceptionEnum.ARGUMENT_VALIDATED_EXCEPTION.desc() + message);
    }

    /**
     * 参数类型错误
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseData methodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
        log.error("错误信息{}", e.getLocalizedMessage());
        return ResponseData.failed(ExceptionEnum.ARGUMENT_TYPE_MISMATCH);
    }

    /**
     * 参数格式错误
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseData httpMessageNotReadable(HttpMessageNotReadableException e) {
        log.error("参数格式错误:{}", e.getLocalizedMessage());
        return ResponseData.failed(ExceptionEnum.FORMAT_ERROR);
    }


    /**
     * 空指针异常
     * @param exception
     * @return
     */
    @ResponseBody
    @ExceptionHandler(NullPointerException.class)
    public ResponseData nullPointerException(NullPointerException exception) {
        exception.printStackTrace();
        return ResponseData.failed(ExceptionEnum.NULL_POINTER_EXCEPTION);
    }

    /**
     * 请求方式不支持
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseData httpReqMethodNotSupported(HttpRequestMethodNotSupportedException e) {
        log.error("错误信息:{}", e.getLocalizedMessage());
        return ResponseData.failed(ExceptionEnum.REQ_METHOD_NOT_SUPPORT);
    }

    /**
     * 通用异常
     */
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(Exception.class)
    public ResponseData exception(Exception e) {
        e.printStackTrace();
        return ResponseData.failed(ExceptionEnum.UNKNOWN_EXCEPTION);
    }


}
