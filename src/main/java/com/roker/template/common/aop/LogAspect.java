package com.roker.template.common.aop;

import com.roker.template.common.utils.FastJsonUtil;
import com.roker.template.common.utils.dataUtil.ResponseData;
import eu.bitwalker.useragentutils.UserAgent;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 * @author Roker
 * @date 2020/10/23 15:03:13
 * 功能描述：AOP统一日志管理
 */

@Slf4j
@Aspect
@Component
public class LogAspect {

    private static final String START_TIME = "request-start";


    /**切面点*/
    private final String POINT_CUT = "execution(public * com.roker.template.controller..*.*(..))";
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.sss");


    // 切入点  即 aop 切入的路径（被拦截的方法）
    @Pointcut(POINT_CUT)
    public void aspectPoint() {

    }

    /**
     * 前置通知
     */
    // 指定切入点 与上面定义的一样
    @Before("aspectPoint()")
    public void LogRequestInfo(JoinPoint joinPoint) throws Exception {

        // 执行controller 方法之前需要记录的请求信息
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        log.info("【URL】: {}; 【HTTP_METHOD】: {}; 【IP】: {}; 【CLASS_METHOD】: {}",request.getRequestURL(),request.getMethod(),request.getRemoteAddr(),joinPoint.getSignature().getName());
        log.info("【请求时间】: {}", sdf.format(new Date()));
//        log.info("【请求参数】: {}", FastJsonUtil.paramToString(request.getParameterMap()));
        log.info("【请求参数】: {}", FastJsonUtil.paramToString(joinPoint.getArgs()));
        Long start = System.currentTimeMillis();
        request.setAttribute(START_TIME, start);
    }


    /**
     * 后置通知
     */
    @AfterReturning(returning = "apiResult", pointcut = "aspectPoint()")
    public void logResultVOInfo(ResponseData apiResult) throws Exception {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = Objects.requireNonNull(attributes).getRequest();
        log.info("【响应数据】：{}",apiResult);
        log.info("【响应时间】: {}", sdf.format(new Date()));
        Long start = (Long) request.getAttribute(START_TIME);
        Long end = System.currentTimeMillis();
        log.info("【请求耗时】：{}毫秒", end - start);
        String header = request.getHeader("User-Agent");
        UserAgent userAgent = UserAgent.parseUserAgentString(header);
        log.info("【浏览器类型】：{}，【操作系统】：{}，【原始User-Agent】：{}", userAgent.getBrowser().toString(), userAgent.getOperatingSystem().toString(), header);

    }

}
